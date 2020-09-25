package br.com.fiap.pousada.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.fiap.pousada.domain.Quarto;
import br.com.fiap.pousada.domain.Reserva;
import br.com.fiap.pousada.exception.LoadFileException;
import br.com.fiap.pousada.helper.FileHelper;

public class ReservaDAO {
	
private Connection conn;
	
	private void conecta() throws SQLException {
		try {
			Properties props = FileHelper.loadProperties();
			this.conn = DriverManager.getConnection(
					props.getProperty("database.url"),
					props.getProperty("database.user"),
					props.getProperty("database.password")
			);
		} catch (LoadFileException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Reserva> consultaTodas() throws SQLException {
		List<Reserva> reservas = new ArrayList<>();
		this.conecta();
		
		String sql = "select * from tb_reserva";
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Long id = rs.getLong("id");
			Integer numeroQuarto = rs.getInt("id_quarto");
			LocalDate dataEntrada = rs.getDate("data_entrada").toLocalDate();
			LocalDate dataSaida = rs.getDate("data_saida").toLocalDate();
			Integer qtdePessoas = rs.getInt("qtde_pessoas");
			
			Quarto quarto = new QuartoDAO().consultaPorNumero(numeroQuarto);
			
			reservas.add(new Reserva(id, quarto, dataEntrada, dataSaida, qtdePessoas));
		}
		
		
		this.desconecta();		
		return reservas;
	}
	
	public Reserva salva(Reserva reserva) throws SQLException {
		this.conecta();
		
		String sql = "select sq_reserva.nextval as id from dual";
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Long id = null;
		if(rs.next()) id = rs.getLong("id");
		
		if(id == null) throw new SQLException("Não foi possível gerar um identificador de reserva");
		
		reserva.setId(id);
		
		sql = "insert into tb_reserva(id, id_quarto, data_entrada, data_saida, qtde_pessoas)"
				+ "values(?, ?, ?, ?, ?)";
		stmt = this.conn.prepareStatement(sql);
		
		stmt.setLong(1, reserva.getId());
		stmt.setInt(2, reserva.getQuarto().getNumero());
		stmt.setDate(3, Date.valueOf(reserva.getDataEntrada()));
		stmt.setDate(4, Date.valueOf(reserva.getDataSaida()));
		stmt.setInt(5, reserva.getQtdePessoas());
		
		stmt.executeUpdate();
		
		this.desconecta();
		
		return reserva;
	}
	
	private void desconecta() throws SQLException {
		if(!conn.isClosed()) conn.close();
	}

}

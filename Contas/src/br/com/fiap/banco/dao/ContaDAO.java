package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.domain.Conta;
import br.com.fiap.banco.exception.AtualizaSaldoException;
import br.com.fiap.banco.exception.CadastroContaException;
import br.com.fiap.banco.exception.ConexaoException;


/**
 * 
 * <p>Essa é uma classe que faz conexão com o banco de dados e manipulação dos dados referente a classe
 * {@link br.com.fiap.banco.domain.Conta}.</p>
 * 
 * @author Andrey Masiero
 * @version 1.0
 *
 */
public class ContaDAO {
	
	/**
	 * Conexão com o banco de dados
	 */
	private Connection conn;
	
	public void conecta() throws ConexaoException {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new ConexaoException("Não foi possível realizar a conexão com o banco de dados");
		}
	}
	
	/**
	 * 
	 * <p>Salva a conta no banco de dados</p>
	 * <p>Para mais detalhes, acesse a descrição completa do método na <a href="https://xkcd.com/2358/">documentação</a></p>
	 * 
	 * @param conta objeto do tipo {@link br.com.fiap.banco.domain.Conta} que será enviado ao banco de dados.
	 * @return conta atualizada com o id gerado no banco de dados.
	 * @throws CadastroContaException caso ocorra um problema ao cadastrar a conta.
	 * 
	 * @since 1.0
	 * @see <a href="https://xkcd.com/2349/">TASK #1 - Backlog Semana 2</a>
	 */
	public Conta salva(Conta conta) throws CadastroContaException {
		try {
			conecta();
			String sqlConsultaId = "SELECT SQ_CONTA.NEXTVAL AS ID FROM DUAL";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsultaId);
			if(rs.next()) conta.setId(rs.getInt("ID"));
			
			String sqlInsert = "INSERT INTO TB_CONTA(ID, NUMERO, NOME_TITULAR, CPF, ATIVO, SALDO) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sqlInsert);
			
			pStmt.setInt(1, conta.getId());
			pStmt.setString(2, conta.getNumero().toString());
			pStmt.setString(3, conta.getNomeTitular());
			pStmt.setString(4, conta.getCpf());
			pStmt.setBoolean(5, conta.getAtivo());
			pStmt.setDouble(6, conta.getSaldo());
			
			pStmt.executeUpdate();
			
			return conta;
		} catch(ConexaoException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CadastroContaException("Não foi possível cadastrar a sua conta.");
		} finally {
			desconecta();
		}
	}
	
	public List<Conta> consultaTodas() throws CadastroContaException {
		try {
			conecta();
			List<Conta> contas = new ArrayList<>();
			String sql = "SELECT * FROM TB_CONTA";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Integer id = rs.getInt("ID");
				Integer numero = Integer.parseInt(rs.getString("NUMERO"));
				String nomeTitular = rs.getString("NOME_TITULAR");
				String cpf = rs.getString("CPF");
				Boolean ativo = rs.getBoolean("ATIVO");
				Double saldo = rs.getDouble("SALDO");
				
				contas.add(new Conta(id, numero, nomeTitular, cpf, ativo, saldo));
			}
			return contas;
		} catch(ConexaoException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CadastroContaException("Não foi possível consultar a base de contas.");
		} finally {
			desconecta();
		}
	}
	
	public void atualizaSaldo(Conta conta) throws AtualizaSaldoException {
		try {
			conecta();
			String sql = "UPDATE TB_CONTA SET SALDO = ? WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setDouble(1, conta.getSaldo());
			pStmt.setInt(2, conta.getId());
			
			pStmt.executeUpdate();
		} catch(ConexaoException | SQLException e) {
			System.out.println(e.getMessage());
			throw new AtualizaSaldoException("Não foi possível atualizar o saldo.");
		} finally {
			desconecta();
		}
	}
	
	public void desconecta() {
		try {
			if(!conn.isClosed()) conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}

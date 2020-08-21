package br.com.fiap.todo;

import java.sql.*;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		
		// OJDBC -> Oracle Java Database Conectivity
		try {
			// Carregar o driver na memória
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Criar a conexão com o banco de dados
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system", "system");
			
			System.out.println("Conexão com o banco de dados efetuada com sucesso.");
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into tb_tarefa(id, descricao, data_limite)"
					+ "values(sq_tarefa.nextval, 'Deitar e dormir', "
					+ "to_date('19/08/2020', 'dd/mm/yyyy'))");
			
			stmt.executeUpdate("update tb_tarefa set feita = 1 where descricao like '%Deitar%'");
			
			stmt.executeUpdate("delete from tb_tarefa where id = 2");
			
			ResultSet rs = stmt.executeQuery("select * from tb_tarefa");
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				LocalDate dataLimite = rs.getDate("data_limite").toLocalDate();
				Boolean feita = rs.getBoolean("feita");
				
				System.out.println("Tarefa = { " + id + ", " + descricao + ", " + 
						dataLimite.toString() + ", " +  feita + " }");
			}
			
			// Fechar a conexão com o banco de dados
			conn.close();
			
		} catch(ClassNotFoundException e) {
			System.err.printf("Não foi possível localizar o driver: %s", e.getMessage());
		} catch(SQLException e) {
			System.err.println("Ocorreu um erro na conexão com o banco de dados");
			System.err.println(e.getMessage());
		}
		
	}

}

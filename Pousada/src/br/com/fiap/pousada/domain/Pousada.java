package br.com.fiap.pousada.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pousada.dao.ReservaDAO;

public class Pousada {
	
	List<Reserva> reservas;
	
	public Pousada() {
		this.reservas = new ArrayList<>();
	}
	
	public void atualiza() throws ClassNotFoundException, SQLException {
		reservas = new ReservaDAO().consultaTodas();
	}
	
	public void efetuaReserva(Reserva reserva) throws ClassNotFoundException, SQLException {
		new ReservaDAO().salva(reserva);
		reservas.add(reserva);
	}

}

package br.com.fiap.pousada.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pousada.dao.ReservaDAO;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.validation.ReservaValidator;

public class Pousada {
	
	List<Reserva> reservas;
	
	public Pousada() {
		this.reservas = new ArrayList<>();
	}
	
	public void atualiza() throws ClassNotFoundException, SQLException {
		reservas = new ReservaDAO().consultaTodas();
	}
	
	public void efetuaReserva(Reserva reserva) throws ClassNotFoundException, SQLException, ReservaException {
		
		ReservaValidator.validaCapaciadadeMaximaDeQuartos(reservas, reserva.getQuarto().getCategoria());
		ReservaValidator.validaDataEntrada(reserva);
		ReservaValidator.validaDataSaida(reserva);
		ReservaValidator.validaQuantidadePessoas(reserva);
		
		reserva = new ReservaDAO().salva(reserva);
		reservas.add(reserva);
	}
	
	public List<Reserva> consultaReservas() {
		return reservas;
	}

}

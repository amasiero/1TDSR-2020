package br.com.fiap.banco.domain;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.banco.dao.ContaDAO;
import br.com.fiap.banco.exception.AtualizaSaldoException;
import br.com.fiap.banco.exception.CadastroContaException;

public class Banco {
	
	private List<Conta> contas;
	
	public Banco() throws CadastroContaException {
		contas = new ContaDAO().consultaTodas();
	}
	
	public void adicionaConta(Conta conta) throws CadastroContaException {
		ContaDAO dao = new ContaDAO();
		conta = dao.salva(conta);
		contas.add(conta);
	}
	
	public boolean transferencia(Conta origem, Conta destino, Double valor) throws AtualizaSaldoException {
		boolean foiEfetuado =  origem.transfere(valor, destino);
		if(foiEfetuado) {
			ContaDAO dao = new ContaDAO();
			dao.atualizaSaldo(origem);
			dao.atualizaSaldo(destino);
		}
		return foiEfetuado;
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	public void atualiza() throws CadastroContaException {
		contas = new ContaDAO().consultaTodas();
	}

	public Conta buscaConta(Integer numero) {
		List<Conta> filtrado = contas.stream()
				.filter(conta -> conta.getNumero().equals(numero))
				.collect(Collectors.toList());
		
		return filtrado.size() == 1 ? filtrado.get(0) : null;
	}
}

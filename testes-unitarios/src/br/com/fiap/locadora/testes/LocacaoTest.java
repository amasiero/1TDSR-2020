package br.com.fiap.locadora.testes;

import br.com.fiap.locadora.exceptions.LocacaoException;
import br.com.fiap.locadora.exceptions.VeiculoNaoDisponivelException;
import br.com.fiap.locadora.models.Cliente;
import br.com.fiap.locadora.models.Locacao;
import br.com.fiap.locadora.models.Veiculo;
import br.com.fiap.locadora.services.LocacaoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static br.com.fiap.locadora.utils.DataUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LocacaoTest {

    private LocacaoService service;

    @Rule
    public ErrorCollector erros = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup(){
        service =  new LocacaoService();
        System.out.println("Setup executado com sucesso!");
    }

    @Test
    public void testAlugaCarro() throws LocacaoException, VeiculoNaoDisponivelException {
        // Cenário
        Cliente cliente = new Cliente("Andrey");
        Veiculo veiculo = new Veiculo("Dodge Challenger SRT8", 3, 140.0);

        // Ação
        Locacao locacao = service.alugaCarro(cliente, veiculo);

        // Validação
        erros.checkThat(locacao.getValor(), is(equalTo(140.0)));
        erros.checkThat(ehMesmaData(locacao.getDataRetirada(), LocalDate.now()), is(true));
        erros.checkThat(ehMesmaData(locacao.getDataEntrega(), obterDataComDiferencaDias(3)), is(true));
    }

    @Test(expected = VeiculoNaoDisponivelException.class)
    public void testeVeiculoNaoDisponivel() throws Exception {
        Cliente cliente = new Cliente("Andrey");
        Veiculo veiculo = new Veiculo("Dodge Challenger SRT8", 0, 140.0);

        service.alugaCarro(cliente, veiculo);

    }

    @Test
    public void testeClienteVazio() throws VeiculoNaoDisponivelException {
        Veiculo veiculo = new Veiculo("Dodge Challenger SRT8", 1, 140.0);

        try {
            service.alugaCarro(null, veiculo);
            fail();
        } catch (LocacaoException e) {
            assertEquals("Cliente não informado.", e.getMessage());
        }

    }

    @Test
    public void testeVeiculoVazio() throws VeiculoNaoDisponivelException, LocacaoException {
        Cliente cliente = new Cliente("Andrey");

        exception.expect(LocacaoException.class);
        exception.expectMessage("Veículo não informado.");
        service.alugaCarro(cliente, null);
    }

    @After
    public void finaliza() {
        System.out.println("O teste foi finalizado.");
    }

}

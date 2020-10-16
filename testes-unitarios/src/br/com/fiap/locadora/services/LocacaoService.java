package br.com.fiap.locadora.services;

import br.com.fiap.locadora.models.Cliente;
import br.com.fiap.locadora.models.Locacao;
import br.com.fiap.locadora.models.Veiculo;

import java.time.LocalDate;

import static br.com.fiap.locadora.utils.DataUtils.*;

public class LocacaoService {

    public Locacao alugaCarro(Cliente cliente, Veiculo veiculo) {
        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setDataRetirada(LocalDate.now());
        locacao.setDataEntrega(adicionaDias(LocalDate.now(), 3));
        locacao.setValor(veiculo.getValor());

        // Código para salvar no banco de dados, validações, etc...

        return locacao;
    }

    public static void main(String... args) {
        // Cenário
        LocacaoService service =  new LocacaoService();
        Cliente cliente = new Cliente("Andrey");
        Veiculo veiculo = new Veiculo("Dodge Challenger SRT8", 3, 140.0);

        // Ação
        Locacao locacao = service.alugaCarro(cliente, veiculo);

        // Validação
        System.out.println(locacao.getValor() == 140.0);
        System.out.println(ehMesmaData(locacao.getDataRetirada(), LocalDate.now()));
        System.out.println(ehMesmaData(locacao.getDataEntrega(), obterDataComDiferencaDias(3)));
    }

}

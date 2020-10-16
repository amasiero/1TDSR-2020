package br.com.fiap.locadora.testes;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {

    private static int contador = 0;

    @Test
    public void teste01IniciaContador() {
        contador = 1;
    }

    @Test
    public void teste02VerificaContador() {
        Assert.assertEquals(1, contador);
    }

}

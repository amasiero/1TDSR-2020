package br.com.fiap.locadora.testes;

import br.com.fiap.locadora.models.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void testeNumerosInteirosIguais() {
        int i = 5;
        Integer j = 5;
        assertEquals(Integer.valueOf(i) , j);
        assertEquals(2, 2);
    }

    @Test
    public void testeNumerosInteirosDiferentes() {
        assertNotEquals(2, 3);
    }

    @Test
    public void testeNumerosReaisIguais() {
        assertEquals(0.512624, 0.512, 0.001);
        assertEquals(Math.PI, 3.14, 0.01);
    }

    @Test
    public void testeTextosIguais() {
        assertTrue("c3".equalsIgnoreCase("C3"));
    }

    @Test
    public void testeTextosDiferentes() {
        assertFalse("Romário".startsWith("Jo"));
    }

    @Test
    public void testeMesmaInstancia() {
        Cliente c1 = new Cliente("Andrey");
        assertSame(c1, c1);
    }

    @Test
    public void testeInstanciasDiferentes() {
        Cliente c1 = new Cliente("Andrey");
        Cliente c2 = new Cliente("Andrey");
        assertNotSame(c1, c2);
    }

    @Test
    public void testeObjetoNulo() {
        Cliente c1 = null;
        assertNull(c1);
    }

    @Test
    public void testeObjetoNaoNulo() {
        Cliente c1 = new Cliente("Andrey");
        assertNotNull(c1);
    }

}

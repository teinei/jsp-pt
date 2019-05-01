package model;
// // test/model/*.java

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class RepositorioTest {

    public RepositorioTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void buscarPalavraVaziaTest() {
        Repositorio repositorio = new Repositorio();
        String resultado = repositorio.buscarPlavra("");
        assertEquals(resultado, "");
    }

    @Test
    public void buscarPalavraNulaTest() {
        Repositorio repositorio = new Repositorio();
        String resultado = repositorio.buscarPlavra(null);
        assertNull(resultado);
    }
    
    @Test
    public void buscarPalavraInexistenteTest() {
        Repositorio repositorio = new Repositorio();
        String resultado = repositorio.buscarPlavra("carro");
        assertEquals(resultado, "carro");
    }
    
    @Test
    public void buscarPalavraExistenteTest() {
        Repositorio repositorio = new Repositorio();
        String resultado = repositorio.buscarPlavra("menina");
        assertEquals(resultado, "girl");
        
        String resultado2 = repositorio.buscarPlavra("girl");
        assertEquals(resultado2, "menina");
    }

}

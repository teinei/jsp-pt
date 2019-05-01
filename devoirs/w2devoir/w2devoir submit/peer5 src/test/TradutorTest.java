package model;

/*
    test/model/*.java
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class TradutorTest {

    public TradutorTest() {
    }

    @Test
    public void traduzirSemString() {
        RepositorioMock repositorio = new RepositorioMock();
        Tradutor tradutor = new Tradutor(repositorio);
        
        repositorio.setResultadoBuscarPlavra("");
        
        String resultado = tradutor.traduzir("");
        assertEquals(resultado, "");
        
        repositorio.verificarBuscarPalavra(true);
    }

}

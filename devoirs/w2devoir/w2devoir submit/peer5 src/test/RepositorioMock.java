package model;
// test/model/*.java
//

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class RepositorioMock implements IRepositorio {

    private String resultadoBuscarPlavra;
    private boolean buscarPalavraExecutado = false;

    public RepositorioMock() {
    }

    @Override
    public String buscarPlavra(String chave) {
        this.buscarPalavraExecutado = true;
        return resultadoBuscarPlavra;
    }

    public void setResultadoBuscarPlavra(String resultadoBuscarPlavra) {
        this.resultadoBuscarPlavra = resultadoBuscarPlavra;
    }

    public void verificarBuscarPalavra(boolean foiExecutado) {
        assertEquals(foiExecutado, buscarPalavraExecutado);
    }

}

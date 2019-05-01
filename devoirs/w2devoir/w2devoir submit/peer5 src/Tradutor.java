package model;

/*
    src/java/model/*.java
 */
public class Tradutor {

    private final IRepositorio repositorio;

    public Tradutor(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    
    public String traduzir(String palavra) {
        return repositorio.buscarPlavra(palavra);
    }

}

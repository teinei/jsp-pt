// src/java/model/*.java

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class Repositorio implements IRepositorio {

    private String realPath = "arquivo.txt";

    public Repositorio() {
    }

    public Repositorio(String realPath) {
        this.realPath = realPath;
    }

    @Override
    public String buscarPlavra(String chave) {
        return varrerArquivo(chave);
    }

    private String varrerArquivo(String chave) {
        if (chave == null) {
            return null;
        }
        try {
            Scanner scan = new Scanner(new File(realPath));
            while (scan.hasNextLine()) {               
                    String linha[] = scan.nextLine().split(" ");
                    if (chave.equalsIgnoreCase(linha[0])) {
                        return linha[1];
                    } else if (chave.equalsIgnoreCase(linha[1])) {
                        return linha[0];
                    }               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chave;
    }

}

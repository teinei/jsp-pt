// src/java/controller/*.java
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Repositorio;
import model.Tradutor;

/**
 *
 * @author Rafael Benzaquem Neto
 */
@WebServlet(name = "TradutorServlet", urlPatterns = {"/tradutor"})
public class TradutorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Tradutor tradutor = new Tradutor(new Repositorio(request.getRealPath("arquivo.txt")));

        String chave = request.getParameter("chave");
        request.setAttribute("chave", request.getParameter("chave"));
        request.setAttribute("resultado", tradutor.traduzir(chave));
        request.getRequestDispatcher("view.jsp").forward(request, response);
             
    }

}

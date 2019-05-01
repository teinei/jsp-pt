// src/java/*.java
// peer 4

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/traducaoServlet"})
public class traduzirServlet extends HttpServlet { 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String palavraTraduzida = "";
        String palavra = "";
        
        if(request.getAttribute("bancoDadosTraducoes") == null){
            String filename = getServletContext().getRealPath("WEB-INF/traducoes.xml");
            request.setAttribute("bancoDadosTraducoes", new Armazenamento(filename));          
        }
        
        palavra = (String) request.getParameter("palavra");
        request.setAttribute("palavraPortugues", palavra);
        
        if(palavra != null){
            palavraTraduzida = ((Armazenamento) request.getAttribute("bancoDadosTraducoes")).getPalavraTraduzida(palavra);            
        }
        
        request.setAttribute("palavraTraduzida", palavraTraduzida);
        
        request.getRequestDispatcher("ApresentaPalavra.jsp").forward(request, response);        
    }    
}

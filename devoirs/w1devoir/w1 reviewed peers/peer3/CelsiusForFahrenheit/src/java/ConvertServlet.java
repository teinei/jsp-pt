
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aguinaldobarbosa
 */
@WebServlet(urlPatterns = {"/converter"})
public class ConvertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resultado = "";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String typeofConversion = request.getParameter("type");
            float valor = Float.parseFloat(request.getParameter("graus"));
            if((!typeofConversion.equals("N")) && (valor > 0.0)){
               if(typeofConversion.equals("F")){
                   float t = (valor * 9) / 5 + 32;
                   resultado = "O Resultado da conversão é: "+ t;
               } 
               
               if(typeofConversion.equals("C")){
                   float t = (valor - 32) * 5 / 9;
                   resultado = "O Resultado da conversão é: "+ t;
               }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado da conversão</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+ resultado + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}

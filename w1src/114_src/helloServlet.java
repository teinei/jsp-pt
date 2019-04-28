/* 
file: src/java/helloServlet.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Johnny
 */
@WebServlet("/helloServlet")
public class helloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String name = request.getParameter("nom");
        if(name == null ||name.equals("")) {
            name = "default";
            response.getWriter().print("<html>");
            response.getWriter().print("<h1>please type in your name</h1>");
            response.getWriter().print("<a href='index.html'>back to home</a>");
            response.getWriter().print("</html>");
        }else{
            response.getWriter().print("<html><h1>Hello/Oi >> "+name+"!</h1></html>");
        }
        //
    }
    //
}

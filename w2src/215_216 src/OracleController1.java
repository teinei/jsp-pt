/*
file: file: src/java/OracleController1.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coursera
 */
@WebServlet("/oracleController1") 
            // (1)oracleController1
public class OracleController1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String productType = request.getParameter("product_html");
        //                                     // (2)product_html
        Oracle oracle = new Oracle();
        List<String> productsOfTheType = oracle.bestProducts(productType);
        //request.setAttribute(varnom-servlet2jsp, valuepassed);
        request.setAttribute("productsList_servlet", productsOfTheType);
        //              // (3)productsList_servlet
        //
        request.getRequestDispatcher("respose1.jsp").forward(request, response);
        //                         (4)respose1.jsp
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

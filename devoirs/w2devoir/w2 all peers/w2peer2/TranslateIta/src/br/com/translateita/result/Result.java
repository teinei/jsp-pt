package br.com.translateita.result;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe 'code behind' responsável pela lógica da conversão.
 * 
 * @author Luiz Foli
 * @since 20/12/2018
 *
 */

@WebServlet("/result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Traducoes trad = new Traducoes();
		trad.setJsonPath(getServletContext().getRealPath("WEB-INF\\classes\\br\\com\\translateita\\result\\traducoes.json").toString());

		String palavraEmIngles = "";
		
		System.out.println();
		
		try {
			palavraEmIngles = trad.retornaPalavraEmIngles(req.getParameter("palavra"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("palavra", req.getParameter("palavra"));
		req.setAttribute("palavraEmIngles", palavraEmIngles);

		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}

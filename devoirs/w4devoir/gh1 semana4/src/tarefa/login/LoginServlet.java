package tarefa.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginn")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		try {
			
			Autenticador a = new Autenticador();
			String nomeUsuario = a.autenticar(login, senha);
			req.setAttribute("nome", nomeUsuario);
			req.getRequestDispatcher("/tarefalogin/sucesso.jsp").forward(req, resp);
			
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			req.getRequestDispatcher("/tarefalogin/falha.jsp").forward(req, resp);
		}
		
	}
}

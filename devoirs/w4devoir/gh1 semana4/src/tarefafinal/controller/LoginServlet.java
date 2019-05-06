package tarefafinal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tarefafinal.dao.UsuarioDAO;
import tarefafinal.exception.AutenticadorException;
import tarefafinal.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession(false);
		if (sessao != null) {
			sessao.invalidate();
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		UsuarioDAO usuDAO = new UsuarioDAO();

		try {

			String nomeUsuario = usuDAO.autenticar(login, senha);
			if (!nomeUsuario.isEmpty()) {
				Usuario usuarioLogado = usuDAO.recuperarUsuarioPeloLogin(login);
				if (req.getSession(false).getAttribute("usuarioLogado") == null) {
					req.getSession().setAttribute("usuarioLogado", usuarioLogado);
				}
				resp.sendRedirect("topicos");
			}

		} catch (AutenticadorException e) {
			req.setAttribute("info", e.getMessage());
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
}

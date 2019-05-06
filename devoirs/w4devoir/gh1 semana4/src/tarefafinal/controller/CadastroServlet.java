package tarefafinal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tarefafinal.dao.UsuarioDAO;
import tarefafinal.model.Usuario;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		if (login.isEmpty() || nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
			req.setAttribute("info", "Todos os campos são obrigatórios");
			req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
		} else {
			Usuario u = new Usuario();
			u.setNome(nome);
			u.setLogin(login);
			u.setEmail(email);
			u.setSenha(senha);
			u.setPontos(0);

			new UsuarioDAO().inserirUsuario(u);

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}

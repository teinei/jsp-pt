package tarefafinal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tarefafinal.dao.UsuarioDAO;
import tarefafinal.model.Usuario;

@WebServlet("/ranking")
public class RakingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if (usuario == null) {
			resp.sendRedirect("login");
		} else {
			UsuarioDAO usuDAO = new UsuarioDAO();
			List<Usuario> rankingUsuarios = usuDAO.rankingUsuarios();
			
			req.setAttribute("rankingUsuarios", rankingUsuarios);
			req.getRequestDispatcher("ranking.jsp").forward(req, resp);
		}
	}
}

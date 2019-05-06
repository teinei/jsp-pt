package tarefafinal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tarefafinal.dao.TopicoDAO;
import tarefafinal.dao.UsuarioDAO;
import tarefafinal.model.Topico;
import tarefafinal.model.Usuario;

@WebServlet("/topicos")
public class TopicoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TopicoDAO topicoDAO = new TopicoDAO();

		// carregar os topicos do usuario
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if (usuario == null) {
			resp.sendRedirect("login");
		} else {
			List<Topico> topicos = topicoDAO.recuperaTodosTopicos();

			req.setAttribute("topicos", topicos);
			req.getRequestDispatcher("topicos.jsp").forward(req, resp);
		}
	}
}

package tarefafinal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tarefafinal.dao.ComentarioDAO;
import tarefafinal.dao.TopicoDAO;
import tarefafinal.dao.UsuarioDAO;
import tarefafinal.model.Comentario;
import tarefafinal.model.Topico;
import tarefafinal.model.Usuario;

@WebServlet("/exibirTopico")
public class TopicoExibirServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if (usuario == null) {
			resp.sendRedirect("login");
		} else {
			Integer id = Integer.parseInt(req.getParameter("id_topico"));

			TopicoDAO topicoDAO = new TopicoDAO();
			ComentarioDAO comentarioDAO = new ComentarioDAO();
			
			Topico topico = topicoDAO.recuperarTopicoPorId(id);
			List<Comentario> comentarios = comentarioDAO.recuperaComentariosDoTopico(id);

			req.setAttribute("topico", topico);
			req.setAttribute("qtdComentarios", comentarios.size());
			req.setAttribute("comentariosDoTopico", comentarios);
			req.getRequestDispatcher("topico-exibir.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String comentario = req.getParameter("comentario");
		Integer idTopico = Integer.parseInt(req.getParameter("idTopico"));

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");

		Comentario c = new Comentario();
		c.setComentario(comentario);
		c.setUsuario(usuario);
		c.setTopico(new TopicoDAO().recuperarTopicoPorId(idTopico));

		ComentarioDAO comentarioDAO = new ComentarioDAO();
		comentarioDAO.inserir(c);

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.adicionarPontos(usuario.getLogin(), 3);

		// atualizando o usuario settado na session
		req.getSession().setAttribute("usuarioLogado", usuDAO.recuperarUsuarioPeloLogin(usuario.getLogin()));

		resp.sendRedirect("exibirTopico?id_topico=" + idTopico);
	}

}

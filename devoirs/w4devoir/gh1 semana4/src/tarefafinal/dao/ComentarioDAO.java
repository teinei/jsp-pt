package tarefafinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tarefafinal.model.Comentario;
import tarefafinal.model.Topico;
import tarefafinal.model.Usuario;

public class ComentarioDAO {

	public List<Comentario> recuperaComentariosDoTopico(Integer idTopico) {
		List<Comentario> comentarios = new ArrayList<Comentario>();

		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "SELECT * FROM comentario WHERE id_topico = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, idTopico);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setIdComentario(rs.getInt("id_comentario"));
				comentario.setComentario(rs.getString("comentario"));
				comentario.setUsuario(new UsuarioDAO().recuperarUsuarioPeloLogin(rs.getString("login")));
				comentario.setTopico(new TopicoDAO().recuperarTopicoPorId(Integer.parseInt(rs.getString("id_topico"))));

				comentarios.add(comentario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comentarios;
	}

	public void inserir(Comentario comentario) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			if (comentario.getIdComentario() == null) {
				String sql = "INSERT INTO comentario (comentario, login, id_topico) VALUES (?,?,?)";
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1, comentario.getComentario());
				stmt.setString(2, comentario.getUsuario().getLogin());
				stmt.setInt(3, comentario.getTopico().getIdTopico());

				stmt.executeUpdate();
			} else {
				String sql = "INSERT INTO comentario (id_comentario, comentario, login, id_topico) VALUES (?,?,?,?)";
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setInt(1, comentario.getIdComentario());
				stmt.setString(2, comentario.getComentario());
				stmt.setString(3, comentario.getUsuario().getLogin());
				stmt.setInt(4, comentario.getTopico().getIdTopico());
				
				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

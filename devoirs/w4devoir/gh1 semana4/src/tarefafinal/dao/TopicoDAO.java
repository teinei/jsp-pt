package tarefafinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tarefafinal.model.Topico;

public class TopicoDAO {

	public List<Topico> recuperaTodosTopicos() {
		List<Topico> topicos = new ArrayList<Topico>();

		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "SELECT * FROM topico t INNER JOIN usuario u ON t.login = u.login";
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Topico t = new Topico();
				t.setIdTopico(rs.getInt("id_topico"));
				t.setTitulo(rs.getString("titulo"));
				t.setConteudo(rs.getString("conteudo"));
				t.setUsuario(new UsuarioDAO().recuperarUsuarioPeloLogin(rs.getString("login")));

				topicos.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return topicos;
	}

	public void inserirTopico(Topico t) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			if (t.getIdTopico() == null) {
				String sql = "INSERT INTO topico (titulo, conteudo, login) VALUES (?,?,?)";
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1, t.getTitulo());
				stmt.setString(2, t.getConteudo());
				stmt.setString(3, t.getUsuario().getLogin());

				stmt.executeUpdate();
			} else {
				String sql = "INSERT INTO topico (id_topico, titulo, conteudo, login) VALUES (?,?,?,?)";
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setInt(1, t.getIdTopico());
				stmt.setString(2, t.getTitulo());
				stmt.setString(3, t.getConteudo());
				stmt.setString(4, t.getUsuario().getLogin());

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Topico recuperarTopicoPorId(Integer id) {
		Topico topico = null;

		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "SELECT * FROM topico WHERE id_topico = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				topico = new Topico();
				topico.setIdTopico(rs.getInt("id_topico"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setConteudo(rs.getString("conteudo"));
				topico.setUsuario(new UsuarioDAO().recuperarUsuarioPeloLogin(rs.getString("login")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return topico;
	}
}

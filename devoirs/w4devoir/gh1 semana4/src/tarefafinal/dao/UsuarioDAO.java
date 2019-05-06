package tarefafinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tarefafinal.exception.AutenticadorException;
import tarefafinal.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserirUsuario(Usuario u) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "INSERT INTO usuario (login, email, nome, senha, pontos) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getNome());
			stmt.setString(4, u.getSenha());
			stmt.setInt(5, u.getPontos());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel executar o acesso", e);
		}
	}

	@Override
	public Usuario recuperarUsuarioPeloLogin(String login) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, login);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setPontos(rs.getInt("pontos"));

				return u;
			}

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel executar o acesso", e);
		}

		return null;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, pontos);
			stmt.setString(2, login);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel executar o acesso", e);
		}

	}

	@Override
	public List<Usuario> rankingUsuarios() {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
			PreparedStatement stmt = c.prepareStatement(sql);
			List<Usuario> lista = new ArrayList<Usuario>();

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setPontos(rs.getInt("pontos"));
				lista.add(u);
			}

			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel executar o acesso", e);
		}
	}

	public String autenticar(String login, String senha) throws AutenticadorException {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			PreparedStatement ps = c.prepareStatement("SELECT nome FROM usuario WHERE login = ? AND senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("nome");
			} else {
				throw new AutenticadorException("Login e/ou senha incorretos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

package tarefa.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Autenticador {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String autenticar(String login, String senha) throws Exception {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursera_usuarios", "root", "")) {

			PreparedStatement ps = c.prepareStatement("SELECT nome FROM usuario WHERE login = ? AND senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("nome");
			} else {
				throw new Exception("Não foi possivel autenticar o usuário!");
			}
		}
	}
}

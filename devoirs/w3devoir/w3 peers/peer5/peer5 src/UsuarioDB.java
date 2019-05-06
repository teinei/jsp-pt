/*
file: src/fontes/*.java
 */
package fontes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class UsuarioDB implements UsuarioDAO {
    
    private Connection conexao = null;
    
    private void iniciarConexao()
    {
        String url = "jdbc:mysql://mysqldb.c2figseifve5.sa-east-1.rds.amazonaws.com:3306/coursera";
        try {
            conexao = DriverManager.getConnection(url, "user","pass");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Usuario u) {
        iniciarConexao();
        String sqlQuery = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlQuery);
            statement.setString(1, u.getLogin());
            statement.setString(2, u.getEmail());
            statement.setString(3, u.getNome());
            statement.setString(4, u.getSenha());
            statement.setInt(5, u.getPontos());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public Usuario recuperar(String login) {
        iniciarConexao();
        String sqlQuery = "SELECT * FROM usuario WHERE login = ?;";
        Usuario usuarioConsulta = null;
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement(sqlQuery);
            statement.setString(1, login);
            ResultSet resultado = statement.executeQuery(sqlQuery);
            
            if (resultado.next()){
                usuarioConsulta = new Usuario();
                usuarioConsulta.setLogin(login);
                usuarioConsulta.setEmail(resultado.getString("email"));
                usuarioConsulta.setNome(resultado.getString("nome"));
                usuarioConsulta.setSenha(resultado.getString("senha"));
                usuarioConsulta.setPontos(resultado.getInt("pontos"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarioConsulta;
    }

    @Override
    public void adicionarPontos(String login, int pontos) {
        iniciarConexao();
        String sqlQuery = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlQuery);
            statement.setInt(1, pontos);
            statement.setString(2, login);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> ranking() {
        iniciarConexao();
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario registroUsuario = null;
        
        String sqlQuery = "SELECT * FROM usuario ORDER BY pontos DESC;";
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement(sqlQuery);
            ResultSet resultado = statement.executeQuery(sqlQuery);
            
            while (resultado.next()){
                registroUsuario = new Usuario();
                registroUsuario.setLogin(resultado.getString("login"));
                registroUsuario.setEmail(resultado.getString("email"));
                registroUsuario.setNome(resultado.getString("nome"));
                registroUsuario.setSenha(resultado.getString("senha"));
                registroUsuario.setPontos(resultado.getInt("pontos"));
                listaUsuarios.add(registroUsuario);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaUsuarios;
    }
}

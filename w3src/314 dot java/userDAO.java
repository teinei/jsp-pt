package en;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
	//
	static {
		//
		try{
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//
	}
	//
	public static List<User> allUsers(){
	    List<User> todos = new ArrayList<>();
	    try(Connection c = DriverManager.getConnection(
	    	//	"jdbc:postgresql://localhost/usuarios","postgres","crimson")){
	    	"jdbc:postgresql://localhost/users","postgres","crimson")){
	    	//
	    	String sql = "select login, nom, email from public.user";
	    	//String sql = "select login, nom, email from user";
	    	//String sql = "select login, nome, email from usuario";
	    	PreparedStatement stm = c.prepareStatement(sql);
	    	ResultSet rs = stm.executeQuery();
	    	while(rs.next()){
	    		User u = new User();
	    		u.setLogin(rs.getString("login"));
	    		u.setName(rs.getString("nom")); //must be the same as db name
	    		u.setEmail(rs.getString("email"));
	    		todos.add(u);
	    		//
	    	}
	    	//
	    }catch(SQLException e){
	    	//
	    	throw new RuntimeException("can not access 2", e);
	    }
	    return todos;
	}
	//
	public static void inserirUsuario(User u){
		//
		try(Connection c = DriverManager.getConnection(
	    		"jdbc:postgresql://localhost/usuarios","postgres","crimson")){
	    	//
	    	String sql = "INSERT INTO public.usuario(login, nome, email) VALUES (?,?,?);";
	    	PreparedStatement stm = c.prepareStatement(sql);
	    	//ResultSet rs = stm.executeQuery();
	    	stm.setString(1, u.getLogin());
	    	stm.setString(2, u.getName());
	    	stm.setString(3, u.getEmail());
	    	stm.executeUpdate();
	    	//
	    }catch(SQLException e){
	    	//
	    	throw new RuntimeException("Nao foi possivel acess", e);
	    }
		//
	}
	//
}

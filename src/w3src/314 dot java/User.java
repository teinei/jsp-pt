package en;

public class User {
	private String login;
	private String name;
	private String email;
	//
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//no toString, we will print
	///*
	@Override
	public String toString() {
		return "User [login=" + login + ", name=" + name + ", email=" + email + "]";
	}
	//*/
	//
}

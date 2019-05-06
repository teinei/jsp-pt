package tarefafinal.dao;

import java.util.List;

import tarefafinal.model.Usuario;

public interface IUsuarioDAO {

	// insere um novo usu�rio no banco de dados
	public void inserirUsuario(Usuario u);

	// recupera o usu�rio pelo seu login
	public Usuario recuperarUsuarioPeloLogin(String login);

	// adiciona os pontos para o usu�rio no banco
	public void adicionarPontos(String login, int pontos);

	// retorna a lista de usu�rios ordenada por pontos (maior primeiro)
	public List<Usuario> rankingUsuarios();
}

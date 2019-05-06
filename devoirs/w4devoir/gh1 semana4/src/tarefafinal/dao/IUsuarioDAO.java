package tarefafinal.dao;

import java.util.List;

import tarefafinal.model.Usuario;

public interface IUsuarioDAO {

	// insere um novo usuário no banco de dados
	public void inserirUsuario(Usuario u);

	// recupera o usuário pelo seu login
	public Usuario recuperarUsuarioPeloLogin(String login);

	// adiciona os pontos para o usuário no banco
	public void adicionarPontos(String login, int pontos);

	// retorna a lista de usuários ordenada por pontos (maior primeiro)
	public List<Usuario> rankingUsuarios();
}

package tarefafinal.model;

public class Topico {

	private Integer idTopico;
	private String titulo;
	private String conteudo;
	private Usuario usuario;
	
	public Integer getIdTopico() {
		return idTopico;
	}
	public void setIdTopico(Integer idTopico) {
		this.idTopico = idTopico;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Topico [idTopico=" + idTopico + ", titulo=" + titulo + ", conteudo=" + conteudo + ", usuario=" + usuario
				+ "]";
	}
	
}

package tarefafinal.teste.dbunit;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import tarefafinal.dao.TopicoDAO;
import tarefafinal.dao.UsuarioDAO;
import tarefafinal.model.Topico;
import tarefafinal.model.Usuario;

public class TesteDAO {

	JdbcDatabaseTester jdt;
	private static final String CAMINHO_INICIO = "/tarefafinal/teste/dbunit/inicio.xml";
	private static final String CAMINHO_VERIFICA = "/tarefafinal/teste/dbunit/verifica.xml";

	@Before
	public void setUp() throws Exception {
		this.jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/coursera_usuarios",
				"root", "");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		this.jdt.setDataSet(loader.load(CAMINHO_INICIO));
		this.jdt.onSetup();
	}

	@Test
	public void testeRankingDeUsuario() {
		List<Usuario> lista = new UsuarioDAO().rankingUsuarios();
		assertEquals(3, lista.size());
		assertEquals("teste", lista.get(0).getLogin());
	}

	@Test
	public void testeRecuperarUsuario() {
		Usuario u = new UsuarioDAO().recuperarUsuarioPeloLogin("teste");
		assertEquals("sobre@testando.com.br", u.getEmail());
	}

	@Test
	public void testeInserirUsuario() throws SQLException, Exception {
		Usuario u = new Usuario();
		u.setLogin("duda");
		u.setEmail("duda@hotmail.com.br");
		u.setNome("Maria Eduarda");
		u.setSenha("duda123");
		u.setPontos(9);

		new UsuarioDAO().inserirUsuario(u);

		IDataSet currentDataSet = this.jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load(CAMINHO_VERIFICA);
		ITable expectedTable = expectedDataSet.getTable("USUARIO");
		Assertion.assertEquals(expectedTable, currentTable);
	}

	@Test
	public void testeAdicionarPontos() throws SQLException, Exception {
		new UsuarioDAO().adicionarPontos("joao", 5);
		Usuario u = new UsuarioDAO().recuperarUsuarioPeloLogin("joao");
		assertEquals(15, (int) u.getPontos());
	}

	@Test
	public void testeRecuperarTopicos() {
		List<Topico> topicos = new TopicoDAO().recuperaTodosTopicos();
		assertEquals(3, topicos.size());
		assertEquals("Titulo de Teste 1", topicos.get(0).getTitulo());
	}

	@Test
	public void testeInserirTopico() throws SQLException, Exception {
		Topico t = new Topico();
		t.setIdTopico(4);
		t.setTitulo("Titulo de Teste 4");
		t.setConteudo("Conteudo do titulo de Teste 4");
		t.setUsuario(new UsuarioDAO().recuperarUsuarioPeloLogin("paulo"));

		new TopicoDAO().inserirTopico(t);

		IDataSet currentDataSet = this.jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("TOPICO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load(CAMINHO_VERIFICA);
		ITable expectedTable = expectedDataSet.getTable("TOPICO");
		Assertion.assertEquals(expectedTable, currentTable);
	}

	@Test
	public void testeRecuperarTopicoPeloId() {
		Topico t = new TopicoDAO().recuperarTopicoPorId(3);
		assertEquals("Titulo de Teste 3", t.getTitulo());
	}
}

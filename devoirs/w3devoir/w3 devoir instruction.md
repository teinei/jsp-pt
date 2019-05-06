# w3 devoir instruction

O objetivo dessa aula é exercitar a criação de classes que utilizam JDBC para acessar o banco de dados.

Primeiramente deve ser criado o banco de dados chamado "coursera" e criada a tabela usuario com o script abaixo:

<hr>

The purpose of this lesson is to exercise the creation of classes that use JDBC to access the database.

First create the database called "coursera" and create the user table with the script below:


```
CREATE TABLE usuario
(
  login text NOT NULL,
  email text,
  nome text,
  senha text,
  pontos integer,
  CONSTRAINT usuario_pkey PRIMARY KEY (login)
)
```

Deve ser criada uma classe Usuario com as informações presentes na tabela e uma interface com os segunites métodos:

<hr>

A User class must be created with the information present in the table and an interface with the following methods:

```
public interface UsuarioDAO {
   
   //insere um novo usuário no banco de dados
   public void inserir(Usuario u);
   
   //recupera o usuário pelo seu login
   public Usuario recuperar(String login);
   
   //adiciona os pontos para o usuário no banco
   public void adicionarPontos(String login, int pontos);
   
   //retorna a lista de usuários ordenada por pontos (maior primeiro)
   public List<Usuario> ranking();

}
```

Como o foco do exercício não é a criação de consultas, segue as consultas correspondentes a cada um dos métodos:

<hr>

Since the focus of the exercise is not creating queries, you follow the queries corresponding to each of the methods:

```
INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);
```
```
SELECT * FROM usuario WHERE login = ?;
```
```
UPDATE usuario SET pontos = pontos + ? WHERE login = ?;
```
```
SELECT * FROM usuario ORDER BY pontos DESC;
```

Como exercício, o aluno deverá implementar uma classe que implementa a interface apresentada fazendo acesso ao banco de dados utilizando JDBC. Outros frameworks não devem ser utilizados.

Cada um dos métodos acima deve ser testado utilizando o DBUnit.

Deve ser entregue um projeto (no Eclipse ou Netbeans) com a classe e os testes pedidos em um arquivo do tipo .zip e uma imagem da tela que mostra o resultado da execução dos testes.

<hr>

As an exercise, the student should implement a class that implements the interface presented by accessing the database using JDBC. Other frameworks should not be used.

Each of the above methods must be tested using DBUnit.

A project (in Eclipse or Netbeans) must be delivered with the requested class and tests in a .zip file and an image of the screen that shows the result of running the tests.

<hr>

Review criteria				 <br>
Será considerado na avaliação:

* Se o que foi pedido foi implementado.
* Se os requisitos funcionais foram atendidos
* Se a implementação utilizou as tecnologias solicitadas
* Se os testes foram criados como solicitado

<hr>

Review criteria 				 <br>
Will be considered in the evaluation:

* If what was requested was implemented.
* Whether functional requirements have been met
* If the implementation used the requested technologies
* If the tests were created as requested
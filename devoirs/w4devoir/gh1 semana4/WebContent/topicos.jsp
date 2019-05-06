<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todos os Tópicos</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">

		<h1>Bem vindo: ${usuarioLogado.getNome()}</h1>
		<h3>Tópicos do Fórum</h3>

		<table class="table table-bordered table-hover">
			<tr>
				<th>Titulo</th>
				<th>Nome do Usuário</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="topico" items="${topicos}">
				<tr>
					<td>${topico.getTitulo()}</td>
					<td>${topico.getUsuario().getNome()}</td>
					<td><a href="exibirTopico?id_topico=${topico.getIdTopico()}">exibir</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="alert alert-info">
			<p>Sua pontuação atual é de: ${usuarioLogado.getPontos()} pontos</p>
		</div>
		
		<a href="criarTopico" class="btn btn-primary">Criar Tópico</a>
		<a href="ranking" class="btn btn-primary">Ver Raking</a>

	</div>
</body>
</html>
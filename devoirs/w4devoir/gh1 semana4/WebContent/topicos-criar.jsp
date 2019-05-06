<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Novo Tópico</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">

		<h2>Cadastrar Tópico</h2>
		
		<c:if test="${not empty info}">
			<p class="alert alert-warning">${info}</p>
		</c:if>
	
		<form method="POST" action="criarTopico">
			<div class="form-group">
				<label>Usuário:</label> 
				<input type="text" name="usuario" class="form-control" value="${usuarioLogado.getNome()}" disabled="disabled">
			</div>
			<div class="form-group">
				<label>Título: </label>
				<input type="text" name="titulo" class="form-control">
			</div>
			<div class="form-group">
				<label>Conteúdo: </label>
				<textarea rows="3" cols="20" name="conteudo" class="form-control"></textarea>
			</div>
			<input type="submit" value="Cadastrar Tópico" class="btn btn-primary">
			<a href="topicos" class="btn btn-default">Voltar</a>
		</form>
	
		<c:if test="${not empty info}">
			<p>${info}</p>
		</c:if>
	
	</div>

</body>
</html>
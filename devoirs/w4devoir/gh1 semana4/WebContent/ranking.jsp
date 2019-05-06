<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ranking</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">

		<h2>Ranking de pontução dos usuários</h2>

		<table class="table table-bordered table-hover">
			<tr>
				<th>Nome</th>
				<th>Login</th>
				<th>QTD Pontos</th>
			</tr>
			<c:forEach var="rakingUsuarios" items="${rankingUsuarios}">
				<tr>
					<td>${rakingUsuarios.getNome()}</td>
					<td>${rakingUsuarios.getLogin()}</td>
					<td>${rakingUsuarios.getPontos()}</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="topicos" class="btn btn-default">Voltar</a>
	</div>
</body>
</html>
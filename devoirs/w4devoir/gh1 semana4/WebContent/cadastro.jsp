<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faça seu Cadastro</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="container">

	<h2>Tela de Cadastro</h2>
	
		<c:if test="${not empty info}">
			<p class="alert alert-warning">${info}</p>
		</c:if>

		<form method="POST" action="cadastro">
			<div class="form-group">
				<label>Nome: </label>
				<input type="text" name="nome" class="form-control">
			</div>
			<div class="form-group">
				<label>Login: </label>
				<input type="text" name="login" class="form-control">
			</div>
			<div class="form-group">
				<label>Email: </label>
				<input type="text" name="email" class="form-control">
			</div>
			<div class="form-group">
				<label>Senha: </label>
				<input type="password" name="senha" class="form-control">
			</div>
			
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</form>		
	
	</div>

</body>
</html>
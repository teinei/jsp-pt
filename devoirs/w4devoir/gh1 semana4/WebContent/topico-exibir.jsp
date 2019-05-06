<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhe do Tópico</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="jumbotron">
				<h2>Titulo: ${topico.getTitulo()}</h2>
				<h6>Autor: ${topico.getUsuario().getNome()}</h6>
				<p>${topico.getConteudo()}</p>

				<a href="topicos" class="btn btn-default">Voltar</a>
			</div>

			<c:choose>
				<c:when test="${not empty comentariosDoTopico}">
					<div class="page-header">
						<h2>
							<small class="pull-right">${qtdComentarios} Comentário(s)</small> Comentários
						</h2>
					</div>
					<c:forEach var="comentario" items="${comentariosDoTopico}">
						<div class="comments-list">
							<div class="media">
								<div class="media-body">
									<h4 class="media-heading user_name">${comentario.getUsuario().getNome()}</h4>
									<p>${comentario.getComentario()}</p>
								</div>
							</div>
						</div>
						<hr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p class="alert alert-info">Ainda não exitem comentários para esse tópico!</p>
				</c:otherwise>
			</c:choose>
			<br>

			<form method="POST" action="exibirTopico">
				<div class="form-group">
					<label>Escreva um novo comentário:</label> 
					<input type="hidden" value="${topico.getIdTopico()}" name="idTopico">
					<textarea rows="6" name="comentario" class="form-control"></textarea>
				</div>
				<input type="submit" value="Adicionar Comentário" class="btn btn-primary">
			</form>
			<br>

		</div>
	</div>
</body>
</html>
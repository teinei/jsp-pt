<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum Gamification</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body style="padding-top: 20px;">

	<div class="container">
		<div class="row">
		
			<div class="col-md-4 col-md-offset-4">
	    		<div class="panel panel-default">
				  	<div class="panel-heading">
				    	<h3 class="panel-title">Entre com as informações</h3>
				 	</div>
				  	<div class="panel-body">
				    	<form action="login" method="POST">
	                    <fieldset>
				    	  	<div class="form-group">
				    	  		<input type="text" name="login" placeholder="Login" class="form-control">
				    		</div>
				    		<div class="form-group">
				    			<input type="password" name="senha" class="form-control" placeholder="Senha">
				    		</div>
				    		
				    		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
				    		<a class="btn btn-lg btn-default btn-block" href="cadastro">Cadastre-se</a>
				    		
				    	    <c:if test="${not empty info}">
				    	    	<br>
								<div class="alert alert-warning text-center">${info}</div>
							</c:if>
				    	</fieldset>
				      	</form>
				    </div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
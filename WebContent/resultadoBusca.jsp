<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado</title>
</head>
<body>
	<h3> ${ action } </h3><hr>
	${ resultado }
	<br>
	<form action="CadastroServlet" method="get">
		<input type="submit" name="submit" value="Remover"></input>
		<input type="submit" name="submit" value="Editar"></input>
	</form>
	<a href="index.html">Voltar</a>	
</body>
</html>
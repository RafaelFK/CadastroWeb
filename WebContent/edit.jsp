<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edite o Cadastro</title>
</head>
<body>
	<h3>Edite a disciplina</h3><hr>
	
	<form action="CadastroServlet" method="get">
		Nome:<br> <input type="text" name="nome" value=<%=(String) request.getAttribute("nomeAtual")%>><br>
		Ementa:<br> <input type="text" name="ementa" value=<%=(String) request.getAttribute("ementaAtual")%>><br>
		Código:<br> <input type="text" name="codigo" value=<%=(String) request.getAttribute("codigoAtual")%>><br><br>
		<input type="submit" name="submit" value="Salvar"></input>
	</form>
	
</body>
</html>
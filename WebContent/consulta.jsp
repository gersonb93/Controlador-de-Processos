<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Consulta aos Processos.</h3>
	
	
	<hr /><p />
    <a href="index.jsp">Cadastrar Processo</a>
	<p />
	<table border="1" width="70%" bgcolor="silver">
		<tr>
			<th>ID</th>
			<th>Numero pub</th>
			<th>Numero ped</th>
			<th>Data Pedido</th>
			<th>Requerentes</th>
			<th>Título</th>
			
		</tr>
	
		<!-- JSTL(Java Standard Taglib) e EL(Expression Language). -->
		
		<c:forEach items="${listaProc}" var="f"> 	
	
			<tr>
				<td>${f.idprocesso}</td>
				<td>${f.numero_pub}</td>	
				<td>${f.numero_ped}</td>
				<td>${f.datapubli}</td>
				<td>${f.requerentes}</td>
				<td>${f.titulo}</td>
			</tr>	
		
		</c:forEach>
	</table>

</body>
</html>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Inicial</title>




</head>
<body>
	
	<h3>Aplicação em JSP e Servlet com JDBC Modelo MVC.</h3>
	<hr /><p />
	
	<!-- Scriptlets -->
	<%
		String mensagem = (String) request.getAttribute("msg");
		if (mensagem != null) {
	%>
		
	<b><%=mensagem %></b>	
	
	<%
		}
	%>
	<p />		
	<!-- Link sempre utiliza GET. -->
	<form method="post" action="controle?acao=buscarProc">
	Digite N° Processo:<br />
	<input type="text" name="numero_pub_pesquisa" size="30" /> 
	<input type="submit" value="Buscar" />
	<p />
	</form>
	
	
	<h3>Cadastro de Processos.</h3>
	<a href="controle?acao=consultaProc">Consultar Processos</a>
	<hr /><p />
	
	<!-- Formas de transporte de dados - GET e POST
	GET - Transporte de dados pela URL. Mais rápido, pouco seguro e com limite de tamanho.
	GET - Transporte de dados de forma oculta. Seguro e som limite de tamanho. -->
	
	<form method="post" action="controle?acao=cadastroProc">
		<fieldset style="width: 50%">
			<legend>dados do Processo</legend>
			
			N° de Pub:<br />
			<input type="text" name="numero_pub_result" size="30" />
			<p />
			
			N° do Pedido:<br />
			<input type="text" name="numero_ped" size="30" />
			<p />
			
			Data de Publicação:<br />
			<input type="date" name="dataPubli" size="30" />
			<p />
			
			
			Requerentes:<br />
			<input type="text" name="requerentes" size="30" />
			<p />
			
			Título:<br />
			<input type="text" name="titulo" size="30" />
			<p />
						

			<input type="submit" value="Cadastrar" />
			<input type="reset" value="Limpar os campos" />			
		
		</fieldset>
	</form>
	

</body>
</html>





















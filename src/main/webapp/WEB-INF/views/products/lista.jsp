<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${sucesso}
<table>
<tr>
	<td>TÍTULO </td>
	<td>DESCRIÇÃO </td>
	<td>PREÇO </td>
</tr>

<c:forEach items="${produtos}" var="produto">
<tr> 
	<td>${produto.titulo} </td>
	<td>${produto.descricao} </td>
	<td>
	<c:forEach items="${produto.precos}" var="preco">
	[${preco.tipo} - ${preco.valor}]
	</c:forEach>
	</td>

</tr>

</c:forEach>

</table>

</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${sucess}
${products}
<table>
<tr>
	<td>TÍTULO </td>
	<td>DESCRIÇÃO </td>
	<td>PREÇO </td>
	<td>LANÇAMENTO </td>
</tr>

<c:forEach items="${products}" var="product">
<tr> 
	<td>
	
	${product.title} 
	
	
	</td>
	
	
	
	<td>${product.description} </td>
	<td>${product.releaseDate} </td>
	<td>
	<c:forEach items="${product.prices}" var="price">
	[${price.bookType} - ${price.value}]
	</c:forEach>
	</td>

</tr>

</c:forEach>

</table>

</body>
</html>
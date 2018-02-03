<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc" %>



<cdc:page title="Listagem de Produtos">

	<sec:authorize access="isAuthenticated()"> 
		<sec:authentication property="principal" var="user"/>
		<spring:message code="users.welcome" arguments="${user.name}"></spring:message>
		
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:url value="/products/form" var="formLink"></c:url>
			<a href="${formLink}">Cadastrar novo produto</a>
	</sec:authorize>
	
<br />

${sucess}

<br />

<table>
<tr>
	<td>TÍTULO </td>
	<td>DESCRIÇÃO </td>
	<td>PREÇO </td>
</tr>

<c:forEach items="${products}" var="product">
<tr> 
	<td>
	<a href="/casadocodigo/products/${product.id}">
	${product.title} 
	</a>
	
	</td>
	
	<td>${product.description} </td>
	
	<td>
	<c:forEach items="${product.prices}" var="price">
	[${price.bookType} - ${price.value}]
	</c:forEach>
	</td>

</tr>

</c:forEach>

</table>

</cdc:page>	

</html>
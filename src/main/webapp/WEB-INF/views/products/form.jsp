<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>

<form:form method="post" action="/casadocodigo/products" commandName="product">

	<div>
		<label for="titulo">Título</label>
		<form:input name="titulo" path="titulo"/>
		<form:errors path="titulo"/>
	</div>
	
	<div>
		<label for="description">Descrição</label>
		<form:textarea path="descricao" rows="10" cols="20" id="descricao"/>
		<form:errors path="descricao"/>
		</textarea>
	</div>
	
	<div>
		<label for="numberOfPages">Número de páginas</label>
		<form:input name="paginas" path="paginas"/>
		<form:errors path="paginas"/>
	</div>
	

	<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
	
	<div>
	
		<label for="preco_${tipoPreco}">${tipoPreco}</label>
		<input type="text" name="precos[${status.index}].valor" id="preco_${tipoPreco}" />	
		<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />	
	</div>
	
	</c:forEach>

	
	<div>
		<input type="submit" value="Enviar"/>
	</div>

</form:form>

</body>
</html>
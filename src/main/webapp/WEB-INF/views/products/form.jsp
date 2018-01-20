<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>

<form:form method="post" action="/casadocodigo/products" commandName="product" enctype="multipart/form-data">

	<div>
		<label for="title">Título</label>
		<form:input name="title" path="title"/>
		<form:errors path="title"/>
	</div>
	
	<div>
		<label for="description">Descrição</label>
		<form:textarea path="description" rows="10" cols="20" id="description"/>
		<form:errors path="description"/>
		</textarea>
	</div>
	
	<div>
		<label for="numberOfPages">Número de páginas</label>
		<form:input name="numberOfPages" path="numberOfPages"/>
		<form:errors path="numberOfPages"/>
	</div>
	
	<div>
		<label for="releaseDate">Data de lançamento</label>
		<form:input type="date" name="releaseDate" path="releaseDate"/>
		<form:errors path="releaseDate"/>
	</div>
	
	<div>
		<label for="summary">Sumario do livro</label>
		<input type="file" name="summary" />
		
	</div>

	<c:forEach items="${prices}" var="price" varStatus="status">
	
	<div>
	
		<label for="preco_${price}">${price}</label>
		<input type="text" name="prices[${status.index}].value" id="preco_${price}" />	
		<input type="hidden" name="prices[${status.index}].bookType" value="${price}" />	
	</div>
	
	</c:forEach>

	
	<div>
		<input type="submit" value="Enviar"/>
	</div>

</form:form>

</body>
</html>
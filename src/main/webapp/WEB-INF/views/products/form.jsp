<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>

<form method="post" action="/casadocodigo/products">
	<div>
		<label for="title">Título</label>
		<input type="text" name="titulo" id="title"/>
	</div>
	
	<div>
		<label for="description">Descrição</label>
		<textarea rows="10" cols="20" name="descricao" id="description">
		</textarea>
	</div>
	
		<div>
		<label for="numberOfPages">Número de páginas</label>
		<input type="text" name="paginas" id="numberOfPages"/>
	</div>
	
	<div>
		<input type="submit" value="Enviar"/>
	</div>

</form>

</body>
</html>
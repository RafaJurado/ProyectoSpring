<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<title>Servicios</title>
</head>
<body>
	<h1>Servicios</h1>
	<table>
		<tr>
			<th>idServicio</th>
			<th>descripcion</th>
						
		</tr>
		<!-- Per a iterar sobre tots els nadadors usem la etiqueta c:forEach ,
		 i per a cada nadador mostrem els atributs numFederat, nom, edat i sexe. 
		 A més, definim en cada fila enllaços que ens permetran modificar o 
	     esborrar el nadador. Una vegada acabada la taula, creem també 
	     un enllaç que ens permetrà afegir nous nadadors. -->
		<c:forEach items="${servicios}" var="s">
			<tr>
				<td>${s.idServicio}</td>
				<td>${s.descripcion}</td>				
				
				<td class="link"><a href="update/${s.idServicio}.html"> Editar</a>
				<td class="link"><a href="delete/${s.idServicio}.html"> Borrar</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
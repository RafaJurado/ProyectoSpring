<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<title>Propiedades - Personas</title>
</head>
<body>
	<h1>Propiedades - Personas</h1>
	<table>
		<tr>
			<th>idPersona</th>
			<th>idPropiedad</th>
			<th>Valoracion</th>
			<th>Fecha de valoracion</th>
						
		</tr>
		<!-- Per a iterar sobre tots els nadadors usem la etiqueta c:forEach ,
		 i per a cada nadador mostrem els atributs numFederat, nom, edat i sexe. 
		 A més, definim en cada fila enllaços que ens permetran modificar o 
	     esborrar el nadador. Una vegada acabada la taula, creem també 
	     un enllaç que ens permetrà afegir nous nadadors. -->
		<c:forEach items="${propiedadPersonas}" var="p">
			<tr>
				<td>${p.idPersona}</td>
				<td>${p.idPropiedad}</td>		
				<td>${p.valoracion}</td>
				<td>${p.fechaValoracion}</td>		
				
				<td class="link"><a href="update/${p.idPersona}/${p.idPropiedad}.html"> Editar</a>
				<td class="link"><a href="delete/${p.idPersona}/${p.idPropiedad}.html"> Borrar</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
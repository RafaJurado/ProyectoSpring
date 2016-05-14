<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<title>Reservas</title>
</head>
<body>
	<h1>Reservas</h1>
	<table>
		<tr>
			<th>idReserva</th>
			<th>fechaSolicitud</th>
			<th>fechaInicio</th>
			<th>fechaFin</th>
			<th>numeroPersonas</th>
			<th>precioTotal</th>
			<th>estado</th>
			<th>idPersona</th>
			<th>idPropiedad</th>
						
		</tr>
		<!-- Per a iterar sobre tots els nadadors usem la etiqueta c:forEach ,
		 i per a cada nadador mostrem els atributs numFederat, nom, edat i sexe. 
		 A més, definim en cada fila enllaços que ens permetran modificar o 
	     esborrar el nadador. Una vegada acabada la taula, creem també 
	     un enllaç que ens permetrà afegir nous nadadors. -->
		<c:forEach items="${reservas}" var="r">
			<tr>
				<td>${r.idReserva}</td>
				<td>${r.fechaSolicitud}</td>
				<td>${r.fechaInicio}</td>
				<td>${r.fechaFin}</td>
				<td>${r.numeroPersonas}</td>
				<td>${r.precioTotal}</td>
				<td>${r.estado}</td>
				<td>${r.idPersona}</td>
				<td>${r.idPropiedad}</td>
				
				
				<td class="link"><a href="update/${r.idReserva}.html"> Editar</a>
				<td class="link"><a href="delete/${r.idReserva}.html"> Borrar</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
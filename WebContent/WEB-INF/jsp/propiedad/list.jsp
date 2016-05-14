<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<title>Propiedades</title>
</head>
<body>
	<h1>Propiedades</h1>
	<table>
		<tr>
			<th>idPropiedad</th>
			<th>T&iacute;tulo</th>
			<th>Descripci&oacute;n</th>
			<th>Capacidad</th>
			<th>Habitaciones</th>
			<th>Baños</th>
			<th>Camas</th>
			<th>Tamaño</th>
			<th>Precio</th>
			<th>Activo</th>
			<th>Tipo</th>
			<th>Poblaci&oacute;n</th>
			<th>Provincia</th>
			<th>Tipo de V&iacute;a</th>
			<th>Nombre de V&iacute;a</th>
			<th>N&uacute;m.</th>
			<th>Esc.</th>
			<th>Puerta</th>
			<th>C.P.</th>
			<th>idPersona</th>
			<th>Valoraci&oacute;n</th>
			
		</tr>
		<!-- Per a iterar sobre tots els nadadors usem la etiqueta c:forEach ,
		 i per a cada nadador mostrem els atributs numFederat, nom, edat i sexe. 
		 A més, definim en cada fila enllaços que ens permetran modificar o 
	     esborrar el nadador. Una vegada acabada la taula, creem també 
	     un enllaç que ens permetrà afegir nous nadadors. -->
		<c:forEach items="${propiedades}" var="p">
			<tr>
				<td>${p.idPropiedad}</td>
				<td>${p.titulo}</td>
				<td>${p.descripcion}</td>
				<td>${p.capacidad}</td>
				<td>${p.numeroHabitaciones}</td>
				<td>${p.numeroBanyos}</td>
				<td>${p.numeroCamas}</td>
				<td>${p.tamanyo}</td>
				<td>${p.precio}</td>
				<td>${p.activo}</td>
				<td>${p.tipoPropiedad}</td>
				<td>${p.poblacion}</td>
				<td>${p.provincia}</td>
				<td>${p.tipoVia}</td>
				<td>${p.nombreVia}</td>
				<td>${p.numero}</td>
				<td>${p.escalera}</td>
				<td>${p.puerta}</td>
				<td>${p.codigoPostal}</td>
				<td>${p.idPersona}</td>
				<td>${p.valoracionMedia}</td>
				
				<td class="link"><a href="update/${p.idPropiedad}.html"> Editar</a>
				<td class="link"><a href="delete/${p.idPropiedad}.html"> Borrar</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
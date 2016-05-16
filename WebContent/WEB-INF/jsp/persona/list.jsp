<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<title>Personas</title>
</head>
<body>
	<h1>Personas</h1>
	<table>
		<tr>
			<th>Dni</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>E-Mail</th>
			<th>Fecha de Registro</th>
			<th>Telefono</th>
			<th>Activo</th>
			<th>Nombre de Usuario</th>
			<th>Contraseña</th>
			<th>Tipo</th>
			<th>Poblaci&oacute;n</th>
			<th>Provincia</th>
			<th>Tipo de V&iacute;a</th>
			<th>Nombre de V&iacute;a</th>
			<th>N&uacute;m.</th>
			<th>Esc.</th>
			<th>Puerta</th>
			<th>C.P.</th>			
		</tr>
		<!-- Per a iterar sobre tots els nadadors usem la etiqueta c:forEach ,
		 i per a cada nadador mostrem els atributs numFederat, nom, edat i sexe. 
		 A més, definim en cada fila enllaços que ens permetran modificar o 
	     esborrar el nadador. Una vegada acabada la taula, creem també 
	     un enllaç que ens permetrà afegir nous nadadors. -->
		<c:forEach items="${personas}" var="p">
			<tr>
				<td>${p.dni}</td>
				<td>${p.nombre}</td>
				<td>${p.apellidos}</td>
				<td>${p.email}</td>
				<td>${p.fechaRegistro}</td>
				<td>${p.telefono}</td>
				<td>${p.activo}</td>
				<td>${p.nombreUsuario}</td>
				<td>${p.contrasenya}</td>
				<td>${p.tipoPersona}</td>
				<td>${p.poblacion}</td>
				<td>${p.provincia}</td>
				<td>${p.tipoVia}</td>
				<td>${p.nombreVia}</td>
				<td>${p.numero}</td>
				<td>${p.escalera}</td>
				<td>${p.puerta}</td>
				<td>${p.codigoPostal}</td>
				
				<td class="link"><a href="update/${p.dni}.html"> Editar</a>
				<td class="link"><a href="delete/${p.dni}.html"> Borrar</a>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="add.html">Añadir persona</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:nav title="Listado de Usuarios">
<jsp:body>

	<h1>Personas</h1>
	<div class="container">
    	<div class="table-responsive">
    		<c:forEach items="${personas}" var="p">
    			<table class="table">				
				<tr>
					<td id="title">Dni</td><td>${p.dni}</td>
 					<%--<td id="title">Tipo</td> <td>${p.tipoPersona}</td>--%>
 					<%--<td id="title">Contraseña</td><td>${p.contrasenya}</td>Esto habra que retirarlo --%>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td id="title">Nombre</td><td>${p.nombre} ${p.apellidos}</td>
					<td id="title">Nombre de Usuario</td><td>${p.nombreUsuario}</td>
<%-- 					<td id="title">Apellidos</td><td>${p.apellidos}</td> --%>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td id="title">Telefono</td><td>${p.telefono}</td>
					<td id="title">E-Mail</td><td>${p.email}</td>
				</tr>	
				<tr><td></td></tr>
				<tr>
					<td id="title">Fecha de Registro</td><td>${p.fechaRegistro}</td>
					<td id="title">Activo</td>
					<td>
						<c:choose>
						    <c:when test="${p.activo=='true'}">
						        <input type="checkbox" path="" value="Activo" checked/> 
						    </c:when>    
						    <c:otherwise>
						        <input type="checkbox" path="" value="Activo"/>
						    </c:otherwise>
						</c:choose>
					</td>					
				</tr>
				<tr><td></td></tr>
				<tr>
					
					<td id="title">Direcci�n: </td><td>${p.tipoVia} ${p.nombreVia}, ${p.numero} - ${p.escalera} - ${p.puerta}</td>
<%-- 					<td id="title">Nombre de V&iacute;a</td><td>${p.nombreVia}</td> --%>
<%-- 					<td id="title">N&uacute;m.</td><td>${p.numero}</td> --%>
<%-- 					<td id="title">Esc.</td><td>${p.escalera}</td> --%>
<%-- 					<td id="title">Puerta</td><td>${p.puerta}</td> --%>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td id="title">C.P.</td><td>${p.codigoPostal}</td>
					<td id="title">Poblaci&oacute;n</td><td>${p.poblacion}</td>
					<td id="title">Provincia</td><td>${p.provincia}</td>	
				</tr>
				<!-- Per a iterar sobre tots els nadadors usem la etiqueta c:forEach ,
				 i per a cada nadador mostrem els atributs numFederat, nom, edat i sexe. 
				 A més, definim en cada fila enllaços que ens permetran modificar o 
			     esborrar el nadador. Una vegada acabada la taula, creem també 
			     un enllaç que ens permetrà afegir nous nadadors. -->
				
					<tr>
						<td class="link"><a href="update/${p.dni}.html" class="btn btn-default btn-sm" role="button"> Editar</a>
						<td class="link"><a href="delete/${p.dni}.html" class="btn btn-default btn-sm" role="button"> Borrar</a>
					</tr>			
			</table>
			<br>
			<hr>
		</c:forEach>
		</div>
	</div>
	<br>
	<a href="add.html" class="btn btn-primary" role="button">A�adir persona</a>
	<hr>
	<br>
</jsp:body>
</t:nav>
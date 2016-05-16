<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<title>Actualizar Persona</title>
</head>
<body>
	<h2>Actualizar Persona</h2>
	<form:form method="post" modelAttribute="persona"> 
		<table>
			<tr>
				<td><form:label path="dni">DNI</form:label></td> 
				<td><form:input path="dni" /></td>
				<td><form:errors path="dni" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre</form:label></td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="apellidos">Apellidos</form:label></td>
				<td><form:input path="apellidos" /></td>
				<td><form:errors path="apellidos" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Correo electrónico</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
<%-- 			<tr>
				<td><form:label path="fechaRegistro">Fecha de registro</form:label></td>
				<td><form:input path="fechaRegistro" /></td>
				<td><form:errors path="fechaRegistro" cssClass="error"/></td>
			</tr> --%>
			<tr>
				<td><form:label path="telefono">Teléfono</form:label></td> 
				<td><form:input path="telefono" /></td>
				<td><form:errors path="telefono" cssClass="error"/></td>
			</tr>
<%-- 			<tr>
				<td><form:label path="activo">Activo</form:label></td> 
				<td><form:input path="activo" /></td>
				<td><form:errors path="activo" cssClass="error"/></td>
			</tr> --%>
			<tr>
				<td><form:label path="nombreUsuario">Nombre de Usuario</form:label></td> 
				<td><form:input path="nombreUsuario" /></td>
				<td><form:errors path="nombreUsuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="contrasenya">Contraseña</form:label></td> 
				<td><form:input path="contrasenya" /></td>
				<td><form:errors path="contrasenya" cssClass="error"/></td>
			</tr>
<%-- 			<tr>
				<td><form:label path="tipoPersona">Tipo de persona</form:label></td> 
				<td><form:input path="tipoPersona" /></td>
				<td><form:errors path="tipoPersona" cssClass="error"/></td>
			</tr> --%>
			<tr>
				<td><form:label path="poblacion">Población</form:label></td> 
				<td><form:input path="poblacion" /></td>
				<td><form:errors path="poblacion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="provincia">Provincia</form:label></td> 
				<td><form:input path="provincia" /></td>
				<td><form:errors path="provincia" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="tipoVia">Tipo de Vía</form:label></td> 
				<td><form:input path="tipoVia" /></td>
				<td><form:errors path="tipoVia" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="nombreVia">Nombre de la vía</form:label></td> 
				<td><form:input path="nombreVia" /></td>
				<td><form:errors path="nombreVia" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="numero">Número</form:label></td> 
				<td><form:input path="numero" /></td>
				<td><form:errors path="numero" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="escalera">Escalera</form:label></td> 
				<td><form:input path="escalera" /></td>
				<td><form:errors path="escalera" cssClass="error"/></td> 
			</tr>
			<tr>
				<td><form:label path="puerta">Puerta</form:label></td> 
				<td><form:input path="puerta" /></td>
				<td><form:errors path="puerta" cssClass="error"/></td>  
			</tr>
			<tr>
				<td><form:label path="codigoPostal">Código postal</form:label></td> 
				<td><form:input path="codigoPostal" /></td>
				<td><form:errors path="codigoPostal" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Actualizar persona" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>

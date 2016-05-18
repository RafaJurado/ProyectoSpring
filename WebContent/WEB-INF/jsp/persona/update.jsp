<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page session="true" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:nav title="Actualizar perfil de usuario">
<jsp:body>
<title>Actualizar perfil de usuario</title>
</head>
<body>
	<h2>Actualizar perfil de usuario</h2>
	<hr>
	<form:form method="post" modelAttribute="persona" class="form-horizontal" role="form">
		
		<span class="help-block">Fecha de Registro: <c:out value="${persona.fechaRegistro}"/></span>
		<br>
<!-- 		Activacion y desactivacion de usuarios -->
 
		
		<form:hidden path="activo"  />
		<c:choose>
		    <c:when test='${persona.activo == "true"}'>
		       <input onclick='<c:set var="valor" property="${persona.activo}" scope="session" value="false"/>' value="Usuario Activo" class="btn btn-success" role="button"/>
		    	<c:out value="${persona.activo}"/>	
		    </c:when>
		    <c:otherwise>
		       <input onclick='<c:set var="valor" property="${persona.activo}" scope="session" value="true"/>' value="Usuario Deshabilitado" class="btn btn-danger" role="button"/>
		    	<c:out value="${persona.activo}"/>
		    </c:otherwise>
		</c:choose>

		<form:hidden path="tipoPersona"/>
		<form:hidden path="fechaRegistro"/>
		<form:hidden path="contrasenya"/>
		<br>
		<hr>
		<div class="form-group"> 
			<form:label path="activo" class="col-lg-2 control-label">Activo</form:label>
		    <div class="col-lg-10">
		      <form:input path="activo"  class="form-control" cssClass="error" placeholder="activo" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="dni" class="col-lg-2 control-label">DNI</form:label>
		    <div class="col-lg-10">
		      <form:input path="dni"  class="form-control" cssClass="error" placeholder="D.N.I." readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="nombre" class="col-lg-2 control-label">Nombre</form:label>
		    <div class="col-lg-10">
		      <form:input path="nombre"  class="form-control" cssClass="error" placeholder="nombre" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="apellidos" class="col-lg-2 control-label">Apellidos</form:label>
		    <div class="col-lg-10">
		      <form:input path="apellidos"  class="form-control" cssClass="error" placeholder="apellidos" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="nombreUsuario" class="col-lg-2 control-label">Nombre de usuario</form:label>
		    <div class="col-lg-10">
		      <form:input path="nombreUsuario"  class="form-control" cssClass="error" placeholder="nombreUsuario" readonly="true"/>
		    </div>		
		</div>
		
		<div class="form-group"> 
			<form:label path="email" class="col-lg-2 control-label">E-mail</form:label>
		    <div class="col-lg-10">
		      <form:input path="email"  class="form-control" cssClass="error" placeholder="email" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="telefono" class="col-lg-2 control-label">Teléfono</form:label>
		    <div class="col-lg-10">
		      <form:input path="telefono"  class="form-control" cssClass="error" placeholder="telefono" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="tipoVia" class="col-lg-2 control-label">Tipo de Vía</form:label>
		    <div class="col-lg-10">
		      <form:input path="tipoVia"  class="form-control" cssClass="error" placeholder="tipoVia" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="nombreVia" class="col-lg-2 control-label">Nombre de Vía</form:label>
		    <div class="col-lg-10">
		      <form:input path="nombreVia"  class="form-control" cssClass="error" placeholder="nombreVia" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="numero" class="col-lg-2 control-label">Número</form:label>
		    <div class="col-lg-10">
		      <form:input path="numero"  class="form-control" cssClass="error" placeholder="numero" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="escalera" class="col-lg-2 control-label">Escalera</form:label>
		    <div class="col-lg-10">
		      <form:input path="escalera"  class="form-control" cssClass="error" placeholder="escalera" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="puerta" class="col-lg-2 control-label">Puerta</form:label>
		    <div class="col-lg-10">
		      <form:input path="puerta"  class="form-control" cssClass="error" placeholder="puerta" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="codigoPostal" class="col-lg-2 control-label">C.P.</form:label>
		    <div class="col-lg-10">
		      <form:input path="codigoPostal"  class="form-control" cssClass="error" placeholder="codigoPostal" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="poblacion" class="col-lg-2 control-label">Población</form:label>
		    <div class="col-lg-10">
		      <form:input path="poblacion"  class="form-control" cssClass="error" placeholder="poblacion" readonly="true"/>
		    </div>		
		</div>
		<div class="form-group"> 
			<form:label path="provincia" class="col-lg-2 control-label">Provincia</form:label>
		    <div class="col-lg-10">
		      <form:input path="provincia"  class="form-control" cssClass="error" placeholder="provincia" readonly="true"/>
		    </div>		
		</div>
		
		
<%-- 			<tr>
				<td><form:label path="fechaRegistro">Fecha de registro</form:label></td>
				<td><form:input path="fechaRegistro" /></td>
				<td><form:errors path="fechaRegistro" cssClass="error"/></td>
			</tr> --%>
			
<%-- 			<tr>
				<td><form:label path="activo">Activo</form:label></td> 
				<td><form:input path="activo" /></td>
				<td><form:errors path="activo" cssClass="error"/></td>
			</tr> --%>
			
<%-- 			<tr>
				<td><form:label path="tipoPersona">Tipo de persona</form:label></td> 
				<td><form:input path="tipoPersona" /></td>
				<td><form:errors path="tipoPersona" cssClass="error"/></td>
			</tr> --%>
		<table class="table">
			<tr>	
				<td colspan="2"><input type="submit" value="Actualizar persona" class="btn btn-primary" role="button"/>
				</td>
			</tr>
		</table>
		
	</form:form>
</jsp:body>
</t:nav>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:nav title="Listado de Usuarios">
<jsp:body>
    <h2>Alta de Usuario</h2>
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
<%--             <tr>
                <td><form:label path="fechaRegistro">Fecha de registro</form:label></td>
                <td><form:input path="fechaRegistro" /></td>
                <td><form:errors path="fechaRegistro" cssClass="error"/></td>                   
            </tr> --%>
            <tr>
                <td><form:label path="telefono">Teléfono</form:label></td>
                <td><form:input path="telefono" /></td>
                <td><form:errors path="telefono" cssClass="error"/></td>                   
            </tr>
<%--             <tr>
                <td><form:label path="activo">Activo</form:label></td>
                <td><form:input path="activo" /></td>
                <td><form:errors path="activo" cssClass="error"/></td>                   
            </tr> --%>
            <tr>
                <td><form:label path="nombreUsuario">Nombre de usuario</form:label></td>
                <td><form:input path="nombreUsuario" /></td>
                <td><form:errors path="nombreUsuario" cssClass="error"/></td>                   
            </tr>
            <tr>
                <td><form:label path="contrasenya">Contraseña</form:label></td>
                <td><form:input path="contrasenya" /></td>
                <td><form:errors path="contrasenya" cssClass="error"/></td>                   
            </tr>
<%--             <tr>
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
                <td><form:label path="tipoVia">Tipo de vía</form:label></td>
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
<%--             <tr>
                <td><input type="radio" name="activo" value="true" checked>Si</td>
                <td><input type="radio" name="activo" value="false" checked>No</td>
                <td><form:errors path="dni" cssClass="error"/></td>   
            </tr> 
            <tr>
                <select name="tipoPersona">
					<option>Usuario</option>
					<option>Administrador</option>
				</select>
            </tr>  --%>
            <tr>
                <td colspan="2"><input type="submit" value="Añadir una persona" />
                </td>
            </tr>
        </table>
    </form:form>
</jsp:body>
</t:nav>
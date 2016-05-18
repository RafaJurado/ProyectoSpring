<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:nav title="Inicio">
<jsp:body>
	<!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>A Warm Welcome!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
            <p><a class="btn btn-primary btn-large">Call to action!</a>
            </p>
        </header>

        <hr>
	<ul>
	<li><a href="propiedad/list.html">Gesti&oacute;n de Propiedades</a></li>
	<li><a href="persona/list.html">Gestión de personas</a></li>

	</ul>
</jsp:body>
</t:nav>
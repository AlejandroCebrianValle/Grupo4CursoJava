<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read it 4 me</title>
<link href="webEngine/css/estilo.css" rel="Stylesheet">
<link rel="stylesheet"
 			href="https://necolas.github.io/normalize.css/latest/normalize.css">

<script src="webEngine/Script/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="webEngine/Script/scriptprincipal.js" type="text/javascript"></script>
</head>
<body>
	<header id="divHeader">
		<div id="titulologo">
			<img
			src="webEngine/image/ACV-NHP-OKB4-LogoPrincipal.png"
			style="width: 15%" alt=""> 
			<h1>Buscador de los textos </h1>
			</div>
		<div id="botoncitos">
			
			<a href="CerrarSesion"><input type="button" id="cerrar" value="Cerrar sesión"></a> 
			<!-- Esto sirve para que el botón de Sobre nosotros funcione de manera quelleve al html aboutus.html  -->
			<input type="button" id="sobrenos" value="Sobre nosotros" onclick="openPage('aboutus.html')" />
		</div>
	</header>
	<section>
		<div id="divFormulario">
			<form action="BDActualizar" id="formNuevo">
				<label>Archivo: </label><input name="fichero" size="100" type="file" />
				<p><label>Notas: </label><input type="text" name="notas" maxlength="500">
				<label>Tags</label><input type="text" name="tags" maxlength="50">
				<label>Nombre archivo</label><input type="text" name="nombre" maxlength="20">
				<input type="submit" value="Subir Archivo"  id="botonDown"></p>
			</form>
		</div>
	</section>
	<section id="divBody">
		<article id="izquierdo"> <!-- Seccion de datos y metadatos -->
		</article>
		<article id="derecho">
			 <div id="divSelect">
				<sql:setDataSource var="recursoDatos" driver="com.mysql.jdbc.Driver"
					url="jdbc:mysql://localhost/readit4me" user="root" password="Azf$2069" />
					<sql:query dataSource="${recursoDatos}" var="resultado">
					SELECT * from ARCHIVO, POSEE  WHERE ARCHIVO.codFile = POSEE.codfile and POSEE.codUser = <%= session.getAttribute("codUser") %> </sql:query>
					  <% int contador=0; %>
	
				<c:forEach var="fila" items="${resultado.rows}"><%contador++;%> </c:forEach>
					<select id="desplegable" size="<%=contador%>">
	
						<c:forEach var="fila" items="${resultado.rows}"> 
							<option value="${fila.codFile}"> <c:out value="${fila.nameFile}"/> </option>
						</c:forEach>
		
					</select>
					
			</div><!-- Cierre divselect -->
				<br><br>
				<div id= "boton">
					<input type="button" id="botonTags" value="Consultar">
				</div>
		</article><!-- Cierre derecho -->

	</section><!-- Cierre divbody -->
</body>
</html>
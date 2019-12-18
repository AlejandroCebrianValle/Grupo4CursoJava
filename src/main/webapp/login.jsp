<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- 						Meta: viewport
		Este fragmento de código permite la compatibilidad con dispositivos
		móviles. En content se especifica que el usuario no puede aumentar el
		zoom y que la línea ocupará el ancho de la pantalla.
	-->
	<meta name="viewport" content="width=device-width, user-scalable=no,
			initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<!-- 						Hoja de estilos								-->
	<link rel="stylesheet" href="webEngine/css/loginStyle.css">
	<!-- 						Metainformación 							-->
	<meta name="author" content="Grupo Cuatro Curso Aplicaciones en Java -
								 Cámara de Comercio 2019">
	<meta name="description" content="Trabajo de final de Curso -  Aplicaciones
			en Java (2019) / Página principal - Identificación
			
			Página de identificación del usuario de la plataforma ReadIt4me.
			Permite que el acceso a los documentos sea privado.">
	<meta name="keywords" content="HTML, CSS, JavaScript, JSP, Java, Servlets,
			MVC, Trabajo, Final, Curso, Aplicaciones, Java, App, Web">
	<!-- 			Compatibilidad con todos los navegadores
	
	Estas lineas permiten la compatibilidad con cualquier tipo de navegador al
	importar aquellas funciones que son necesarias para la ejecución de las
	librerías de estilo (css) y JQuery/JavaScript
 	-->
 	<link rel="stylesheet"
 			href="https://necolas.github.io/normalize.css/latest/normalize.css">
 	<!-- Librería de JQuery -->
 	<script
 		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
 		type="text/javascript"></script>
 	<!--  							JavaScript 								-->
	<script type="text/javascript" src="webEngine/js/loginScript.js"></script>
	<title>Read It 4 me - Acceso/Registro</title>
</head>
<body>
	<!-- Sección de la página que se ve siempre -->
	<div class="main">
		<div class="vacio"></div>
		<div class="wrap"> <!-- Etiqueta que centra y da ancho del 90% -->
			<table>
				<thead>
				<tr>
					<td colspan="2">
						<img
							src="webEngine/image/ACV-NHP-OKB4-LogoPrincipal.png"
							alt="Logo de ReadIt4me,ejemplar de Agalychnis
								callidryas">
					</td>
				</tr>
				</thead>
				<tbody>
				<tr class="lineavacia">
		    		<th></th>
		    		<th></th>
		    	</tr>
		    	<tr>
		    		<th class="borde">
			    		<!-- Formulario de Entrada -->
				        <form action="Acceso" method="post">
				        	<p class="titulo">Usuarios<br>registrados</p>
				        	<p>Nombre de usuario<br>
				        		<input type="text" name="userName"/></p>
				        	<p>Contraseña<br>
				        		<input type="password" name="contrasenna"/></p>
				        	<p><input type="submit" value="Entrar" /></p>
				        </form>
			        </th>
			        <th>
			    		<!-- Formulario de Entrada -->
				        <form action="Registro" method="post">
				        	<p class="titulo">Nuevos<br>Usuarios</p>
				        	<p>Nombre de usuario<br>
				        		<input type="text" name="userName" /></p>
				        	<p>Contraseña<br>
				        		<input type="password" name="contrasenna" /></p>
				        	<p><input type="submit" value="Registro" /></p>
				        </form>
			    	</th>
		    	</tr>
		    	<tr class="lineavacia">
		    		<th></th>
		    		<th></th>
		    	</tr>
		    	</tbody>
		   	</table>
		</div>
		<div class="vacio"></div>
	</div>
	<!-- 			Botón que abre la sección de meta información
	
		- id para JavaScript
		- class para estilos/CSS
	-->
	<a href="#" id="BotonOcultar" class="BotonOcultar">Más información</a>
	<!-- Sección de la página que se ve unicamente cuando se le da al botón -->
	<section class="sectionToggle">
		<div class="vacio2"></div>
		<div class="wrap"> <!-- Etiqueta que centra y da ancho del 90% -->
			<h2>¿Qué es Read It 4 me?</h2>
			<p>ReadIt4me es una aplicación web para el análisis y repositorio
			de textos en gran cantidad de formatos. Desarrollada en Java,
			pretende ser un servicio sencillo de usar e interpretar para
			aquellas personas u organizaciones que busquen resumir o
			simplificar textos en sus palabras clave o palabras más repetidas
			con significado (adjetivos, sustantivos, verbos, adverbios),
			pudiendo extraer sus propias conclusiones.</p>
		<div class="vacio2"></div>
			<div class=Boton>
				<a href="aboutus.html" target="_blank"
						class="BotonAboutUs">Sobre Nosotros</a>
			</div>
   		</div>
	</section>
</body>
</html>
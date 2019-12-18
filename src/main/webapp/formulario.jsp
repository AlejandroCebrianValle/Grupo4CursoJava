<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="ISO-8859-1"%>
 <link href="webEngine/css/estilo.css" rel="Stylesheet">
     <script>
     
   function cargarYBorrar(){
    	document.getElementById("formNuevo").submit();-->
    	document.getElementById("capaForm").innerHTML =;-->
    }
    
    action="BDActualizar"
    </script>
    
 <div id="capaForm">
<fieldset><legend>Subir archivo</legend>
<form action="BDActualizar" id="formNuevo">
<label>Archivo: </label><input id="fichero" size="100" type="file" />
<p><label>Notas: </label><input type="text" id="notas" maxlength="500">
<label>Tags</label><input type="text" id="tags" maxlength="50">
<input type="button" value="Proceder"  id="botonDown" onclick="cargarYBorrar();"></p>
</form>
</fieldset>
</div>

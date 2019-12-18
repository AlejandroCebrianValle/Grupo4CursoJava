function openPage(pageURL) {
	window.open(pageURL);
};

$(document).ready(function () {
    $("#botonTags").click(function () {
    	//obtengo la ide  del objeto seleccionado en el desplegable
        var idArchivo = $('select#desplegable option:selected').val();
        //sobrecribo la direccion
       var ruta = "BDConsultaDatosArchivo?id="+idArchivo;
        $.ajax({
        	url: ruta,
        	success: function(respuesta) {
        		//mando la respuesta 
        		$("#izquierdo").html(respuesta);
        	},
        	error: function() {
        		$("#izquierdo").text("Error ajax");
            }
        	
        });
    });
    
   
});


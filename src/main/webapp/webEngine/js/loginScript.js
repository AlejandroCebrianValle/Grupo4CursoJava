$(document).ready(function(){
	var estado = false;
 
	$('#BotonOcultar').on('click',function(){
		$('.sectionToggle').slideToggle();
 
		if (estado == true) {
			$(this).text("Más Información");
			$('.vacio').css({
				"display": "block",
				"overflow": "auto"
			});
			$('.main').css({
				"display": "block",
				"overflow": "auto"
			});
			estado = false;
		} else {
			$(this).text("Cerrar");
			$('.main').css({
				"display": "none",
				"overflow": "hidden"
			});
			$('.vacio').css({
				"display": "none",
				"overflow": "hidden"
			});
			estado = true;
		}
	});
});

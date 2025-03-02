$(document).ready(function() {
    actualizarNombreBienvenida();
});

function actualizarNombreBienvenida(){
    let lblBienvenida = document.getElementById("lblBienvenida")
    document.getElementById('lblBienvenida').outerHTML = 'Hola! ' + localStorage.nombre + ' ' + localStorage.apellidoP;
}
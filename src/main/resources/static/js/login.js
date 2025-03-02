// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSession() {

    let datos= {};

    datos.gmail = document.getElementById('txtgmail').value;
    datos.password = document.getElementById('txtpassword').value;

    const request = await fetch('auth/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(datos)
    });
    const respuesta = await request.json();


    if(respuesta[0] != 'FAIL'){
        localStorage.token = respuesta[0];
        localStorage.gmail = datos.gmail;
        localStorage.nombre = respuesta[1];
        localStorage.apellidoP = respuesta[2];
        window.location.href = 'index.html'
    }else {
        alert("Usuario o contraseña son incorrectas! Vuelve a intentarlo")
    }

}

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
    const respuesta = await request.text();


    if(respuesta != 'FAIL'){
        localStorage.token = respuesta;
        localStorage.gmail = datos.gmail;
        window.location.href = 'index.html'
    }else {
        alert("Usuario o contraseña son incorrectas! Vuelve a intentarlo")
    }

}

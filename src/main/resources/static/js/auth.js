// Call the dataTables jQuery plugin
$(document).ready(function() {
    VerificarSession();
});

async function VerificarSession() {
    const request = await fetch('auth/validator', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        },

    });
    const respuesta = await request.text();

    console.log(respuesta)

    if ( respuesta != 'True'){
        localStorage.clear()
        window.location.href = 'login.html';
    }

}

function cerrarSession(){
    localStorage.clear()
    window.location.href = 'login.html';

}
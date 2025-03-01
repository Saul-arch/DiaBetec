// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registrarUsuario() {

    let datos= {};
    datos.nombre = document.getElementById('txtnombre').value;
    datos.apellidoP = document.getElementById('txtapellidoP').value;
    datos.apellidoM = document.getElementById('txtapellidoM').value;
    datos.gmail = document.getElementById('txtgmail').value;
    datos.password = document.getElementById('txtpassword').value;


    let repetirPassword = document.getElementById('txtrepeatpassword').value;

    if(repetirPassword != datos.password){
        alert("Las contraseñas no coinciden");
        return;
    }

    const request = await fetch('users/adduser', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2IiwiaWF0IjoxNzQwMjUzMTk2LCJzdWIiOiJjYXJsb3NAZ21haWwuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTc0MDg1Nzk5Nn0.NxpHTQSGFpthpKBkMFxsRVB0sAi5Qvh7gDsqrie0tKY'
        },
        body: JSON.stringify(datos)
    });

}

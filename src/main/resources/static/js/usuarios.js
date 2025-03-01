// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios()
  $('#usuarios').DataTable();
  actualizarGmailUsuario();
});

async function cargarUsuarios() {

  const request = await fetch('users/allusers', {
    method: 'GET',
    headers: getHeaders()
  });
  const usuarios = await request.json();

  if (request.status === 500){
    redirigirLogin();
    return;
  }

  let listadoHTML = '';

  for (let usuario of usuarios){
    let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHTML = '<tr>' +
        '<td>' + usuario.nombre + '</td>' +
        '<td>' + usuario.apellidoP + '</td>' +
        '<td>' + usuario.apellidoM + '</td>' +
        '<td>' + usuario.gmail + '</td>' +
        '<td>' +botonEliminar+
        '</td>' +
        '</tr>';

    listadoHTML += usuarioHTML;
  }
  document.querySelector('#usuarios tbody').outerHTML = listadoHTML
}

function redirigirLogin(){
  window.location.href = 'login.html';
}

async function eliminarUsuario(id) {

  if (confirm('Desea eliminar este usuario?')){
    const request = await fetch('users/deleteuser/'+id, {
      method: 'DELETE',
      headers: getHeaders()
    });

    location.reload()
  }
}

function getHeaders(){
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}
function actualizarGmailUsuario(){
  document.getElementById('txt-gmail-usuario').outerHTML = localStorage.gmail;
}

function cerrarSession(){
  localStorage.clear()
  window.location.href = 'login.html';

}

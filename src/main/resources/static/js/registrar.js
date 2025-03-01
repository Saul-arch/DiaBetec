async function enviarEmail(datos) {
    const request = await fetch('sendemail/sendcod', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ destinatario: datos.gmail })
    });
}

function abrirModal() {
    const modal = document.getElementById('verificationModal');
    if (modal) {
        modal.style.display = "block";
    } else {
        console.error("No se encontró el modal");
    }
}

async function registrarUsuario() {
    let datos = {};
    datos.nombre = document.getElementById('txtnombre').value;
    datos.apellidoP = document.getElementById('txtapellidoP').value;
    datos.apellidoM = document.getElementById('txtapellidoM').value;
    datos.gmail = document.getElementById('txtgmail').value;
    datos.password = document.getElementById('txtpassword').value;

    let repetirPassword = document.getElementById('txtrepeatpassword').value;

    if (repetirPassword !== datos.password) {
        alert("Las contraseñas no coinciden");
        return;
    }

    if (datos.gmail === "") {
        alert("El correo no puede estar vacío");
        return;
    }

    await enviarEmail(datos);
    abrirModal();
}

const txtCod = document.getElementById('verificationCode');
const verifyCodeBtn = document.getElementById('verifyCodeBtn');

verifyCodeBtn.onclick = async function () {
    const request = await fetch('sendemail/verifyCod', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            codigoVerificacion: txtCod.value,
            destinatario: document.getElementById('txtgmail').value
        })
    });

    const respuesta = await request.json();

    if (respuesta === true) {
        alert("Código correcto, registrando usuario...");

        await fetch('users/adduser', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                nombre: document.getElementById('txtnombre').value,
                apellidoP: document.getElementById('txtapellidoP').value,
                apellidoM: document.getElementById('txtapellidoM').value,
                gmail: document.getElementById('txtgmail').value,
                password: document.getElementById('txtpassword').value
            })
        });

        alert("Usuario registrado correctamente");
        window.location.href = "login.html"; // Redirigir al login
    } else {
        alert("Código incorrecto");
    }
};

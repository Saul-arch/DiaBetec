document.addEventListener("DOMContentLoaded", function () {

    cargarRegistro()
});

async function cargarRegistro() {

    const contenedor = document.getElementById("contentedLogros");

    const rawResponse = await fetch('/medicine/getAll', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        },
        body: JSON.stringify()
    });
    const contenidoRegistro = await rawResponse.json();

    for (let registro of contenidoRegistro){
        const card = `
          <div class="logro-card">
            <div class="logro-icon">🏆</div>
            <div class="logro-text">
                <div class="logro-title">
                    ${registro.nivel_glucosa}
                </div>
                <div class="logro-status ">
                    ${registro.notas}
                </div>
            </div>
        </div>  
        `;
        contenedor.innerHTML += card;

    }


    console.log(contenidoRegistro);


}

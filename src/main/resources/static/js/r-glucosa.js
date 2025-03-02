async function registrarGlucosa() {
    let txtGlucosa = document.getElementById("txtglucosa");
    let txtNotas = document.getElementById("txtnotes")


    const rawResponse = await fetch('/medicine/addRGlucosa', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        },

        body: JSON.stringify({
            gmail: localStorage.gmail,
            nivelGlucosa: document.getElementById('txtglucosa').value,
            notas: document.getElementById('txtnotes').value,
        })
    });
    const respuesta = await rawResponse.json();

}
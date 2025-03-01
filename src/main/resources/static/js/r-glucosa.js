async function registrarGlucosa() {
    const rawResponse = await fetch('https://httpbin.org/post', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({a: 1, b: 'Textual content'})
    });
    const respuesta = await rawResponse.json();

}
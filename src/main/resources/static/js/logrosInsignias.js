document.addEventListener("DOMContentLoaded", function () {
    const logros = [
        { nombre: "Primer Registro de Glucosa", estado: "desbloqueado" },
        { nombre: "Actividad Física por 7 días consecutivos", estado: "pendiente" },
        { nombre: "Registro diario de medicamentos", estado: "pendiente" },
        { nombre: "Alcanzar 10,000 pasos en un día", estado: "desbloqueado" },
        { nombre: "Comer 5 porciones de frutas al día", estado: "pendiente" },
        { nombre: "Beber 2 litros de agua al día", estado: "desbloqueado" },
        { nombre: "Realizar 30 minutos de actividad diaria", estado: "pendiente" },
        { nombre: "Dormir 8 horas durante una semana", estado: "desbloqueado" },
        { nombre: "Evitar azúcares por 5 días", estado: "pendiente" },
        { nombre: "Tomar 10,000 pasos cada día durante 5 días", estado: "pendiente" },
        { nombre: "Lograr un objetivo de peso saludable", estado: "desbloqueado" },
        { nombre: "Asistir a todas las consultas médicas", estado: "pendiente" },
        { nombre: "Practicar respiración profunda 5 minutos", estado: "desbloqueado" },
        { nombre: "Evitar comidas rápidas por 3 días consecutivos", estado: "pendiente" },
        { nombre: "Registrar todos los alimentos durante una semana", estado: "desbloqueado" },
        { nombre: "Recibir un chequeo de glucosa semanalmente", estado: "pendiente" },
        { nombre: "Realizar 15 minutos de estiramientos cada día", estado: "desbloqueado" },
        { nombre: "Realizar una caminata de 30 minutos por 7 días", estado: "pendiente" },
        { nombre: "Lograr un nivel bajo de estrés durante un mes", estado: "desbloqueado" },
        { nombre: "Mantener un ciclo de sueño regular por 30 días", estado: "pendiente" }
    ];


    const contenedor = document.getElementById("contentedLogros");

    logros.forEach(logro => {
        const card = `
          <div class="logro-card">
            <div class="logro-icon">🏆</div>
            <div class="logro-text">
                <div class="logro-title">
                    ${logro.nombre}
                </div>
                <div class="logro-status ${logro.estado === 'desbloqueado' ? 'logro-desbloqueado' : 'pendiente'}">
                    ${logro.estado === 'desbloqueado' ? '¡Logro desbloqueado!' : 'Logro pendiente'}
                </div>
            </div>
        </div>  
        `;
        contenedor.innerHTML += card;
    });
});

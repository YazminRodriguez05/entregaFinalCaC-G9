function resumen() {

    let nombre = document.getElementById("nombre").value;
    let apellido = document.getElementById("apellido").value;
    let email = document.getElementById("email").value;
    let cantidad = parseInt(document.getElementById("cantidad").value);
    let categoria = parseInt(document.getElementById("categoria").value);
    let total = document.getElementById("total");
    let valortotal = calcular(cantidad, categoria);

    total.textContent = calcular(cantidad, categoria);

    // Mostrar datos
    const datos = document.getElementById("datos");
    datos.classList.add("style_resumen")

    
    datos.textContent = `${nombre} ${apellido} reservó ${cantidad} tickets,
    por un valor de $${valortotal}. 
    Los pasos a seguir seran enviados a ${email}`;
    
}

// Función para calcular el valor total de los tickets comprados
function calcular(cantidad, categoria) {
    let subtotal = cantidad * 200;
    let descuento;
    let valorFinal;

    switch (categoria) {
        case 1:
            descuento = parseInt(subtotal * 80) / 100;
            valorFinal = subtotal - descuento;
            break;

        case 2:
            descuento = parseInt(subtotal * 50) / 100;
            valorFinal = subtotal - descuento;
            break;

        case 3:
            descuento = parseInt(subtotal * 15) / 100;
            valorFinal = subtotal - descuento;
            break;
    }

    return valorFinal;
}

function borrar() {
    let formulario = document.getElementById("formulario");
    formulario.reset();
    datos.classList.remove("style_resumen");
    total.textContent = " ";
    datos.textContent = " ";
}

$(document).ready(function () {
    if (RegExp('multipage', 'gi').test(window.location.search)) {
        const intro = introJs();
        intro.setOptions({
            steps: [
                {
                    title: 'Carrito',
                    intro: 'Ahora vemamos como hacer el pago de tus productos'
                },
                {
                    element: '#tabla',
                    title: 'Productos del Carrito',
                    intro: 'Es aqui donde aparecera la informacion de cada uno de los productos que vayas adquirir, asi como la cantidad y las observaciones del pedido.'
                },
                {
                    element: '#pagar',
                    title: 'Pagar',
                    intro: 'Una vez que hayas llenado la informacion para la compra, asi como haber agregado la direccion previamente oprimiremos el boton de "Realizar pedido" para que tu peticion llegue a nosotros.'
                },
                {
                    element: '#navbarDropdown',
                    title: 'Mis pedidos',
                    intro: 'Por ultimo pero no menos importante, sabemos que a nuestros clientes les interesa ver el estado de sus pedidos desde que es solicitado hasta que llegue a sus manos, ingresa a la pestaña de "Mis pedidos para" esto.',
                    position: 'left'
                },
                {
                    title: 'Fin',
                    intro: 'Esperemos que este recorrido haya sido de ayuda, gracias por tu preferencia, estamos a tu servicio. <br> <b> Recuerda que este recorrido siempre esta disponible en la parte inferior derecha de nuestra pagina inicial</b>'
                }
            ],
            prevLabel: 'Anterior',
            nextLabel: 'Siguiente'
        });
        intro.setOption('doneLabel', 'Volver').start().oncomplete(function () {
            window.location.href = 'Home';
        });
    }
});


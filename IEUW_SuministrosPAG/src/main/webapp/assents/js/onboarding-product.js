$(document).ready(function(){
    if (RegExp('multipage', 'gi').test(window.location.search)) {
            const intro = introJs();
            intro.setOptions({
                prevLabel: 'Anterior',
                nextLabel : 'Siguiente',
        steps:[
            {
                element: '#informacion',
                title: 'Sigamos!',
                intro: 'Aqui podras ver los detalles del producto que te interese , desde el material, imagenes del producto y hasta el peso de la caja.'
            },
            {
                element: '#addProduto',
                intro: 'Antes de esto tenemos que agregar una cantidad para poder añadir al carrito, si no, esto no sera posible.'
            },
            {
                element: '#carrito',
                title: 'Carrito',
                intro: 'Para ver los productos añadidos debemos pulsar al carrito.'
            }
        ]
        });
        intro.setOption('doneLabel', 'Pagina Siguiente').start().oncomplete(function() {
          window.location.href = 'ShoppingCart?&multipage=true';
        });
    }
});
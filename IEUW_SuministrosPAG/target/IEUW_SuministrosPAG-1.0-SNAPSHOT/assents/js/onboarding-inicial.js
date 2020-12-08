    const intro = introJs(); 
       intro.setOptions({
                prevLabel: 'Anterior',
                nextLabel : 'Siguiente',
        steps:[
            {
                title: 'Bienvenido!',
                intro: 'Te damos la bienvenida a nuestra pagina web, si quieres seguir con el tour de la pagina presiona el boton next, en el caso de no ser asi cierra con el boton close'
            },
            {
              element: '#productos',
              title:'Productos m&aacute;s nuevos.',
              intro:'Aqui podras ver los productos agregados mas recientemente en la tienda los cuales estan en stock.',
              position: 'left'
            },
            {   
                element: '#filtros',
                title: 'Filtros.',
                intro: 'Para poder llegar a tu producto deceado mas rapido provehemos filtros los cuales facilitaran las busqueda.',
                position: 'right'
            },
            {
                title: 'Producto.',
                intro: 'Ahora vemos como agregar un producto al carrito. Vamos a la siguiente pagina'
            }
        ]
        });
    intro.setOption('doneLabel', 'Pagina Siguiente').start().oncomplete(function() {
          window.location.href = 'Product?Producto=1&multipage=true';
        });



function buscar_datos(consulta, accion){
    $.ajax({
        url: "BuscarVenta",
        type: 'POST',
        datatype: 'html',
        data: {consulta: consulta,
               acc: accion},
        error: function(result){
            alert(result.status);
        },
        success: function(result){
            $('#tabla').empty();
            $.each(result, function(index, venta) {
                var estado;
                var opcion = "";
                var totalPagar = parseFloat(venta.totalPagar).toFixed(2);;
                if(venta.ventaEstado < 3){
                    if(venta.ventaEstado == 0){
                      opcion = "<a href=\"Estado?estado=1&pedido="+ venta.idventa +"&ref=pedidos\" class=\"btn btn-secondary col-5\">En proceso</a>\n";  
                    }else if(venta.ventaEstado == 1){
                      opcion = "<a href=\"Estado?estado=2&pedido="+ venta.idventa +"&ref=pedidos\" class=\"btn btn-secondary col-5\">Enviado</a>\n";
                    }else if(venta.ventaEstado == 2){
                      opcion ="<a href=\"Estado?estado=3&pedido="+ venta.idventa +"&ref=pedidos\" class=\"btn btn-success col-5\">Entregado</a>\n";
                    }
                }
            var htmlTags = "<tr>\n" +
                            "<th scope=\"row\">" + venta.idventa + "</th>\n" +
                            "<td>" + venta.nombreUsuario + "</td>\n" +
                            "<td>" + venta.ventaFecha + "</td>\n" +
                            "<td>$"+ totalPagar +"</td>\n" +
                            "<td>\n" +
                            opcion +
                            "<a href=\"Pedido?idPedido=<%= venta.getIdventa() %>&ref=pedidos\" class=\"btn btn-link col-2\">Ver</a>\n" +
                            "</td>\n" +
                            "</tr>";

            $('#tabla').append(htmlTags);   
        });
        }
    });
};

$(document).on('keyup', '#caja_busqueda', function(){
   var valor = $(this).val();
   var accion = "SA"
   if(valor!=null){
       buscar_datos(valor, accion);
   }
});




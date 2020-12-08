function buscar_datos(consulta, idUsuario, accion){
    $.ajax({
        url: "BuscarVenta",
        type: 'POST',
        datatype: 'html',
        data: {consulta: consulta,
               id: idUsuario,
               acc: accion},
        error: function(result){
            alert(result.status);
        },
        success: function(result){
            $('#tabla').empty();
            $.each(result, function(index, venta) {
                var estado;
                var cancelar = "";
                var totalPagar = parseFloat(venta.totalPagar).toFixed(2);;
                if(venta.ventaEstado == 0){
                    estado = "<td style=\"color: gray\">Esperando confirmacion</td>\n";
                    cancelar = "<a href=\"Estado?estado=4&pedido=" + venta.idventa + "&ref=mispedidos\" class=\"btn btn-danger\">Cancelar</a>\n";
                }
                else if(venta.ventaEstado == 1){
                    estado = "<td style=\"color: #000000\">En proceso</td>\n";
                    cancelar = "<a href=\"Estado?estado=4&pedido=" + venta.idventa + "&ref=mispedidos\" class=\"btn btn-danger\">Cancelar</a>\n";
                }
                else if(venta.ventaEstado == 2){
                    estado = "<td style=\"color: #007bff\">En camino</td>\n";
                }
                else if(venta.ventaEstado == 3){
                    estado = "<td style=\"color: green\">Entregado</td>\n";
                }
                else if(venta.ventaEstado == 4){
                    estado = "<td style=\"color: red\">Cancelado</td>\n";
                }
            var htmlTags = "<tr>" +
                           "<th scope=\"row\">" + venta.idventa + "</th>\n" +
                           "<td>" + venta.ventaFecha + "</td>\n" +
                           "<td>$"+ totalPagar + "</td>\n" +
                           estado +
                           "<%}%>\n" +
                           "<td>\n" +
                           "<a href=\"Pedido?idPedido=" + venta.idventa + "&ref=mispedidos\" class=\"btn btn-link\">Ver</a>\n" +
                            cancelar +
                           "</td>"+
                           "</tr>";

            $('#tabla').append(htmlTags);   
        });
        }
    });
};

$(document).on('keyup', '#caja_busqueda', function(){
   var valor = $(this).val();
   var idUsuario = $('#idUsuario').val();
   var accion = "SU"
   if(valor!=null){
       buscar_datos(valor, idUsuario, accion);
   }
});


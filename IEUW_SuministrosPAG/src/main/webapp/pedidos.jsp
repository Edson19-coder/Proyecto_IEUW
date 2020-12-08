    <%@page import="java.text.DecimalFormat"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.VentaModel"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.DireccionModel"%>
<% 
    String user = (String) session.getAttribute("name_user_session");
    List<VentaModel> ventas = (List<VentaModel>) request.getAttribute("ventas");
%>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Home"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
<%@include file= "navbar.jsp" %> 
<%}%>
<link rel="stylesheet" href="assents/css/estadisticas.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
        <div class="list-group list-group-flush">
            <a href="Estadisticas" class="list-group-item list-group-item-action">
                <i class='fas fa-chart-bar' style='font-size:18px;color: black'></i>
                Estadisticas
            </a>
            <a href="Configuracion" class="list-group-item list-group-item-action">
                <i class='fas fa-cog' style='font-size:18px;color: black'></i>
                Configuracion
            </a>
            <a href="Pedidos" class="list-group-item list-group-item-action select" style="color: white">
                <i class='fas fa-clipboard-list' style='font-size:18px;color: white'></i>
                Pedidos
            </a>
            <a href="MisPedidos" class="list-group-item list-group-item-action">
                <i class='fas fa-box-open' style='font-size:18px;color: black'></i>
                Mis pedidos
            </a>
        </div>
    </div>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom menu-button">
             <button class='btn btn-primary' id='menu-toggle'>Menu</button>
        </nav>
        
        <div class="col-10">
        <table class="table table-striped table-responsive-sm table-responsive-md table-responsive-m table-responsive-lg">
            <thead>
                <tr>
                    <th scope="col">Orden</th>
                    <th scope="col">Nombre de cliente</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Pago total</th>
                    <th scope="col">Acción</th>
                </tr>
            </thead>
            <tbody>
                <%for(VentaModel venta : ventas){%>
                <tr>
                    <th scope="row"><%= venta.getIdventa() %></th>
                    <td><%= venta.getNombreUsuario() %></td>
                    <td><%= venta.getVentaFecha() %></td>
                    <td>$<%= df.format(venta.getTotalPagar()) %></td>
                    <td>
                        <%if(venta.getVentaEstado() < 3){%>
                            <%if(venta.getVentaEstado() == 0){%>
                        <a href="Estado?estado=1&pedido=<%= venta.getIdventa() %>&ref=pedidos" class="btn btn-secondary col-5">En proceso</a>
                            <%}else if(venta.getVentaEstado() == 1){%>
                        <a href="Estado?estado=2&pedido=<%= venta.getIdventa() %>&ref=pedidos" class="btn btn-secondary col-5">Enviado</a>
                            <%}else if(venta.getVentaEstado() == 2){%>
                        <a href="Estado?estado=3&pedido=<%= venta.getIdventa() %>&ref=pedidos" class="btn btn-success col-5">Entregado</a>
                            <%}%>
                        <a href="Pedido?idPedido=<%= venta.getIdventa() %>&ref=pedidos" class="btn btn-link col-2">Ver</a>
                        <%}%>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
        </div>
    </div>

    <!-- Menu Toggle Script -->
    <script src="assents/js/menu-toggle.js"></script>
</body>

</html>
<%@page import="com.mycompany.ieuw_suministrospag.models.VentaModel"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.DireccionModel"%>
<% 
    String user = (String) session.getAttribute("name_user_session");
    List<VentaModel> ventas = (List<VentaModel>) request.getAttribute("ventas");
%>
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
            <a href="Pedidos" class="list-group-item list-group-item-action">
                <i class='fas fa-clipboard-list' style='font-size:18px;color: black'></i>
                Pedidos
            </a>
            <a href="MisPedidos" class="list-group-item list-group-item-action select">
                <i class='fas fa-box-open' style='font-size:18px;color: black'></i>
                Mis pedidos
            </a>
        </div>
    </div>
    <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <button class="btn btn-primary" id="menu-toggle">Menu</button>
        </nav>
        <div class="col-10">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Orden</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Pago total</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%for(VentaModel venta : ventas){%>
                <tr>
                    <th scope="row"><%= venta.getIdventa() %></th>
                    <td><%= venta.getVentaFecha() %></td>
                    <td>$<%= venta.getTotalPagar() %></td>
                    <td><%= venta.getVentaEstado() %></td>
                    <td>
                        <a href="#" class="btn btn-danger">Cancelar</a>
                        <a href="Pedido?idPedido=<%= venta.getIdventa() %>" class="btn btn-link">Ver</a>
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

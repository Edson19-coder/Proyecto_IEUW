<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mycompany.ieuw_suministrospag.utils.Type"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.VentaModel"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.DireccionModel"%>
<% 
    String user = (String) session.getAttribute("name_user_session");
    Integer idUser = (Integer) session.getAttribute("id_user_session");
    List<VentaModel> ventas = (List<VentaModel>) request.getAttribute("ventas");
    Integer uType = (Integer) session.getAttribute("userType_user_session");
%>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Mis pedidos"/>
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
             <a href="Configuracion" class="list-group-item list-group-item-action">
                <i class='fas fa-cog' style='font-size:18px;color: black'></i>
                Configuracion
            </a>
            <a href="MisPedidos" class="list-group-item list-group-item-action select" style="color: white;">
                <i class='fas fa-box-open' style='font-size:18px;color: white'></i>
                Mis pedidos
            </a>
            <% if(uType == 1){ %>
            <a href="Estadisticas" class="list-group-item list-group-item-action">
                <i class='fas fa-chart-bar' style='font-size:18px;color: black'></i>
                Estadisticas
            </a>
            <a href="Pedidos" class="list-group-item list-group-item-action">
                <i class='fas fa-clipboard-list' style='font-size:18px;color: black'></i>
                Pedidos Activos
            </a>
            <%}%>
        </div>
    </div>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom menu-button">
             <button class='btn btn-primary' id='menu-toggle'>Menu</button>
        </nav>
        <input type="search" class="form-control form-inline col-sm-6" placeholder="Search..." name="search" autocomplete="off" id="caja_busqueda" >
        <div class="col-12">
        <table class="table table-striped table-responsive-sm table-responsive-md table-responsive-m table-responsive-lg">
            <input type="hidden" id="idUsuario" value="<%= idUser %>">
            <thead>
                <tr>
                    <th scope="col">Orden</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Pago total</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Acción</th>
                </tr>
            </thead>
            <tbody id="tabla">
                <%for(VentaModel venta : ventas){%>
                <tr>
                    <th scope="row"><%= venta.getIdventa() %></th>
                    <td><%= venta.getVentaFecha() %></td>
                    <td>$<%= df.format(venta.getTotalPagar()) %></td>
                    <%String estado = Type.EstadoPedido(venta.getVentaEstado());%>
                    <%if(estado.equals("Esperando confirmacion")){%>
                    <td style="color: gray"><%= estado %></td>
                    <%}else if(estado.equals("En proceso")){%>
                    <td style="color: #000000"><%= estado %></td>
                    <%}else if(estado.equals("En camino")){%>
                    <td style="color: #007bff"><%= estado %></td>
                    <%}else if(estado.equals("Entregado")){%>
                    <td style="color: green"><%= estado %></td>
                    <%}else if(estado.equals("Cancelado")){%>
                    <td style="color: red"><%= estado %></td>
                    <%}%>
                    <td>
                        <a href="Pedido?idPedido=<%= venta.getIdventa() %>&ref=mispedidos" class="btn btn-link">Ver</a>
                        <%if(venta.getVentaEstado() < 2){%>
                        <a href="Estado?estado=4&pedido=<%= venta.getIdventa() %>&ref=mispedidos" class="btn btn-danger">Cancelar</a>
                        <%}%>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
        </div>
    </div>

    <script
    src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
    crossorigin="anonymous"></script>
    <!-- Menu Toggle Script -->
    <script src="assents/js/menu-toggle.js"></script>
    <script src="assents/js/busqueda-ajax.js"></script>
</body>

</html>

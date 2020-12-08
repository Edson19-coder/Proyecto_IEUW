<%@page import="com.mycompany.ieuw_suministrospag.models.DireccionModel"%>
<% String user = (String) session.getAttribute("name_user_session");
    DireccionModel direccion = (DireccionModel) request.getAttribute("direccion");
    Integer Type = (Integer) session.getAttribute("userType_user_session");
%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Configuracion"/>
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
            <a href="Configuracion" class="list-group-item list-group-item-action select" style="color: white;">
                <i class='fas fa-cog' style='font-size:18px;color: white'></i>
                Configuracion
            </a>
            <a href="MisPedidos" class="list-group-item list-group-item-action">
                <i class='fas fa-box-open' style='font-size:18px;color: black'></i>
                Mis pedidos
            </a>
            <% if(Type == 1){ %>
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
        
        <div class="card col-12">
            <div class="card-footer">Direccion de envio</div>
            <div class="card-body">
                <% if (direccion != null) {%>
                <form class="col-10"  action="./Configuracion" method="POST">
                    <div class="form-group">
                        <label for="Pais">Pais</label>
                        <input type="text" class="form-control" id="Pais" name="Pais" value="<%= direccion.getDireccionPais()%>">
                    </div>
                    <div class="form-group">
                        <label for="Calle">Calle</label>
                        <input type="text" class="form-control" id="Calle" name="Calle" value="<%= direccion.getDireccionCalle()%>">
                    </div>
                    <div class="form-group">
                        <label for="cp">Codigo Postal</label>
                        <input type="number" class="form-control" id="cp" name="cp" value="<%= direccion.getDireccionCp()%>">
                    </div>
                    <div class="form-group">
                        <label for="Estado">Estado</label>
                        <input type="text" class="form-control" id="Estado" name="Estado" value="<%= direccion.getDireccionEstado()%>">
                    </div>
                    <div class="form-group">
                        <label for="Ciudad">Ciudad</label>
                        <input type="text" class="form-control" id="Ciudad" name="Ciudad" value="<%= direccion.getDireccionCiudad()%>">
                    </div>
                    <div class="form-group">
                        <label for="Colonia">Colonia</label>
                        <input type="text" class="form-control" id="Colonia" name="Colonia" value="<%= direccion.getDireccionColonia()%>">
                    </div>
                    <div class="form-group">
                        <label for="Telefono">Telefono</label>
                        <input type="Telefono" class="form-control" id="Telefono" name="Telefono" value="<%= direccion.getDireccionTelefono()%>">
                    </div>
                    <input type="hidden" class="form-control" name="accion" value="Actualizar">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </form>
                <%} else {%>
                <form class="col-10"  action="./Configuracion" method="POST">
                    <div class="form-group">
                        <label for="Pais">Pais</label>
                        <input type="text" class="form-control" id="Pais" name="Pais">
                    </div>
                    <div class="form-group">
                        <label for="Calle">Calle</label>
                        <input type="text" class="form-control" id="Calle" name="Calle">
                    </div>
                    <div class="form-group">
                        <label for="cp">Codigo Postal</label>
                        <input type="number" class="form-control" id="cp" name="cp">
                    </div>
                    <div class="form-group">
                        <label for="Estado">Estado</label>
                        <input type="text" class="form-control" id="Estado" name="Estado">
                    </div>
                    <div class="form-group">
                        <label for="Ciudad">Ciudad</label>
                        <input type="text" class="form-control" id="Ciudad" name="Ciudad">
                    </div>
                    <div class="form-group">
                        <label for="Colonia">Colonia</label>
                        <input type="text" class="form-control" id="Colonia" name="Colonia">
                    </div>
                    <div class="form-group">
                        <label for="Telefono">Telefono</label>
                        <input type="tel" class="form-control" id="Telefono" name="Telefono">
                    </div>
                    <input type="hidden" class="form-control" name="accion" value="Insertar">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </form>
                <%}%>
            </div>
        </div>

    </div>
</div>
</div>

<!-- Menu Toggle Script -->
<script src="assents/js/menu-toggle.js"></script>
</body>

</html>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.InStockModel"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.VentasMesModel"%>
<% String user = (String) session.getAttribute("name_user_session");
    List<VentasMesModel> ventas = (List<VentasMesModel>) request.getAttribute("ventasPorMes");
    Float ventaMesTotal = (Float) request.getAttribute("ventaMesTotal");
    Float ventaMesTotalAño = (Float) request.getAttribute("ventaMesTotalAño");
    InStockModel activos = (InStockModel) request.getAttribute("activos");
    int ventasEnero = 0, ventasFebrero = 0, ventasMarzo = 0, ventasAbril = 0, ventasMayo = 0, ventasJunio = 0, ventasJulio = 0,
            ventasAgosto = 0, ventasSeptimbre = 0, ventasOctubre = 0, ventasNoviembre = 0, ventasDiciembre = 0;
    for (VentasMesModel v : ventas) {
        switch (v.getMes()) {
            case 1: {
                ventasEnero = v.getCantidad();
                break;
            }
            case 2: {
                ventasFebrero = v.getCantidad();
                break;
            }
            case 3: {
                ventasMarzo = v.getCantidad();
                break;
            }
            case 4: {
                ventasAbril = v.getCantidad();
                break;
            }
            case 5: {
                ventasMayo = v.getCantidad();
                break;
            }
            case 6: {
                ventasJunio = v.getCantidad();
                break;
            }
            case 7: {
                ventasJulio = v.getCantidad();
                break;
            }
            case 8: {
                ventasAgosto = v.getCantidad();
                break;
            }
            case 9: {
                ventasSeptimbre = v.getCantidad();
                break;
            }
            case 10: {
                ventasOctubre = v.getCantidad();
                break;
            }
            case 11: {
                ventasNoviembre = v.getCantidad();
                break;
            }
            case 12: {
                ventasDiciembre = v.getCantidad();
                break;
            }
        }
    }
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
            <a href="Estadisticas" class="list-group-item list-group-item-action select" style="color: white;">
                <i class='fas fa-chart-bar' style='font-size:18px;color: white'></i>
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
            <a href="MisPedidos" class="list-group-item list-group-item-action">
                <i class='fas fa-box-open' style='font-size:18px;color: black'></i>
                Mis pedidos
            </a>
        </div>
    </div>

     <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom menu-button">
             
        </nav>  
        
        <div class="card col-12">
            <div id="#content">
                    <div class="container">
                        <div class="row">
                            <div class="card col-5">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-5 col-md-5 col-m-5 col-sm-5 text-center">
                                            <h6 class="text-muted">Ingresos del mes actual</h6>
                                            <h3 class="font-weight-bold">$<%= df.format(ventaMesTotal) %></h3>
                                        </div>
                                        <div class="col-lg-5 col-md-5 col-m-5 col-sm-5 text-center">
                                            <h6 class="text-muted">Ingresos del año actual</h6>
                                            <h3 class="font-weight-bold">$<%= df.format(ventaMesTotalAño) %></h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card col-5">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-5 col-md-5 col-m-5 col-sm-5 text-center">
                                            <h6 class="text-muted">Productos activos</h6>
                                            <h3 class="font-weight-bold"><%= activos.getProductoActivos() %></h3>
                                            <h3 class="text-success"><%= activos.getPorcentaje() %>%</h3>
                                        </div>
                                        <div class="col-lg-5 col-md-5 col-m-5 col-sm-5 text-center">
                                            <h6 class="text-muted">Productos Totales</h6>
                                            <h3 class="font-weight-bold"><%= activos.getProductosTotales() %></h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    <div class="cointainer col-10"style="padding-top: 10px">
                        <div class="card">
                            <div class="card-header">Ventas</div>
                            <div class="card-body">
                                <canvas id="myChart"></canvas>
                            </div>
                        </div>
                    </div>          
            </div>
        </div>

    </div>

</div>

<!-- Menu Toggle Script -->
<script src="assents/js/menu-toggle.js"></script>
<script src="assents/js/boton-jq.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha256-t9UJPrESBeG2ojKTIcFLPGF7nHi2vEc7f5A2KpH/UBU=" crossorigin="anonymous"></script>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agost', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            datasets: [{
                    label: 'Ventas por mes',
                    backgroundColor: 'rgb(199, 0, 57)',
                    borderColor: 'rgb(255, 99, 132)',
                    data: [<%= ventasEnero%>, <%= ventasFebrero%>, <%= ventasMarzo%>, <%= ventasAbril%>, <%= ventasMayo%>,
    <%= ventasJunio%>, <%= ventasJulio%>, <%= ventasAgosto%>, <%= ventasSeptimbre%>, <%= ventasOctubre%>,
    <%= ventasNoviembre%>, <%= ventasDiciembre%>]
                }]
        },

        // Configuration options go here
        options: {}
    });
</script>
</body>

</html>

<!--------------------------------------------------------- FIRST NAVBAR --------------------------------------------------------->
<nav class="navbar navbar-expand-lg navbar-dark main-nav-bar" style="background-color: #325ea0; width: 100%;">
    <%String us = request.getParameter("userSession");
        Integer userType = (Integer) session.getAttribute("userType_user_session");%>
    <a href="Home" class="navbar-brand" ><img
            src="https://dv.secoweb.mx/uploads/logo_dist/6824538aa9289d39e884fd71a8f62a08.png" alt=""></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" style="margin-top: 6px;">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse text-center" id="navbarNav">

        <form class="col-10" action="./SearchBar" method="GET">
            <input type="search" class="form-control form-inline mr-auto ml-auto col-sm-10" placeholder="Buscar..." name="search" onKeyPress="return checkSubmit(event)">
        </form>


        <ul class="navbar-nav">
            <li>
                <%
                    if (us != null) {
                %>
                <a href="ShoppingCart" id="carrito" class="nav-link fas fa-shopping-cart fa-lg" role="button" style="padding-top: 12px;"></a>
                <%}%>
            </li>
            <li class="nav-item dropdown">
                <%if (us == null) {%>
                <a href="#" class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 18px">Account <i class='far fa-user-circle' style='font-size:17px;color:rgba(255, 255, 255, 0.432)'></i>  </a>
                <%} else {%>
                <a href="#" class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 18px"><%= us%></a>
                <%}%>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <%
                        if (us == null) {
                    %>
                    <a href="Login" class="dropdown-item">
                        <i class='fas fa-sign-in-alt' style='font-size:18px;color: black'></i>
                        Login</a>
                    <a href="Register" class="dropdown-item">
                        <i class='fas fa-indent' style='font-size:18px;color: black'></i>
                        Register</a>
                        <%} else {
                            Integer id = (Integer) session.getAttribute("id_user_session");
                        %>
                    <a href="Configuracion" class="dropdown-item">
                        <i class='fas fa-cog' style='font-size:18px;color: black'></i>
                        Configuración</a>
                    <a href="MisPedidos" class="dropdown-item">
                        <i class='fas fa-box-open' style='font-size:18px;color: black'></i>
                        Mis pedidos</a>
                        <% if (userType == 1) {%>
                    <a href="Estadisticas" class="dropdown-item">
                        <i class='fas fa-chart-bar' style='font-size:18px;color: black'></i>
                        Estadística</a>
                    <a href="Pedidos" class="dropdown-item">
                        <i class='fas fa-clipboard-list' style='font-size:18px;color: black'></i>
                        Pedidos</a>
                        <%}%>
                    <a href="Logout" class="dropdown-item">
                        <i class='fas fa-sign-out-alt' style='font-size:18px;color: black'></i>
                        Salir</a>
                        <%}%>
                </div>
            </li>
        </ul>
    </div>
</nav>
<!--------------------------------------------------------- SECOND NAVBAR --------------------------------------------------------->
<nav class="navbar navbar-expand-lg navbar-light secondary-nav-bar sticky-top" style="background-color: white;">

    <div class="collapse navbar-collapse text-left" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="Home" class="nav-link select-nav">Inicio</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link">Nosotros</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link">Promociones</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link">Noticias</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link">Contacto</a>
            </li>
        </ul>

    </div>
</nav>

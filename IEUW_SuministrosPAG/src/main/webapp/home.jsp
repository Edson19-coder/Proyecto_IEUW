<%@page import="com.mycompany.ieuw_suministrospag.dao.UserDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ProductModel"%>
<%@page import="com.mycompany.ieuw_suministrospag.controller.HomeController"%>
<% String user = (String) session.getAttribute("name_user_session");
   Integer userOnboarding = (Integer) session.getAttribute("userOnboarding_user_session");
   Integer idUser = (Integer) session.getAttribute("id_user_session");
   List<ProductModel> productos = (List<ProductModel>) request.getAttribute("productos");
%>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Inicio"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
<%@include file= "navbar.jsp" %> 
<%}%>
<link rel="stylesheet" href="assents/css/home.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<!-- Carrusel -->
<div class="row">
    <div class="col">
        <div id="carousel-1z" class="carousel slide carousel-fade d-none d-sm-block" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item">
                    <a href="http://promocionalesweb.com/Catalogo-Navidad/">
                        <img class="d-block w-100"
                             src="https://dv.secoweb.mx/uploads/slideshow/7b8248faebe0623fc9cd5d98ce53c6f0.jpg">
                    </a>
                </div>
                <div class="carousel-item">
                    <a href="#">
                        <img class="d-block w-100"
                             src="https://dv.secoweb.mx/uploads/slideshow/71e137f753084c838e41579589501fa1.jpg">
                    </a>
                </div>
                <div class="carousel-item active">
                    <a href="#">
                        <img class="d-block w-100"
                             src="https://dv.secoweb.mx/uploads/slideshow/03ba11128f886ae3ec8a94e1534606cd.jpg">
                    </a>
                </div>
            </div>
            <ol class="carousel-indicators">
                <li data-target="#carousel-1z" data-slide-to="0" class=""></li>
                <li data-target="#carousel-1z" data-slide-to="1" class=""></li>
                <li data-target="#carousel-1z" data-slide-to="2" class="active"></li>
            </ol>
            <a class="carousel-control-prev" href="#carousel-1z" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"><i class="fa fa-angle-left"
                                                                               style="font-size:55px; color:#999!important;"></i></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel-1z" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"><i class="fa fa-angle-right"
                                                                               style="font-size:55px; color:#999!important;"></i></span>
                <span class="sr-only">Next</span>
            </a>
        </div>


        <div id="carousel_banner" class="carousel slide carousel-fade d-block d-sm-none" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <img class="d-block w-100"
                         src="https://dv.secoweb.mx/uploads/slideshow/1080x700_fcd60c56a3461ce373dd68c43ac7d2f6.jpg">
                </div>
                <div class="carousel-item">
                    <a href="https://dv.secoweb.mx/search?proveedor_id=62&amp;temporada_id=13">
                        <img class="d-block w-100"
                             src="https://dv.secoweb.mx/uploads/slideshow/1080x700_d29e08cc0d0d7370b9c88de0c8886f31.jpg">
                    </a>
                </div>
                <div class="carousel-item">
                    <a href="https://dv.secoweb.mx/search?proveedor_id=62&amp;temporada_id=14">
                        <img class="d-block w-100"
                             src="https://dv.secoweb.mx/uploads/slideshow/1080x700_70c986bd402ec81b9659c8b0d6843348.jpg">
                    </a>
                </div>
            </div>
            <ol class="carousel-indicators">
                <li data-target="#carousel_banner" data-slide-to="0" class="active"></li>
                <li data-target="#carousel_banner" data-slide-to="1"></li>
                <li data-target="#carousel_banner" data-slide-to="2"></li>
            </ol>
            <a class="carousel-control-prev" href="#carousel_banner" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"><i class="fa fa-angle-left"
                                                                               style="font-size:55px; color:#999!important;"></i></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel_banner" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"><i class="fa fa-angle-right"
                                                                               style="font-size:55px; color:#999!important;"></i></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>

<div class="container col-lg-12">
    <div class="row">
        <!-- Lado izquierdo -->
        <div class="container col-lg-3 col-mg-3 co1-sm-3 filters" id="filtros">
            <!-- filters -->
            <form>
                <div class="card-body text-center">
                    <a class="nav-link dropdown-toggle" id="flip" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Filtro</a>
                    <div class="col-12" id="panel">
                        <!-- Filtro por precio -->
                        <div class="row" style="margin-top: 10px;">
                            <label for="">Precio</label>
                        </div>
                        <div class="row">
                            <input type="text" placeholder="Min" class="col-5">
                            <div class="col-2 text-center">-</div>
                            <input type="text" placeholder="Max" class="col-5">
                        </div>
                        <!-- Filtro por categoria -->
                        <div class="row">
                            <label for="" style="margin-top: 10px;">Categoría</label>
                        </div>
                        <div class="row">
                            <select class="browser-default custom-select" name="categoria_id" id="categoria_id">
                                <option selected="" value="">Selecciona una categoría</option>
                                <option value="1">Bolsas, maletas y textiles</option>
                                <option value="2">Escritura y más</option>
                                <option value="3">Hogar y estilo de vida</option>
                                <option value="5">Llaveros, linternas y herramientas</option>
                                <option value="6">Oficina</option>
                                <option value="7">Salud y belleza</option>
                                <option value="8">Sublimación</option>
                                <option value="9">Tazas, termos y cilindros</option>
                                <option value="10">Tecnología</option>
                                <option value="11">Viaje y recreación</option>
                            </select>
                        </div>
                        <!-- Filtro por subcategoria -->
                        <div class="row" style="margin-top: 10px;">
                            <label for="">Sub categoría</label>
                        </div>
                        <div class="row">
                            <select class="browser-default custom-select" id="subcategoria_id" name="subcategoria_id">
                                <option value="" selected="">Selecciona una sub-categoría</option>
                            </select>
                        </div>
                        <div class="waves-input-wrapper waves-effect waves-light" style="padding: 10px">
                            <input class="btn btn-primary mx-auto d-block" style="background-color: #007bff!important;" type="submit" value="Buscar"></input>
                        </div>
                    </div>
                </div>
            </form>
            <!-- Seccions -->
            <div class="card-body text-center">
                <a class="nav-link dropdown-toggle" id="flip-dos" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categorias</a>
                <div class="col-12" id="panel-dos">
                    <ul class="list-group" id="panel2">
                        <a href="Home" class="selected">
                            <li class="list-group-item">Nuevos productos</li>
                        </a>
                        <a href="FiltroCategroia?search=Escritura y mas">
                            <li class="list-group-item">Escritura y más</li>
                        </a>
                        <a href="FiltroCategroia?search=Oficina">
                            <li class="list-group-item">Oficina</li>
                        </a>
                        <a href="FiltroCategroia?search=Tecnologia">
                            <li class="list-group-item">Tecnología</li>
                        </a>
                        <a href="FiltroCategroia?search=Llaveros, linternas y herramientas">
                            <li class="list-group-item">Llaveros, linternas y herramientas</li>
                        </a>
                        <a href="FiltroCategroia?search=Salud y belleza">
                            <li class="list-group-item">Salud y belleza</li>
                        </a>
                        <a href="FiltroCategroia?search=Bolsas, maletas y textiles">
                            <li class="list-group-item">Bolsas, maletas y textiles</li>
                        </a>
                        <a href="FiltroCategroia?search=Tazas, termos y cilindros">
                            <li class="list-group-item">Tazas, termos y cilindros</li>
                        </a>
                        <a href="FiltroCategroia?search=Hogar y estilo de vida">
                            <li class="list-group-item">Hogar y estilo de vida</li>
                        </a>
                        <a href="FiltroCategroia?search=Sublimacion">
                            <li class="list-group-item">Sublimación</li>
                        </a>
                        <a href="FiltroCategroia?search=Viaje y recreacion">
                            <li class="list-group-item">Viaje y recreación</li>
                        </a>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Lado derecho -->
        <div class="text-center container col-lg-9 col-mg-9 co1-sm-9 content">
            <h1 style="padding: 20px;">Productos más nuevos</h1>

            <div class="row" id="productos">
                <% for (ProductModel product : productos) {%>
                <!-- Card -->
                <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-6 mb-3" id="">
                    <a href="Product?Producto=<%= product.getIdproduct()%>" style="text-decoration: none;"
                       href="https://dv.secoweb.mx/items/index/CDP2729/suministrosag">
                        <div class="box product">
                            <img class="card-img-top" src="<%= product.getProductImgPath1()%>">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xl-8 col-lg-9 col-md-12 col-sm-12">
                                        <span style="padding-bottom:10px;"><b><%= product.getProductName()%></b></span><br>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <span class="badge badge-primary"><%= product.getIdproduct()%></span>
                                    </div>
                                    <div class="col-lg-6">
                                        <span class="price"><b>$<%= df.format(product.getProductCosto())%></b></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <%}%>
            </div>

        </div>
    </div>
</div>
            <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1 text-center">&copy; 2020 Suministros.A.G</p>
        <ul class="list-inline">
          <footer class="text-muted">
            <div class="container text-right">
                <% if(user!=null){ %>
                <a id="onboarding" class="btn btn-primary" style="background-color: #325ea0; border-color: #325ea0;">Tutorial</a>
                <%}%>
            </div>
          </footer>
        </ul>
      </footer>
            
<script
    src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
crossorigin="anonymous"></script>
<script src="assents/js/home-js.js"></script>
<script src="https://cdn.jsdelivr.net/npm/intro.js@3.1.0/intro.min.js"></script>
<%if(userOnboarding!=null){%>
    <%if(userOnboarding == 0){
        UserDAO.UpdateOnboarding(idUser);
        session.setAttribute("userOnboarding_user_session", 1);
    %>
    <script src="assents/js/onboarding-inicial.js"></script>
<%}}%>
<script src="assents/js/onboarding-home.js"></script>
</body>

</html>

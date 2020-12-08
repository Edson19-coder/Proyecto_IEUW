<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ProductModel"%>
<% String user = (String) session.getAttribute("name_user_session");
    ProductModel producto = (ProductModel) request.getAttribute("Producto"); %>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Producto"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
<%@include file= "navbar.jsp" %> 
<%}%>
<link rel="stylesheet" href="assents/css/product.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<!-- Carrusel -->
<div class="container col-lg-12">
    <div class="row">
        <!-- Parte izquierda -->
        <div class="container col-lg-6">
            <div class="col-lg-12 gallery" style="background-color: #ffffff; margin-top: 10px; margin-bottom: 10px;">   
                <div class="card-body">
                    <div id="carouselIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselIndicators" data-slide-to="1"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="<%= producto.getProductImgPath1()%>" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="<%= producto.getProductImgPath2()%>" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Parte derecha -->
        <div class="container col-lg-6" id="informacion">
            <div class="col-lg-12 product-information" style="background-color: #ffffff; margin-top: 10px; margin-bottom: 10px;">
                <div class="card-body">
                    <h4 class="h4-responsive"><b><%= producto.getProductName()%></b></h4>
                    <p style="color:gray">Modelo: <%= producto.getIdproduct()%></p>
                    <p><b>Descripción</b></p>
                    <p><%= producto.getProductDescripcion()%></p>
                    <table class="table table-bordered ">
                        <tbody>
                            <tr>
                                <td style="padding:8px;">Material</td>
                                <td style="padding:8px;"><%= producto.getProductMaterial()%></td>
                            </tr>
                            <tr>
                                <td style="padding:8px;">Medidas del producto</td>
                                <td style="padding:8px;"><%= producto.getProductMedidas()%></td>
                            </tr>
                            <tr>
                                <td style="padding:8px;">Unidad empaque</td>
                                <td style="padding:8px;"><%= producto.getProductUnidadEmpaque()%></td>
                            </tr>
                            <tr>
                                <td style="padding:8px;">Medida caja master</td>
                                <td style="padding:8px;"><%= producto.getProductMedidaCaja()%></td>
                            </tr>
                            <tr>
                                <td style="padding:8px;">Peso caja</td>
                                <td style="padding:8px;"><%= producto.getProductPesoCaja()%></td>
                            </tr>
                        </tbody>
                    </table>
                    <h4 class="h4-responsive"><b>Existencias</b></h4>
                    <p style="color:#9e9e9e">*Indica los servicios adicionales requeridos al cotizar en el campo de
                        observaciones</p>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Clave</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Observaciones</th>
                                </tr>
                            </thead>
                            <form action="./AgregarProducto" method="POST" >
                                <tbody id="tabla_cuerpo">

                                    <tr>
                                        <td style="width:70px;">
                                            <%= producto.getIdproduct() %><br>
                                            <img class="img-fluid" src="<%= producto.getProductImgPath1() %>">
                                        </td>
                                        <td>$<%= df.format(producto.getProductCosto()) %></td>
                                        <td><input name="clave" class="d-none">
                                            <input style="width:110px;" name="cantidad" id="txt-cantidad" type="number" class="form-control" min="1" value="0">
                                        </td>
                                        <td><textarea name="observacion" style="width:120px;" class="form-control"></textarea></td>
                                        <td><input type="hidden" value="<%= producto.getIdproduct() %>" name="idproducto"></td>
                                        </tr>
                                    <tr>
                                        <td colspan="6"><button type="submit" id="addProduto" class="btn btn-primary waves-effect waves-light fas fa-cart-plus"> Añadir a carrito</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </form>
                        </table>
                    </div>

                    <h5 class="h5-responsive">Los precios incluyen el IVA.</h5>
                </div>
            </div>
        </div>
    </div>
</div>
                                        <script
    src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/intro.js@3.1.0/intro.min.js"></script>
<script src="assents/js/onboarding-product.js"></script>
</body>

</html>
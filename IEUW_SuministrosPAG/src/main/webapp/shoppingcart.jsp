<%@page import="com.mycompany.ieuw_suministrospag.models.DireccionModel"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mycompany.ieuw_suministrospag.dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ArtiuculoModel"%>
<%
    ArrayList<ArtiuculoModel> articulos = (ArrayList<ArtiuculoModel>) (session.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList<ArtiuculoModel>) session.getAttribute("carrito"));
    DireccionModel direccion = (DireccionModel) request.getAttribute("direccion");
%>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ProductModel"%>
<% String user = (String) session.getAttribute("name_user_session");%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Carrito de Compras"/>
</jsp:include>
<% if (user != null) {%>
<jsp:include page="navbar.jsp">
    <jsp:param name="userSession" value="<%=user%>" />
</jsp:include>
<%} else {%>
<%@include file= "navbar.jsp" %> 
<%}%>

<link rel="stylesheet" href="assents/css/shoppingcart.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<div class="card-body">
    <form action="./ShoppingCart" method="POST">
        <div class="container col-xl-10 col-lg-10 col-md-10 col-md-10 shp-cart-cont" style="padding: 10px;">
            <table class="table table-responsive-sm table-responsive-md table-responsive-m table-responsive-lg" id="tabla">
                <thead style="background-color: #325ea0; color: white;">
                    <tr>
                        <th scope="col">Modelo</th>
                        <th scope="col">Imagen</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Importe</th>
                        <th scope="col">Observaciones</th>
                        <th scope="col">Acci�n</th>
                    </tr>
                </thead>
                <tbody>
                    <% float importeTotal = 0;
                        for (ArtiuculoModel a : articulos) {
                            ProductModel producto = ProductDAO.GetProducto(a.getIdProducto());
                            %>
                    <tr>
                        <th scope="row"><%= producto.getIdproduct()%></th>
                        <td><img class="img-fluid" style="height: 50px;"
                                 src="<%= producto.getProductImgPath1()%>"></td>
                        <td><%= producto.getProductName()%></td>
                        <td>$<%= producto.getProductCosto()%></td>
                        <td><%= a.getCantidad()%></td>
                        <% float importe = producto.getProductCosto() * a.getCantidad();
                        importeTotal = importeTotal + importe;%>
                        <td>$<%= df.format(importe) %></td>
                        <td><%= a.getComentario()%></td>
                        <td>
                            <a href="DeleteArticulo?idarticulo=<%= producto.getIdproduct()%>" id="deletearticulo" style="color:#aa0719; text-decoration: none;"><i class="fas fa-trash"></i> Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <div class="row">
                <div class="col-xl-8 col-lg-8 col-md-8 col-md-8 table-bordered" style="padding: 20px" >
                    <div class="card-footer text-center"> Direcci�n de env�o </div>
                    <div class="card-body">
                        <% if (direccion != null) {%>
                        <div class="row">
                            <div class="col-6">
                                <label class="col-12">Pa�s: <%= direccion.getDireccionPais()%></label>
                                <label class="col-12">C�digo Postal: <%= direccion.getDireccionCp()%></label>
                                <label class="col-12">Ciudad: <%= direccion.getDireccionCiudad()%></label>
                                <label class="col-12">Tel�fono: <%= direccion.getDireccionTelefono()%></label>
                            </div>
                            <div class="col-6">
                                <label class="col-12">Calle: <%= direccion.getDireccionCalle()%></label>
                                <label class="col-12">Estado: <%= direccion.getDireccionEstado()%></label>
                                <label class="col-12">Colonia: <%= direccion.getDireccionColonia()%></label>
                                <a href="Configuracion" class="btn btn-primary">Editar</a>
                            </div>
                        </div>
                        <%} else {%>
                        <div class="col-10 text-center">
                            <a href="Configuracion" class="btn btn-primary">A�adir direcci�n</a>
                        </div>
                        <%}%>
                    </div>
                </div>
                <div class="col-xl-4 col-lg-4 col-md-4 col-md-4 text-right table-bordered" style="padding: 10px;">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-md-12 pago">
                        <p>Sub Total: $<%= df.format(importeTotal)%></p>
                    </div>
                    <div class="col-xl-12 col-lg-12 col-md-12 col-md-12 pago">
                        <p>Costo de env�o $150</p>
                    </div>
                    <div class="col-xl-12 col-lg-12 col-md-12 col-md-12 pago">
                        <% Float total = importeTotal + 150;%>
                        <input type="hidden" name="total" value="<%= total %>" />
                        <p>Costo Total: $<%= total%></p>
                    </div>
                </div>
            </div>  
            <div class="col-12" style="text-align: right; padding-top: 10px">

                <div class="panel panel-default" >
                    <div class="panel-heading">

                        <div class="row ">
                            <div class="col-md-12">
                                <input type="text" class="form-control" name="numero_tarjeta" placeholder="N�mero de tarjeta" />
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font" > Mes de expiraci�n</span>
                                <input type="text" class="form-control" name="mes_exp" placeholder="MM" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font" >  A�o de expiraci�n</span>
                                <input type="text" class="form-control" name="a�o_exp" placeholder="YY" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font" >  CCV</span>
                                <input type="text" class="form-control" name="ccv" placeholder="CCV" />
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="far fa-credit-card"></span>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-md-12 pad-adjust" style="padding: 10px;">

                                <input type="text" class="form-control" name="titular" placeholder="Nombre del titular" />
                            </div>
                        </div>
                        <div class="row">
                        </div>
                        <div class="row ">
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">

                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                <input type="submit"  class="btn btn-primary btn-block" value="Realizar pedido" id="pagar" />
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="assents/js/shoppingcart.js"></script>
<script
    src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/intro.js@3.1.0/intro.min.js"></script>
<script src="assents/js/onboarding-shoppingcart.js"></script>
</body>

</html>

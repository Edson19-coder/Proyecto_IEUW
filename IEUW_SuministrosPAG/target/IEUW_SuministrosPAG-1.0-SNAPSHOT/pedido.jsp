<%@page import="java.lang.String"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ProductosVentaModel"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.VentaModel"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.DireccionModel"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mycompany.ieuw_suministrospag.dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ArtiuculoModel"%>
<%
    VentaModel pedido = (VentaModel) request.getAttribute("pedido");
    List<ProductosVentaModel> productos = (List<ProductosVentaModel>) request.getAttribute("productos");
    String volver = (String) request.getAttribute("ref");
    float subtotal = 0;
    float total = 0;
%>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ProductModel"%>
<% String user = (String) session.getAttribute("name_user_session");%>
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

<link rel="stylesheet" href="assents/css/shoppingcart.css">
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
<div class="card-body">
        <div class="container col-xl-10 col-lg-10 col-md-10 col-md-10 shp-cart-cont" style="padding: 10px;">
            <table class="table table-responsive-sm table-responsive-md table-responsive-m table-responsive-lg">
                <thead style="background-color: #325ea0; color: white;">
                    <tr>
                        <th scope="col">Model</th>
                        <th scope="col">Imagen</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Importe</th>
                        <th scope="col">Observaciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%for(ProductosVentaModel a : productos){
                        ProductModel producto = ProductDAO.GetProducto(a.getProductosVentaProducto());
                    %>
                    <tr>
                        <th scope="row"><%= producto.getIdproduct() %></th>
                        <td><img class="img-fluid" style="height: 50px;" src="<%= producto.getProductImgPath1() %>"></td>
                        <td><%= producto.getProductName() %></td>
                        <td>$<%= df.format(producto.getProductCosto()) %></td>
                        <td><%= a.getProductosVentaCantidad() %></td>
                        <% float importe = producto.getProductCosto() * a.getProductosVentaCantidad(); 
                            subtotal = subtotal + importe;%>
                            <td>$<%= df.format(importe) %></td>
                        <td><%= a.getProductosVentaObservacion() %></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <div class="row">
                <div class="col-xl-8 col-lg-8 col-md-8 col-md-8 table-bordered" style="padding: 20px">
                    <div class="card-footer text-center"> Direccion de envio </div>
                    <div class="card-body">
                        
                        <div class="row">
                            <div class="col-6">
                                <label class="col-12">Pais: México</label>
                                <label class="col-12">Codigo Postal: 66057</label>
                                <label class="col-12">Ciudad: Escobedo</label>
                                <label class="col-12">Telefono: 8128949908</label>
                            </div>
                            <div class="col-6">
                                <label class="col-12">Calle: Naranjos</label>
                                <label class="col-12">Estado: Nuevo Leon</label>
                                <label class="col-12">Colonia: Residencia Escobedo</label>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="col-xl-4 col-lg-4 col-md-4 col-md-4 text-right table-bordered" style="padding: 10px;">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-md-12 pago">
                        <p>Sub Total: $<%= df.format(subtotal) %></p>
                    </div>
                    <div class="col-xl-12 col-lg-12 col-md-12 col-md-12 pago">
                        <p>Costo de envio: $150.00</p>
                    </div>
                    <div class="col-xl-12 col-lg-12 col-md-12 col-md-12 pago">
                        
                        <input type="hidden" name="total" value="150.0">
                        <% total = subtotal + 150; %>
                        <p>Costo Total: $<%= df.format(total) %></p>
                    </div>
                </div>
            </div>  
            <div class="col-12" style="text-align: right; padding-top: 10px">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row ">
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">

                            </div>
                            <%if(volver.equals("pedidos")){%>
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                <a href="Pedidos" class="btn btn-primary btn-block">Regresar</a>
                            </div>
                            <%}else{%>
                            <div class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                                <a href="MisPedidos" class="btn btn-primary btn-block">Regresar</a>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
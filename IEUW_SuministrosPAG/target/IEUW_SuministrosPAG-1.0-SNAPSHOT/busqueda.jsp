<%@page import="com.mycompany.ieuw_suministrospag.dao.UserDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ieuw_suministrospag.models.ProductModel"%>
<%@page import="com.mycompany.ieuw_suministrospag.controller.HomeController"%>
<% String user = (String) session.getAttribute("name_user_session");
   List<ProductModel> productos = (List<ProductModel>) request.getAttribute("productos");
   String search = request.getParameter("search");
%>
<% DecimalFormat df = new DecimalFormat("#.00");%>
<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Busqueda"/>
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
<div class="container col-lg-10">
    <div class="text-center">
            <h1 style="padding: 20px;">Resultados de la busqueda "<%= search %>"</h1>
            </div>
            <div class="row" id="productos">
                <% if(productos.size()!=0){
                    for (ProductModel product : productos) {%>
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
                <%}}%>
            </div>
    </div>
</div>
            <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1 text-center">&copy; 2020 Suministros.A.G</p>
        <ul class="list-inline">
          <footer class="text-muted">
            <div class="container text-right">
            </div>
          </footer>
        </ul>
      </footer>
            
<script
    src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
crossorigin="anonymous"></script>
<script src="assents/js/home-js.js"></script>
</body>

</html>


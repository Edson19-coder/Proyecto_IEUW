<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingresar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="assents/css/loginstyle.css">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</head>

<body>
   <!--------------------------------------------------------- CONTENT --------------------------------------------------------->
    <div class="model-dialog text-center ">
        <div class="col-sm-4 main-section">
            <div class="modal-content model-content-main">
                <div class="col-12">
                    <a href="Home" ><img src="https://dv.secoweb.mx/uploads/logo_dist/6824538aa9289d39e884fd71a8f62a08.png" alt=""></a>
                </div>
                <form action="./Login" method="POST" class="col-12">
                    <div class="form-group">
                        <input type="text" name="user_name" id="" placeholder="Usuario" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" name="user_password" id="" placeholder="Contraseña" class="form-control">
                    </div>
                    <button id="btn-login-id" type="submit" class="btn btn-primary col-6">Ingresar</button>
                </form>
                <a href="Register" class="register-a">Registrarse</a>
            </div>
        </div>
    </div>
</body>

</html>

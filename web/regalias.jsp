
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SoundMusic</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="img/png" href="icon/musica.png"/>
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
        <link href="style/regalias.style.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="sweetarlert/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <%@include file="navbar.jsp" %>

        <div class="container main-container">

            <h2>Lista de Pagos</h2>
            <hr>
            <br>
            <div class="row">
                <div class="col-md-12">

                    <h4>Artista</h4>
                    <hr>
                    <br>

                    <div class="row">
                        <div class="col">
                            <a href="caluloRegalias.jsp" class="btn btn-success">CalcularRegalias</a>
                        </div>
                    </div>

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre Artista</th>
                                <th>Bonificacion</th>
                                <th>Empresa Difunsora</th>
                                <th>Fecha de Pago</th>
                                <th>Sueldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Martin Garrix</td>
                                <td> </td>
                                <td>Spinin Records</td>
                                <td>11/09/2018 00:00PM</td>
                                <td class="text-success">$500.000 COP</td>
                                <td><a href="#" class="badge badge-danger btnActivar" activarRegalias="">Pendiente</a></td>
                            </tr>

                            <tr>
                                <td>Martin Garrix</td>
                                <td></td>
                                <td>Spinin Records</td>
                                <td>11/09/2018 00:00PM</td>
                                <td class="text-success">$500.000 COP</td>
                                <td><a href="#" class="badge badge-danger btnActivar" activarRegalias="">Pendiente</a></td>
                            </tr>
                        </tbody>
                    </table>


                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="sweetarlert/sweetalert2.min.js" type="text/javascript"></script>
        <script src="js/regalias.js" type="text/javascript"></script>
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>

</html>
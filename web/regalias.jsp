
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

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th></th>
                                <th>Nombre Artista</th>
                                <th>Albun</th>
                                <th>Empresa Difunsora</th>
                                <th>Fecha de Pago</th>
                                <th>Sueldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <div class="custom-control custom-checkbox posicion-checkbox">
                                        <input type="checkbox" name="check" class="custom-control-input" id="check">
                                        <label class="custom-control-label" for="check"></label>

                                    </div>
                                </td>
                                <td>Martin Garrix</td>
                                <td>Animals</td>
                                <td>Spinin Records</td>
                                <td>11/09/2018 00:00PM</td>
                                <td class="text-success">$500.000 COP</td>
                                <td class="text-danger">No Listo</td>
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
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>

</html>
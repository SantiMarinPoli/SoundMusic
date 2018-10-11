<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SoundMusic</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="img/png" href="icon/musica.png"/>
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="style/auditoria.style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <%@include file="navbar.jsp" %>

        <div class="container main-container">

            <h2>Log de Auditoria</h2>
            <hr>
            <br>


            <div class="row">
                <div class="col-md-12">

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre de Usuario</th>
                                <th>Tipo Usuario</th>
                                <th>Fecha Modificacion</th>
                                <th>Operaciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>1</th>
                                <td>admin</td>
                                <td>Administrador</td>
                                <td>11/09/2018 15:05PM</td>
                                <td>
                                    <span class="badge badge-primary">Modificar Usuario</span>
                                </td>
                            </tr>
                            <tr>
                                <th>2</th>
                                <td>santiMarin</td>
                                <td>Operador</td>
                                <td>12/09/2018 10:05AM</td>
                                <td>
                                    <span class="badge badge-primary">Modificar Usuario</span>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <%@include file="pruebasTablas/listaLogAuditoria.jsp" %>

                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>

</html>
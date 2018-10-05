
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

    </head>

    <body>

        <%@include file="navbar.jsp" %>

        <div class="container main-container">
            <div class="row animated fadeIn fast">
                <div class="col-md-12">

                    <h3>Modulo de Usuarios</h3>
                    <hr>
                    <br>
                    <div class="row">
                        
                        <div class="col">
                            <a href="registrarUsuario.jsp" class="btn btn-success" id="registrarUsuario">Registrar Usuario</a>
                        </div>
                    </div>

                    <br>

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre Completo</th>
                                <th scope="col">Sexo</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Tipo de Usuario</th>
                                <th scope="col">Nombre Usuario</th>
                                <th scope="col">Fecha Entrada</th>
                                <th scope="col">Activo</th>
                                <th scope="col">Operaciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Sr. Administrador</td>
                                <td>Masculino</td>
                                <td>admin@mcl.com</td>
                                <td>Administrador</td>
                                <td>admin</td>
                                <td>22/08/2018 18:44</td>
                                <td><a href="#" class="badge badge-success btnActivar" idUsuario="1" activarUsuario="0">Activado</a></td>
                                <td><a href="modificarUsuario.jsp" class="btn btn-warning">Actualizar</a></td>
                            </tr>

                            <tr>
                                <th scope="row">2</th>
                                <td>Santiago Cortes</td>
                                <td>Masculino</td>
                                <td>santicortes@mcl.com</td>
                                <td>Operador</td>
                                <td>santiC</td>
                                <td>21/08/2018 9:00</td>
                                <td><a href="#" class="badge badge-success btnActivar" activarUsuario="0">Activado</a></td>
                                <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                            </tr>

                            <tr>
                                <th scope="row">3</th>
                                <td>Melany Palacios</td>
                                <td>Femenino</td>
                                <td>melany@mcl.com</td>
                                <td>Operador</td>
                                <td>melany</td>
                                <td>21/08/2018 12:10</td>
                                <td><a href="#" class="badge badge-success btnActivar" idUsuario="1" activarUsuario="0">Activado</a></td>
                                <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                            </tr>

                            <tr>
                                <th scope="row">4</th>
                                <td>Santiago Medina</td>
                                <td>Masculino</td>
                                <td>santiagoM@mcl.com</td>
                                <td>Operador</td>
                                <td>santiM</td>
                                <td>24/08/2018 13:10</td>
                                <td><a href="#" class="badge badge-success btnActivar" idUsuario="1" activarUsuario="0">Activado</a></td>
                                <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/usuario.js" type="text/javascript"></script>
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>

</html>
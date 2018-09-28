
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
        <link href="sweetarlert/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <div class="container main-container">

            <div class="row">
                <div class="col-md-2"></div>

                <div class="col-md-8">

                    <h3>Registro de Usuario</h3>
                    <hr>
                    <br>

                    <div class="row">
                        <div class="col">
                            <a href="usuario.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                            <button type="button" class="btn btn-success" id="btn-nuevoRegistro">Agregar Nuevo Usuario</button>
                        </div>
                    </div>

                    <br>

                    <form name="formulario_usuario" action="" method="post">
                        <input type="hidden" name="cod" value="0">



                        <div class="form-row">
                            <div class="col">
                                <label>Primer Nombre*</label>
                                <input type="text" class="form-control " name="nombre1" id="nom1 texto" placeholder="Ingresar el primer nombre" >
                                <div class="invalid-feedback ">El primer nombre es un campo obligatorio</div>

                            </div>
                            <div class="col">
                                <label>Segundo Nombre</label>
                                <input type="text" class="form-control" name="nombre2" id="nom2" placeholder="Ingresar el segundo nombre">
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>Primer Apellido*</label>
                                <input type="text" class="form-control " name="apellido1" id="apellido1 texto" placeholder="Ingresar el primer apellido " >
                                <div class="invalid-feedback ">El primer apellido es un campo obligatorio</div>

                            </div>
                            <div class="col">
                                <label>Segundo Apellido*</label>
                                <input type="text" class="form-control " name="apellido2" id="apellido2 texto" placeholder="Ingresar el segundo apellido">
                                <div class="invalid-feedback ">El segundo apellido es un campo obligatorio</div>
                            </div>
                        </div>

                        <div class="form-group radio">
                            <br>
                            <h8>Genero*</h8>
                            <br>
                            <input class="form-check-input " type="radio" name="sexo" id="textSex1" value="Masculino" >
                            <label class="form-check-label " for="textSex1">Masculino</label>

                            <input class="form-check-input " type="radio" name="sexo" id="textSex2" value="Femenino">
                            <label class="form-check-label" for="textSex2">Femenino</label>
                            <br>
                            <div class="invalid-feedback ">Debe seleccionar un campo</div>

                        </div>

                        <!--<div class="form-group">
                            <label>Fecha de Nacimiento*</label>
                            <input type="date" name="fechaNac" id="birthDate" class="form-control" >
                            <div class="invalid-feedback ">La fecha de nacimiento es un campo obligatorio</div>
                        </div>-->

                        <div class="form-group">
                            <label>Correo*</label>
                            <input type="email" name="email" id="email" class="form-control" placeholder="Ingresar el correo electronico">
                            <div class="invalid-feedback ">El correo electronico es un campo obligatorio</div>

                        </div>

                        <div class="form-group">
                            <label>Nombre del Usuario*</label>
                            <input type="text" class="form-control" name="nomUsuario" id="textNameUser" placeholder="Ingresar el nuevo usuario del operador" >
                            <div class="invalid-feedback ">El nombre de usuario es un campo obligatorio</div>

                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label>Contraseña*</label>
                                <input type="password" class="form-control" name="pass1" id="textPass" placeholder="Password" >
                                <div class="invalid-feedback ">La contraseña debe ser obligatorio</div>
                            </div>
                            <div class="col">
                                <label>Repita Contraseña*</label>
                                <input type="password" class="form-control" name="pass2" id="textRepeatPass" placeholder="Password" >
                                <div class="invalid-feedback ">La contraseña debe ser igual dato</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label >Numero del Celular*</label>
                                <input type="number" class="form-control" name="numCel" id="numCel"placeholder="Ingrese el numero de celular" >
                                <div class="invalid-feedback ">El numero celular debe ser obligatorio</div>
                            </div>
                            <div class="col">
                                <label >Numero del Telefono</label>
                                <input type="number" class="form-control" name="numTel" id="numTel"placeholder="Ingrese el numero de telefonico" >
                                <div class="invalid-feedback ">El numero telefonico debe ser obligatorio</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <label>Direccion Actual</label>
                            <input type="text" name="direccion" id="direccion" class="form-control" placeholder="Ingresar la direccion actual">
                        </div>

                        <div class="form-group">
                            <label>Barrio</label>
                            <input type="text" name="barrio" id="barrio" class="form-control" placeholder="Ingresar el barrio">
                        </div>

                        <div class="form-check checkbox">
                            <input class="form-check-input" type="checkbox" id="check" >
                            <label class="form-check-label" for="check">
                                Terminos y condiciones
                            </label>
                            <div class="invalid-feedback ">Este campo es obligatorio</div>
                        </div>

                        <br>
                        <input type="submit" value="Registrar Usuario" class="btn btn-primary" id="btnGuardar">
                    </form>
                </div>
            </div>
            <div class="col-md-2"></div>

        </div>
    </div>

    <!--SCRIPT-->
    <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
    <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
    <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
    <script src="sweetarlert/sweetalert2.min.js" type="text/javascript"></script>
    <script src="js/validacionUsuario.js" type="text/javascript"></script>
</body>

</html>
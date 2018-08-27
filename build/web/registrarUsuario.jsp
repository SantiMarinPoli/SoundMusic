
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


            <div class="row">
                <div class="col-md-2"></div>

                <div class="col-md-8">

                    <h3>Registro de Usuario</h3>
                    <hr>
                    <br>

                    <form>
                        <div class="form-group">
                            <label>Identificacion</label>
                            <input type="number" class="form-control" id="textId" placeholder="Ingrese el numero Idenficacion">
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label>Nombre</label>
                                <input type="text" class="form-control" id="textName" placeholder="Ingresar el nombre del operador">
                            </div>
                            <div class="col">
                                <label>Apellido</label>
                                <input type="text" class="form-control" id="textLastname" placeholder="Ingresar el apellido del operador">
                            </div>
                        </div>

                        <div class="form-group">
                            <br>
                            <label>Genero</label>
                            <br>
                            <div class="form-check-inline">
                                <input class="form-check-input" type="radio" name="sexo" id="textSex1" value="Masculino">
                                <label class="form-check-label" for="textSex1">Masculino</label>
                            </div>
                            <div class=" form-check-inline">
                                <input class="form-check-input" type="radio" name="sexo" id="textSex2" value="Femenino">
                                <label class="form-check-label" for="textSex2">Femenino</label>
                            </div>                         
                        </div>

                        <div class="form-group">
                            <label>Fecha de Nacimiento</label>
                            <input type="date" name="fechaNac" id="birthDate" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>Nombre del Usuario</label>
                            <input type="text" class="form-control" id="textNameUser" placeholder="Ingresar el nuevo usuario del operador">
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label>Contraseña</label>
                                <input type="password" class="form-control" id="textPass" placeholder="Password">
                            </div>
                            <div class="col">
                                <label>Repita Contraseña</label>
                                <input type="password" class="form-control" id="textRepeatPass" placeholder="Password">
                            </div>
                        </div>
                        
                        <br>

                        <div class="form-group">
                            <label >Numero del Celular</label>
                            <input type="number" class="form-control" name="numCelular" id="numPhone"placeholder="Ingrese el numero de celular"
                        </div>
                        
                        <br>
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="check">
                                <label class="form-check-label" for="check">
                                    Terminos y condiciones
                                </label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary" id="btnGuardar">Registrar Usuario</button>
 
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
</body>

</html>
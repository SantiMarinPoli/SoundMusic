
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
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>

    </head>
      
    <body class="bg">
        
        
        <div class="container-fluid">
                <div class="row animated fadeIn fast ">
                    <div class="col-md-4 col-sm-4 col-xs-12"></div>
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        

                        <form class="form-container">
                                <h1>Iniciar Sesion</h1>
                                <div class="form-group">
                                  <label for="exampleInputEmail1">Nombre del Usuario</label>
                                  <input type="email" class="form-control" id="textUsuario" placeholder="Ingresar el nombre del usuario">
                                </div>
                                <div class="form-group">
                                  <label for="exampleInputPassword1">Contraseña</label>
                                  <input type="password" class="form-control" id="textPassword" placeholder="Ingredar la contraseña">
                                </div>
                            
                            <button type="submit" class="btn btn-success btn-block" id="btnIngresar">Ingresar</button>
                        </form>

                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12"></div>
                </div>
         </div>
         
        <!--SCRIPT-->
         <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
    </body>
    
</html>

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
        <div class="container main-container">

            <div class="row">
                <div class="col-md-2"></div>

                <div class="col-md-8">

                    <h3>Registro de Empresa Difunsora</h3>
                    <hr>

                    <div class="row">
                        <div class="col">
                            <a href="empresa.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                            <button type="button" class="btn btn-success" id="btn-nuevoRegistro">Agregar Nueva Empresa</button>
                        </div>
                    </div>

                    <br>

                    <form>
                        <div class="form-group">
                            <label>Nombre de la Compañia</label>
                            <input type="text" class="form-control" name="nomEmpresa" id="nomEmpresaTxt" placeholder="Ingresar la empresa difunsora">
                        </div>

                        <div class="form-group">
                            <label>Seleccionar una imagen de la empresa</label>
                            <input type="file" class="form-control-file" name="fotoArtista" id="imageArtista">
                        </div>

                        <div class="form-group bg-light">
                            <label>Tipo de Empresa</label>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa1Txt" value="Audio">
                                <label for="tipoEmpresa1Txt">Audio</label>
                            </div>

                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa2Txt" value="Video">
                                <label for="tipoEmpresa2Txt">Video</label>
                            </div>

                            <div class=" form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa3Txt" value="Descarga">
                                <label for="tipoEmpresa3Txt">Descarga</label>
                            </div>

                        </div>

                        <div class="form-group">
                            <label>Agregar Artista</label>
                            <input type="text" class="form-control" id="textAgregarArtista" placeholder="Agregar artista"> 
                        </div>

                        <div class="form-group">
                            <button type="button" class="btn btn-outline-primary  " id="btnAgregarArtista">Agregar Artista</button>
                        </div>

                        <div class="form-group">
                            <ul class="list-group listaArtista" id="lista">
                                <li class="list-group-item disabled "><a href="#" >Guns and Roses</a></li>
                                <li class="list-group-item disabled "><a href="#" >JBailvin</a></li>
                                <li class="list-group-item disabled "><a href="#" >Beatles</a></li>
                                <li class="list-group-item disabled "><a href="#" >Avicci</a></li>
                            </ul>

                        </div>

                        <button type="submit" class="btn btn-outline-primary btn-block" id="btnGuardar">Guardar Empresa</button>

                    </form>
                </div>
            </div>
            <div class="col-md-2"></div>

        </div>
        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/agregarArtista.js" type="text/javascript"></script>
    </body>

</html>
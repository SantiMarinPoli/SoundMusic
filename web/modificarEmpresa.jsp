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

                    <h3>Modificar Empresa Difunsora</h3>
                    <hr>

                    <div class="row">
                        <div class="col">
                            <a href="empresa.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                            <button type="button" class="btn btn-success" id="btn-nuevoRegistro">Agregar Nueva Empresa</button>
                        </div>
                    </div>

                    <br>

                    <form name="formulario_empresa">
                        <input type="hidden" name="cod" value="0">

                        <div class="form-group">
                            <label>Nombre de la Compañia*</label>
                            <input type="text" class="form-control" name="nomEmpresa" id="nomEmpresaTxt" placeholder="Ingresar la empresa difunsora">
                            <div class="invalid-feedback">El campo nombre empresa debe ser obligatorio</div>
                        </div>

                        <div class="form-group">
                            <label>Seleccionar una imagen de la empresa</label>
                            <input type="file" class="form-control-file" name="fotoArtista" id="imageArtista">
                        </div>

                        <div class="form-group bg-light radio">
                            <h8> Tipo de Empresa*</h8>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa1Txt" value="Audio">
                                <label for="tipoEmpresa1Txt" class="form-check-label error">Audio</label>
                            </div>

                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa2Txt" value="Descarga">
                                <label for="tipoEmpresa2Txt" class="form-check-label">Descarga</label>
                            </div>

                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa3Txt" value="Video">
                                <label for="tipoEmpresa3Txt" class="form-check-label">Video</label>
                                <div class="invalid-feedback">Seleccionar una seleccion en el campo tipo empresa.</div>
                            </div>

                        </div>


                        <div class="form-group">
                            <label>Agregar Artista</label>
                            <input type="text" name="agregarArtista"  class="form-control" id="textAgregarArtista" placeholder="Agregar artista"> 
                        </div>

                        <div class="form-group">
                            <button type="button" class="btn btn-outline-primary  " id="btnAgregarArtista">Agregar Artista</button>
                        </div>

                        <div class="form-group ">
                            <ul class="list-group listaArtista" id="lista">
                                <li class="list-group-item disabled "><a href="#" >Guns and Roses</a></li>
                                <li class="list-group-item disabled "><a href="#" >JBailvin</a></li>
                                <li class="list-group-item disabled "><a href="#" >Beatles</a></li>
                                <li class="list-group-item disabled "><a href="#" >Avicci</a></li>
                            </ul>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>Total numero de albunes</label>
                                <input type="number" name="totalnumAlbunes" class="form-control" value="10" disabled="">
                            </div>
                            <div class="col">
                                <label>Total de albunes</label>
                                <input tytype="text" name="totalAlbunes" class="form-control" value="$ 30.000.000 COP" disabled="">
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>Total numero de canciones</label>
                                <input type="number" name="totalnumCanciones" class="form-control" value="30" disabled="">
                            </div>
                            <div class="col">
                                <label>Total de canciones</label>
                                <input tytype="text" name="totalCanciones" class="form-control" value="$ 100.000.000 COP" disabled="">
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <div class="form-check checkbox">
                                <input class="form-check-input" type="checkbox" id="terminos" name="terminos">
                                <label class="form-check-label" for="terminos">
                                    Terminos y condiciones
                                </label>
                            </div>
                        </div>

                        <br>
                        <input type="submit" value="Modificar Empresa" class="btn btn-primary" id="btnGuardar" data-toggle="modal" data-target="#alerta">
                        <%@include file="confirmacion.jsp" %>

                    </form>
                </div>
            </div>
            <div class="col-md-2"></div>

        </div>
        <!--SCRIPT-->
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/validacionEmpresa.js" type="text/javascript"></script>
        <script src="js/agregarArtista.js" type="text/javascript"></script>
    </body>

</html>
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

    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Music Sound</a>
        </nav>
    </header>

    <body>

        <div class="container main-container">

            <div class="row">
                <div class="col-md-12">

                    <h3>Registrar Album</h3>
                    <hr>

                    <div class="row">
                        <div class="col">
                            <a href="album.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                            <button type="button" class="btn btn-success" id="btn-nuevoRegistro">Agregar Nuevo Album</button>
                        </div>
                    </div>

                    <br>

                    <form>
                        <div class="form-group">
                            <label>Nombre de Artista*</label>
                            <select  name="nomArtista" id="nomArtista" class="form-control">
                                <option value="">Seleccionar un artista</option>
                                <option value="Bad Bunny">Bad Bunny</option>
                                <option value="Avicci">Avicci</option>
                            </select>
                            <div class="invalid-feedback">Debes seleccionar un artista</div>

                        </div>

                        <div class="form-group">
                            <div class="panel">Subir Foto Del Album</div>
                            <input type="file" class="nuevaFoto" name="nuevaFoto">
                            <p class="help-block">Peso maximo de la foto 2MB</p>
                            <img src="img/album/default/no-image.png" class="img-thumbnail previsualizar" width="100px"/>
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label>Nombre del Album*</label>
                                <input type="text" class="form-control" name="nomAlbum" id="nomAlbum" placeholder="Ingresar el nuevo album" onkeypress="return validarSoloLetras(event);">
                                <div class="invalid-feedback">El campo nombre de album es obligatorio</div>

                            </div>
                            <div class="col">
                                <label>Empresa Difunsora*</label>
                                <select class="form-control" name="nomEmpresa" id="nomEmpresa">
                                    <option value="">Seleccionar la empresa difunsora</option>
                                    <option value="Napster">Napster</option>
                                    <option value="Spotify">Spotify</option>
                                    <option value="!Music">!Music</option>
                                </select>
                                <div class="invalid-feedback">Debes seleccionar una empresa difunsora</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>No# Canciones*</label>
                                <input type="number" name="numCanciones" id="numCanciones" class="form-control" placeholder="Ingresar numero de canciones">
                                <div class="invalid-feedback">El campo numero de canciones es obligatorio</div>
                            </div>
                            <div class="col">
                                <label>Total Canciones</label>
                                <input type="text" name="totalCanciones" class="form-control" id="totalCanciones" value="$0.0" disabled>
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>Pais Realizacion*</label>
                                <select name="paisAlbum" id="paisAlbum" class="form-control">
                                    <option>Seleccionar el pais</option>
                                    <option value="Estados Unidos">Estados Unidos</option>
                                    <option value="Colombia">Colombia</option>
                                </select>
                                <div class="invalid-feedback">Debes seleccionar un pais</div>

                            </div>
                            <div class="col">
                                <label>Ciudad Realizacion*</label>
                                <input type="text" name="ciudadAlbum" id="ciudadAlbum" class="form-control" placeholder="Ingresar la ciudad " onkeypress="return validarSoloLetras(event);">
                                <div class="invalid-feedback">El campo de ciudad es obligatorio</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <label>Fecha de Lanzamiento*</label>
                            <input type="date" name="fechaLanzamiento" id="fechaLanzamiento" class="form-control">
                            <div class="invalid-feedback">El campo fecha finalizada es obligatorio</div>
                        </div>

                        <br>

                        <input type="submit" value="Registrar Album" class="btn btn-primary btn-block" id="btnGuardar">
                    </form>
                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="sweetarlert/sweetalert2.min.js" type="text/javascript"></script>
        <script src="js/album.js" type="text/javascript"></script>
        <script src="js/validacionLetras.js" type="text/javascript"></script>
    </body>

</html>
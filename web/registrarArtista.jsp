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
                <div class="col-md-12">

                    <h3>Registro de Artista</h3>
                    <hr>

                    <div class="row">
                        <div class="col">
                            <a href="artista.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                            <button type="button" class="btn btn-success" id="btn-nuevoRegistro">Agregar Nueva Empresa</button>
                        </div>
                    </div>

                    <br>

                    <form name="formulario_artista">
                        <div class="form-row">
                            <div class="col">
                                <label>Nombre</label>
                                <input type="text" name="nombre" id="nombre" class="form-control" placeholder="Ingresar el nombre">
                                <div class="invalid-feedback">El campo del nombre debe ser obligatorio</div>
                            </div>
                            <div class="col">
                                <label>Apellido</label>
                                <input type="text" name="apellido" id="apellido" class="form-control" placeholder="Ingresar el apellido">
                                <div class="invalid-feedback">El campo del nombre debe ser obligatorio</div>
                            </div>
                        </div>

                        <div class="form-group radio">
                            <br>
                            <h8>Genero</h8>
                            <br>
                            <input class="form-check-input " type="radio" name="sexo" id="textSex1" value="Masculino" >
                            <label class="form-check-label " for="textSex1">Masculino</label>

                            <input class="form-check-input " type="radio" name="sexo" id="textSex2" value="Femenino">
                            <label class="form-check-label" for="textSex2">Femenino</label>
                            <br>
                            <div class="invalid-feedback ">Debe seleccionar un campo</div>

                        </div>

                        <div class="form-group">
                            <label>Nombre de Artista</label>
                            <input type="text" class="form-control" id="textNomArtista" name="nomArtista" placeholder="ingresar el nombre del artista">
                            <div class="invalid-feedback">El campo nombre artista es obligatorio</div>
                        </div>

                        <div class="form-group">
                            <label>Seleccionar una Imagen del Artista</label>
                            <input type="file" class="form-control-file" name="fotoArtista" id="imageArtista">
                        </div>

                        <div class="form-group">
                            <label>Genero Musical</label>
                            <select class="form-control" id="selectGenero" name="generoMusical">
                                <option>Electronica</option>
                                <option>Rock and Roll</option>
                                <option>POP</option>
                                <option>Regaetoon</option>
                            </select>
                            <div class="invalid-feedback">Debe seleccionar un genero musical</div>
                        </div>

                        <div class="bg-light container">
                            <div class="form-group">
                                <label>Seleccionar una Imagen del Albun</label>
                                <input type="file" class="form-control-file" name="fotoArtista" id="imageArtista">
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label>Nombre del Albun</label>
                                    <input type="text" class="form-control" id="textNomAlbun" placeholder="Ingresar el nuevo albun">
                                    <div class="invalid-feedback">El campo nombre de albun es obligatorio</div>

                                </div>
                                <div class="col">
                                    <label>Empresa Difunsora</label>
                                    <select class="form-control" name="nomEmpresa" id="selectEmpresa">
                                        <option>Napster</option>
                                        <option>Spotyfy</option>
                                        <option>!Music</option>
                                    </select>
                                    <div class="invalid-feedback">Debes seleccionar una empresa difunsora</div>
                                </div>
                            </div>

                            <br>

                            <div class="form-group">
                                <label>No# Canciones</label>
                                <input type="number" name="numCanciones" id="numCanciones" class="form-control" placeholder="Ingresar numero de canciones">
                                <div class="invalid-feedback">El campo numero de canciones es obligatorio</div>
                            </div>

                            <br>

                            <div class="form-group">
                                <button type="button" class="btn btn-outline-success">Agregar Cancion</button>
                            </div>
                            <br>

                        </div>
                        <br>

                        <div class="form-group">

                            <table class="table">
                                <thead class="thead-dark">
                                <th scope="col">#</th>
                                <th scope="col">Nombre del albun</th>
                                <th scope="col">No. Cancion</th>
                                <th scope="col">Empresa Difunsora</th>
                                <th scope="col">Fecha Lanzamiento</th>
                                <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Wake Up</td>
                                        <td>
                                            <span class="badge badge-primary">10</span>
                                        </td>
                                        <td>Spotify</td>
                                        <td>26/08/2018</td>
                                        <td>
                                            <button type="button" class="btn btn-danger">Borrar</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <button type="submit" class="btn btn-outline-primary btn-block" id="btnGuardar">Registrar Usuario</button>
                    </form>
                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/validacionArtista.js" type="text/javascript"></script>
    </body>

</html>
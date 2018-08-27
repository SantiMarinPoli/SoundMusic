
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

    <body>

        <div class="container main-container">

            <div class="row">
                <div class="col-md-12">

                    <h3>Modificar el Artista de <small>XXXX</small></h3>
                    <hr>
                    <div class="row">
                        <div class="col">
                            <a href="empresa.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                        </div>
                    </div>
                    <br>


                    <form>
                        <div class="form-group">
                            <label>Nombre de Artista</label>
                            <input type="text" class="form-control" id="textNomArtista" name="nomArtista" placeholder="ingresar el nombre del artista">
                        </div>

                        <div class="form-group">
                            <label>Genero Musical</label>
                            <select class="form-control" id="selectGenero" name="generoMusical">
                                <option>Electronica</option>
                                <option>Rock and Roll</option>
                                <option>POP</option>
                                <option>Regaetoon</option>
                            </select>
                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label>Nombre del Albun</label>
                                <input type="text" class="form-control" id="textNomAlbun" placeholder="Ingresar el nuevo albun">
                            </div>
                            <div class="col">
                                <label>Empresa Difunsora</label>
                                <select class="form-control" name="nomEmpresa" id="selectEmpresa">
                                    <option>Napster</option>
                                    <option>Spotyfy</option>
                                    <option>!Music</option>
                                </select>
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>Nombre de la cancion</label>
                                <textarea class="form-control" rows="3" name="nomCancion" id="txtNomCancion" placeholder="Ingresar una cancion"></textarea>
                            </div>
                            <div class="col">
                                <label>Colaboracion del artista</label>
                                <input type="text" class="form-control" name="featArtista" id="textFeatArtista" placeholder="Ingresar el artista">
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <button type="button" class="btn btn-outline-success">Agregar Cancion</button>

                        </div>

                        <div class="form-group">

                            <table class="table">
                                <thead class="thead-dark">
                                <th scope="col">#</th>
                                <th scope="col">Nombre del albun</th>
                                <th scope="col">Nombre de Cancion</th>
                                <th scope="col">Fecha</th>
                                <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Wake Up</td>
                                        <td>
                                            <a href="#" class="badge badge-primary">Levels</a>
                                            <a href="#" class="badge badge-primary">Friends of mine Feat Vargar & Lagola</a>
                                        </td>
                                        <td>26/08/2018</td>
                                        <td>
                                            <button type="button" class="btn btn-danger">Borrar</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="form-group">
                            <label>Seleccionar una imagen</label>
                            <input type="file" class="form-control-file" name="fotoArtista" id="imageArtista">
                        </div>

                        <button type="submit" class="btn btn-outline-primary btn-block" id="btnGuardar">Registrar Usuario</button>

                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
    </body>

</html>
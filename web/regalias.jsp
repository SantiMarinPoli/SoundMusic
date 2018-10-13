
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SoundMusic</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="img/png" href="icon/musica.png"/>
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
        <link href="style/regalias.style.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="sweetarlert/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <%@include file="navbar.jsp" %>

        <div class="container main-container">

            <h2>Lista de Pagos</h2>
            <hr>
            <br>
            <div class="row">
                <div class="col-md-12">

                    <div class="row">
                        <div class="col">
                            <button href="caluloRegalias.jsp" class="btn btn-success" data-toggle="modal" data-target="#modalRegalias">Calcular Regalias</button>
                        </div>
                    </div>

                    <br>

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre Artista</th>
                                <th>Bonificacion</th>
                                <th>Empresa Difunsora</th>
                                <th>Fecha de Pago</th>
                                <th>No# Operaciones</th>
                                <th>Sueldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Martin Garrix</td>
                                <td> </td>
                                <td>Spinin Records</td>
                                <td>11/09/2018 00:00PM</td>
                                <td class="text-success">$500.000 COP</td>
                                <td><a href="#" class="badge badge-danger btnActivar" activarRegalias="">Pendiente</a></td>
                            </tr>

                            <tr>
                                <td>Martin Garrix</td>
                                <td></td>
                                <td>Spinin Records</td>
                                <td>11/09/2018 00:00PM</td>
                                <td class="text-success">$500.000 COP</td>
                                <td><a href="#" class="badge badge-danger btnActivar" activarRegalias="">Pendiente</a></td>
                            </tr>
                        </tbody>
                    </table>

                    <!-- Modal -->
                    <div class="modal fade" id="modalRegalias" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Cacular la Regalia</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <input type="hidden" name="idRegalias" value="0">

                                        <div class="form-group">
                                            <label>Nombre del Artista*</label>
                                            <select name="nomArtista" id="nomArtista" class="form-control">
                                                <option value="">Seleccionar el nombre del artista</option>
                                                <option value="Bad Bunny">Bad Bunny</option>
                                                <option value="Avicci">Avicci</option>
                                                <option value="Martin Garrix">Martin Garrix</option>
                                            </select>
                                            <div class="invalid-feedback">Debes seleccionar un nombre de artista</div>
                                        </div>

                                        <div class="form-group">
                                            <label>Nombre de la Empresa*</label>
                                            <select name="nomEmpresa"  id="nomEmpresa" class="form-control">
                                                <option value="">Seleccionar la empresa</option>
                                                <option value="Spotify">Spotify</option>
                                                <option value="Napster">Napster</option>
                                                <option value="!Music">!Music</option>
                                            </select>
                                            <div class="invalid-feedback">Debes seleccionar una empresa difusora</div>
                                        </div>

                                        <div class="form-group">
                                            <label>No# Operaciones*</label>
                                            <input type="number" name="numOp" id="numOp" class="form-control" placeholder=" numero de operaciones">
                                            <div class="invalid-feedback">El campo numero de operaciones es obligatorio</div>
                                        </div>

                                        <div class="form-group">
                                            <label>Total Operaciones</label>
                                            <input type="text" name="totalOp" class="form-control" id="totalOp" value="$0.0" disabled>
                                        </div>

                                        <div class="form-group">
                                            <img src="icon/discoOro.png"  class="img-thumbnail previsualizar" width="100px" />
                                        </div>

                                        <input type="submit" id="btnGuardar" class="btn btn-primary btn-block" value="Guardar "/>

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="sweetarlert/sweetalert2.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/jquery.bootstrap-growl.min.js" type="text/javascript"></script>
        <script src="js/regalias.js" type="text/javascript"></script>
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>

</html>
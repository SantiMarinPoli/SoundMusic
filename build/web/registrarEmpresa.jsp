<%@page import="java.util.List"%>
<%@page import="co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusora"%>
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
                <div class="col-md-2"></div>

                <div class="col-md-8">

                    <h3>Registro de Empresa Difusora</h3>
                    <hr>

                    <div class="row">
                        <div class="col">
                            <a href="empresa.jsp" class="btn btn-danger" id="btn-regresar">Regresar</a>
                            <button type="button" class="btn btn-success" id="btn-nuevoRegistro">Agregar Nueva Empresa</button>
                        </div>
                    </div>

                    <br>

                    <form name="formulario_empresa" action="controladorEmpresaDifusora" method="post">
                        <input type="hidden" name="cod" value="0">
                        <input type ="hidden" name="operacion" value="crear" />

                        <div class="form-group">
                            <label>Nombre de la Compañia*</label>
                            <input type="text" class="form-control" name="nomEmpresa" id="nomEmpresaTxt" placeholder="Ingresar la empresa difunsora" onkeypress="return validarSoloLetras(event);">
                            <div class="invalid-feedback">El campo nombre empresa debe ser obligatorio</div>
                        </div>

                        <div class="form-group radio">
                            <h8> Tipo de Empresa*</h8>
                                <%//Listar los tipos de empresas de la base de datos
                                    /*List<TipoEmpresaDifusora> listaTipoEmpresa
                                            = (List<TipoEmpresaDifusora>) request.getAttribute("lstTipoEmpresa");
                                    for (TipoEmpresaDifusora tipoEmpresa : listaTipoEmpresa) {
                                        out.println("<div class='form-check'>");
                                        out.println("<input type='radio' class='form-check-input' name='tipoEmpresa' id='tipoEmpresa1Txt' value=''"
                                                + tipoEmpresa.getIdTipoActividad() + "''>");
                                        out.println("<label for='tipoEmpresa1Txt' class='form-check-label error'>"
                                                + tipoEmpresa.getTipoActividad() + "</label>");
                                        out.println("</div>");
                                    }*/
                                %>
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
                            </div>

                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="tipoEmpresa" id="tipoEmpresa3Txt" value="Video">
                                <label for="tipoEmpresa3Txt" class="form-check-label">Disco Fisico</label>
                                <div class="invalid-feedback">Seleccionar una seleccion en el campo tipo empresa.</div>
                            </div>

                        </div>

                        <div class="form-group">
                            <label>Agregar Artista</label>
                            <input type="text" name="agregarArtista"  class="form-control" id="textAgregarArtista" placeholder="Agregar artista" onkeypress="return validarSoloLetras(event);"> 
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

                        <div class="form-group">
                            <label>Correo de la empresa*</label>
                            <input type="email" class="form-control" name="correo" id="correo" placeholder="Ingresar el correo electronico principal">
                            <div class="invalid-feedback">El campo correo sera obligatorio.</div>
                        </div>

                        <div class="form-group">
                            <label>Numero Telefonico</label>
                            <input type="number" class="form-control" name="numFijo"  id="numFijo" placeholder="Ingresar el numero telefonico principal">
                        </div>

                        <div class="form-group">
                            <label>Valor de la Operacion*</label>
                            <input type="number" class="form-control" name="valorOp"  id="valorOp" placeholder="Ingresar el valor de la operacion">
                            <div class="invalid-feedback">El campo valor operacion sera obligatorio.</div>
                        </div>

                        <div class="form-group">
                            <div class="form-check checkbox">
                                <input class="form-check-input" type="checkbox" id="terminos" name="terminos">
                                <label class="form-check-label" for="terminos">
                                    Terminos y condiciones
                                </label>
                            </div>
                        </div>

                        <br>
                        <input type="submit" value="Registrar Empresa" class="btn btn-primary btn-block" id="btnGuardar" >

                    </form>
                </div>
            </div>
            <div class="col-md-2"></div>

        </div>
        <!--SCRIPT-->
        <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="sweetarlert/sweetalert2.min.js" type="text/javascript"></script>
        <script src="js/validacionEmpresa.js" type="text/javascript"></script>
        <script src="js/agregarArtista.js" type="text/javascript"></script>
        <script src="js/validacionLetras.js" type="text/javascript"></script>
    </body>

</html>
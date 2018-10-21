
<%@page import="co.com.soundMusic.Contacto.Ciudad.Ciudad"%>
<%@page import="co.com.soundMusic.Contacto.Pais.Pais"%>
<%@page import="java.util.List"%>
<%@page import="co.com.soundMusic.Login.Usuario.Usuario"%>
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

                    <h3>Modificar Usuario</h3>
                    <%
                        Usuario usuario = (Usuario) request.getAttribute("usuarioEditar");
                    %>
                    <hr>
                    <br>

                    <div class="row">
                        <div class="col">
                            <a href="controladorUsuario?opcion=listarUsuarios" class="btn btn-danger" id="btn-regresar">Regresar</a>
                        </div>
                    </div>

                    <br>

                    <form name="formulario_usuario" action="controladorUsuario" method="post">
                        <input type="hidden" name="cod" value="0">
                        <input type="hidden" name="operacion" id="operacion" value="editar" >  
                        <% out.println("<input type='hidden' name='IdUsuario' id='IdUsuario' readonly value='" + usuario.getIdUsuario() + "'/>");%>  
                        <div class="form-row">
                            <div class="col">
                                <label>Primer Nombre*</label>                                
                                <% out.println("<input type='text' class='form-control' name='nombre1' id='nom1 texto' value='" + usuario.getPrimerNombre() + "'/>");%> 
                                <div class="invalid-feedback ">El primer nombre es un campo obligatorio</div>

                            </div>
                            <div class="col">
                                <label>Segundo Nombre</label>
                                <% out.println("<input type='text' class='form-control' name='nombre2' id='nombre2 texto' value='" + usuario.getSegundoNombre() + "'/>");%> 
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label>Primer Apellido*</label>
                                <% out.println("<input type='text' class='form-control' name='apellido1' id='apellido1 texto' value='" + usuario.getPrimerApellido() + "'/>");%> 
                                <div class="invalid-feedback ">El primer apellido es un campo obligatorio</div>

                            </div>
                            <div class="col">
                                <label>Segundo Apellido*</label>
                                <% out.println("<input type='text' class='form-control' name='apellido2' id='apellido2 texto' value='" + usuario.getSegundoApellido() + "'/>");%> 
                                <div class="invalid-feedback ">El segundo apellido es un campo obligatorio</div>
                            </div>
                        </div>

                        <div class="form-group radio">
                            <br>
                            <h8>Genero*</h8>
                            <br>                            
                            <%if (usuario.getGenero().equalsIgnoreCase("M")) {
                                    out.println("<input class='form-check-input ' type='radio' name='sexo' id='textSex1' value='M' checked>");%>
                            <label class="form-check-label " for="textSex1">Masculino</label>
                            <%out.println("<input class='form-check-input ' type='radio' name='sexo' id='textSex2' value='F'>");%>
                            <label class="form-check-label" for="textSex2">Femenino</label>
                            <%} else {
                                out.println("<input class='form-check-input ' type='radio' name='sexo' id='textSex1' value='M'>");%>
                            <label class="form-check-label " for="textSex1">Masculino</label>
                            <%out.println("<input class='form-check-input ' type='radio' name='sexo' id='textSex2' value='F' checked>");%>
                            <label class="form-check-label" for="textSex2">Femenino</label>
                            <%}%>
                            <br>
                            <div class="invalid-feedback ">Debe seleccionar un campo</div>

                        </div>

                        <div class="form-group">
                            <label>Correo*</label>                            
                            <% out.println("<input type='email' name='email' id='email' class='form-control' value='" + usuario.getContacto().getEmail() + "'>");%> 
                            <div class="invalid-feedback ">El correo electronico es un campo obligatorio</div>

                        </div>

                        <div class="form-group">
                            <label>Nombre del Usuario*</label>
                            <% out.println("<input type='text' class='form-control' name='nomUsuario' id='textNameUser' value='" + usuario.getUsuarioLogin().getNombreUsuario() + "'>");%>
                            <div class="invalid-feedback ">El nombre de usuario es un campo obligatorio</div>

                        </div>

                        <div class="form-row">
                            <div class="col">
                                <label>Contraseña*</label>
                                <% out.println("<input type='password' class='form-control' name='pass1' id='textPass' value='" + usuario.getUsuarioLogin().getContrasena() + "' >");%>
                                <div class="invalid-feedback ">La contraseña debe ser obligatorio</div>
                            </div>
                            <div class="col">
                                <label>Repita Contraseña*</label>
                                <% out.println("<input type='password' class='form-control' name='pass2' id='textRepeatPass' value='" + usuario.getUsuarioLogin().getContrasena() + "' >");%>
                                <div class="invalid-feedback ">La contraseña debe ser igual dato</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label >Numero del Celular*</label>
                                <% out.println("<input type='number' class='form-control' name='numCel' id='numCel'value='" + usuario.getContacto().getCelular() + "' >");%>
                                <div class="invalid-feedback ">El numero celular debe ser obligatorio</div>
                            </div>
                            <div class="col">
                                <label >Numero del Telefono</label>
                                <% out.println("<input type='number' class='form-control' name='numTel' id='numTel'value='" + usuario.getContacto().getTelefono() + "' >");%>
                                <div class="invalid-feedback ">El numero telefonico debe ser obligatorio</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-row">
                            <div class="col">
                                <label >Pais*</label>
                                <select class="form-control" name="pais" id="pais">
                                    <%//Listar los paises en la base de datos      
                                        out.print("<option value='" + usuario.getContacto().getCiudad().getPais().getIdPais()
                                                + "'>" + usuario.getContacto().getCiudad().getPais().getNombre() + "</option>");

                                        List<Pais> listaPais
                                                = (List<Pais>) request.getAttribute("lstPais");
                                        for (Pais pais : listaPais) {
                                            if (usuario.getContacto().getCiudad().getPais().getNombre().equalsIgnoreCase(pais.getNombre())) {
                                                continue;
                                            } else {
                                                out.print("<option value='" + pais.getIdPais()
                                                        + "'>" + pais.getNombre() + "</option>");
                                            }
                                        }
                                    %>
                                </select>
                                <div class="invalid-feedback ">El campo pais debe ser obligatorio</div>
                            </div>
                            <div class="col">
                                <label >Ciudad</label>
                                <!-- <input type="text" class="form-control" name="ciudad" id="ciudad" placeholder="Ingrese la ciudad" > -->
                                <select class="form-control" name="ciudad" id="ciudad">
                                    <%//Listar las ciudades en la base de datos
                                        out.print("<option value='" + usuario.getContacto().getCiudad().getIdCiudad()
                                                + "'>" + usuario.getContacto().getCiudad().getNombre() + "</option>");

                                        List<Ciudad> listaCiudad
                                                = (List<Ciudad>) request.getAttribute("lstCiudad");
                                        for (Ciudad ciudad : listaCiudad) {
                                            if (usuario.getContacto().getCiudad().getNombre().equalsIgnoreCase(ciudad.getNombre())) {
                                                continue;
                                            } else {
                                                out.print("<option value='" + ciudad.getIdCiudad()
                                                        + "'>" + ciudad.getNombre() + "</option>");
                                            }
                                        }
                                    %>
                                </select>
                                <div class="invalid-feedback ">El campo ciudad debe ser obligatorio</div>
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <label>Direccion Actual</label>
                            <% out.println("<input type='text' name='direccion' id='direccion' class='form-control' value='" + usuario.getContacto().getDireccion() + "'>");%>
                        </div>

                        <div class="form-group">
                            <label>Barrio</label>
                            <% out.println("<input type='text' name='barrio' id='barrio' class='form-control' value='" + usuario.getContacto().getBarrio() + "'>");%>
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
<%@page import="co.com.soundMusic.Artista.Album.Album"%>
<%@page import="co.com.soundMusic.Artista.Artista"%>
<%@page import="co.com.soundMusic.Contacto.Ciudad.Ciudad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>SoundMusic</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="img/png" href="icon/musica.png" />
    <link href="style/style.css" rel="stylesheet" type="text/css" />
    <link href="bootstrap/CSS/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="bootstrap/JS/popper.min.js" type="text/javascript"></script>

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
                <h3>Modificar Album</h3>
                <%
                Album album= (Album) request.getAttribute("albumEditar");
                %>
                <hr>
                <div class="row">
                    <div class="col">
                        <a href="controladorAlbum?opcion=listarAlbumes" class="btn btn-danger" id="btn-regresar">Regresar</a>
                    </div>
                </div>

                <br>


                <form name="formulario_album" action="controladorAlbum" method="post">
                    <input type="hidden" name="operacion" value="editar" />
                    <% out.println("<input type='hidden' name='IdAlbum' id='IdAlbum' readonly value='" + album.getIdAlbum() + "'/>");
                        out.println("<input type='hidden' name='idArtista' id='idArtista' readonly value='" + album.getArtista().getIdArtista() + "'/>");
                        out.println("<input type='hidden' name='idCiudad' id='idCiudad' readonly value='" + album.getCiudad().getIdCiudad() + "'/>");
                    %>  
                    <div class="form-row">
                        <div class="col">
                            <label>Nombre del Album*</label>
                            <% out.println("<input type='text' class='form-control' name='nomAlbum' id='nomAlbum' value='"+album.getNombre()+"'>");%> 
                            <div class="invalid-feedback">El campo nombre de album es obligatorio</div>
                        </div>
                        <div class="col">
                            <label>No# Canciones*</label>
                            <% out.println("<input type='number' name='numCanciones' id='numCanciones' class='form-control' value='"+album.getNumeroCanciones()+"'>");%> 
                            <div class="invalid-feedback">El campo numero de canciones es obligatorio</div>
                        </div>
                    </div>

                    <br>

                    <div class="form-row">
                        <div class="col">
                            <label>Ciudad Realizacion*</label>
                            <select class="form-control" name="ciudadAlbum" id="ciudadAlbum">
                                <%//Listar las ciudades en la base de datos
                                out.print("<option value='" + album.getCiudad().getIdCiudad()
                                                    + "'>" + album.getCiudad().getNombre() + "</option>");

                                        List<Ciudad> listaCiudad
                                                = (List<Ciudad>) request.getAttribute("lstCiudad");
                                        for (Ciudad ciudad : listaCiudad) {
                                            if(album.getCiudad().getIdCiudad()==ciudad.getIdCiudad()){
                                                continue;
                                            }else{
                                            out.print("<option value='" + ciudad.getIdCiudad()
                                                    + "'>" + ciudad.getNombre() + "</option>");}
                                        }
                                    %>
                            </select>
                            <div class="invalid-feedback">El campo de ciudad es obligatorio</div>
                        </div>
                        <div class="col">
                            <label>Fecha de Lanzamiento*</label>
                            <% out.println("<input type='date' name='fechaLanzamiento' id='fechaLanzamiento' class='form-control' value='"+album.getFechaFinalizacion()+"'>");%> 
                            <div class="invalid-feedback">El campo fecha finalizada es obligatorio</div>
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label>Nombre de Artista*</label>
                        <select class="form-control" name="nomArtista" id="nomArtista">
                            <%//Listar los artistas en la base de datos
                            out.print("<option value='" + album.getArtista().getIdArtista()+"-"+album.getArtista().getNombreArtistico()
                                                + "'>" + album.getArtista().getNombreArtistico() + "</option>");
                                    List<Artista> listaArtistas
                                            = (List<Artista>) request.getAttribute("lstArtistas");
                                    for (Artista artista : listaArtistas) {
                                        if(album.getArtista().getIdArtista()==artista.getIdArtista()){
                                            continue;
                                        }else{
                                        out.print("<option value='" + artista.getIdArtista()+"-"+artista.getNombreArtistico()
                                                + "'>" + artista.getNombreArtistico() + "</option>");}
                                    }
                                %>
                        </select>
                        <div class="invalid-feedback">Debes seleccionar un artista</div>
                    </div>

                    <div class="form-group">
                        <div class="panel">Subir Foto Del Album</div>
                        <% out.println("<input type='file' class='nuevaFoto' name='nuevaFoto' value='"+album.getRutaImagen()+"'>");%> s
                        <p class="help-block">Peso maximo de la foto 2MB</p>
                        <img src="img/album/default/no-image.png" class="img-thumbnail previsualizar" width="100" alt="" />
                    </div>
                    <br>
                    <input type="submit" value="Registrar Album" class="btn btn-primary btn-block" id="btnGuardar">
                </form>
            </div>
        </div>
    </div>

    <!--SCRIPT-->
    <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
    <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
</body>

</html>
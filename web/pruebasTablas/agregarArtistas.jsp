<%-- 
    Document   : agregarArtistas
    Created on : 4/11/2018, 11:26:32 PM
    Author     : Santiago Medina Pelaez
--%>

<%@page import="co.com.soundMusic.Artista.Artista"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="row animated fadeIn fast">
                <div class="col-md-12">

                    <h3>Agregar Artistas</h3>
                    <hr>
                    <br>                    
                    <form name="formulario_usuario" action="controladorArtistaEmpresa" method="post">
                        <input type ="hidden" name="operacion" value="agregar" />
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre de Artista</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Artista> lstArtista = (List<Artista>) request.getAttribute("lstArtista");
                                    for (Artista art : lstArtista) {
                                        out.print("<tr>");
                                        out.print(" <td><input type='checkbox' name='selected' value='" + art.getIdArtista() + "'></td>");
                                        out.print("<td  scope='row'>" + art.getIdArtista() + "</td>");
                                        out.print("<td>" + art.getNombreArtistico() + "</td>");
                                        out.print("</tr>");
                                    }
                                %>
                            </tbody>
                        </table>
                        <input type="submit" value="Agregar Artistas" class="btn btn-primary btn-block" id="btnGuardar">
                    </form>
                </div>
            </div>
            <br>
        </div>
        <!--SCRIPT-->        
        <script src="../bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="../bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/artista.js" type="text/javascript"></script>
        <script src="../js/navbar.js" type="text/javascript"></script>
    </body>

</html>
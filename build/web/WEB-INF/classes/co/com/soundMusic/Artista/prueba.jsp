<div>
    <%@include file="navbar.jsp" %>

    <div class="container main-container">
        <div class="row animated fadeIn fast">
            <div class="col-md-12">

                <h3>Modulo de Artista </h3>
                <hr>
                <br>
                <div class="row">
                    <div class="col">
                        <a href="registrarArtista.jsp" class="btn btn-success">Registrar Artista</a>
                    </div>
                </div>

                <br>
                <%@page import="java.util.List"%>
                <%@page import="co.com.soundMusic.Artista"%>
                <%@page contentType="text/html" pageEncoding="UTF-8"%>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre de Artista</th>
                            <th scope="col">Foto</th>
                            <th scope="col">Bonificacion</th>
                            <th scope="col">Genero</th>
                            <th scope="col">No# Albunes</th>
                            <th scope="col">Contrato</th>
                            <th scope="col">Mes y Año</th>
                            <th scope="col">Total Mensual</th>
                            <th scope="col">Permisos</th>
                            <th scope="col">Operaciones</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%
                            List<Artista> listarArtistas = (List<Artista>) request.getAttribute("listarArtistas");
                            for (Artista artista : listarArtistas) {
                                out.print("<tr>");                               
                                out.print("<td>" + artista.getIdArtista()+ "</td>");
                                out.print("<td>" + artista.getNombreArtistico()+ "</td>");
                                out.print("<td>" + "foto"+ "</td>");
                                out.print("<td>" + "bonifi"+ "</td>");
                                out.print("<td>" + artista.getGenero()+ "</td>");
                                out.print("<td>" + "numero albunes"+ "</td>");
                                out.print("<td>" + "empresas"+ "</td>");
                                out.print("<td>" + artista.getFechaCreacion()+ "</td>");
                                out.print("<td class="text-success">$5.000.000 COP</td>");
                                out.print(" <td><span class="badge badge-success">"+artista.getStatus+"</span></td>");                               
                                out.print("<td><a href='controladorArtista?opcion=borrar&idArtista="
                                    + artista.getIdArtista()+ "'>Desactivar<a/></td>");
                            out.print("<td><a href='controladorArtista?opcion=editar&idArtista="
                                    + artista.getIdArtista() + "'>Editar<a/></td>");
                                out.print("</tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
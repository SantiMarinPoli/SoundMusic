<%-- 
    Document   : listaUsuarios
    Created on : 6/10/2018, 11:22:09 AM
    Author     : Santiago Medina Peláez
--%>

<%@page import="co.com.soundMusic.Login.Usuario.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div style="overflow-x:auto;">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre Completo</th>
                <th scope="col">Sexo</th>
                <th scope="col">Correo</th>
                <th scope="col">Tipo de Usuario</th>
                <th scope="col">Nombre Usuario</th>
                <th scope="col">Fecha Entrada</th>
                <th scope="col">Activo</th>
                <th scope="col">Operaciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Usuario> lstUsuario = (List<Usuario>) request.getAttribute("lstUsuario");
                for (Usuario usu : lstUsuario) {
                    out.print("<tr>");
                    out.print("<th  scope='row'>" + usu.getIdUsuario() + "</th>");
                    out.print("<td>" + usu.getPrimerApellido() + " " + usu.getPrimerApellido() + "</td>");
                    
                    out.print("</tr>");
                }
            %>
        </tbody>
    </table>
</div>

<%-- 
    Document   : listaEmpresas
    Created on : 10/10/2018, 10:54:52 AM
    Author     : Santiago Medina Peláez
--%>

<%@page import="co.com.soundMusic.EmpresaDifusora.EmpresaDifusora"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table">
    <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre de Empresa</th>
            <th scope="col">Total Artista</th>
            <th scope="col">Total Albunes</th>
            <th scope="col">Mes y Año</th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <%
            List<EmpresaDifusora> lstEmpresas = (List<EmpresaDifusora>) request.getAttribute("lstEmpresas");
            for (EmpresaDifusora emDif : lstEmpresas) {
                out.print("<tr>");
                out.print("<th  scope='row'>" + emDif.getIdEmpresaDifusora() + "</th>");
                out.print("<td>" + emDif.getNombre() + "</td>");
                out.print("<td>" + emDif.getNumeroArtistas() + "</td>");
                out.print("<td>" + emDif.getNumeroArtistas() + "</td>");
                out.print("<td>" + emDif.getFechaCreacion() + "</td>");
                out.print("<td><a href='modificarEmpresa.jsp' class='btn btn-warning'>Actualizar</a></td>");
                out.print("</tr>");
            }
        %>
    </tbody>
</table>
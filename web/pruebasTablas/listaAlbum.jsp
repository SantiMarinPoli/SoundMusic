<%-- 
    Document   : listaAlbum
    Created on : 23/10/2018, 01:44:41 PM
    Author     : Santiago Medina Peláez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table">
    <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre Artista</th>
            <th scope="col">Foto Album</th>
            <th scope="col">Nombre del albun</th>
            <th scope="col">No. Cancion</th>
            <th scope="col">Total</th>
            <th scope="col">Empresa Difunsora</th>
            <th scope="col">Fecha Lanzamiento</th>
            <th scope="col">Operación</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th scope="row">1</th>
            <th>Avicci</th>
            <td>Wake Up</td>
            <td><img src="img/album/default/no-image.png"  class="img img-fluid icon-artista"/></td>
            <td>
                <span class="badge badge-primary">10</span>
            </td>
            <td class="text-success">$500.000 USD</td>
            <td>Spotify</td>
            <td>26/08/2018</td>
            <td>
                <button type="button" class="btn btn-warning">Actualizar</button>
            </td>
        </tr>
    </tbody>
</table>



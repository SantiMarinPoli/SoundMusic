
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
        
         <%@include file="navbar.jsp" %>
        
        <div class="container main-container">
                <div class="row animated fadeIn fast">
                    <div class="col-md-12">
                        
                        <h3>Modulo de Empresa Difunsora </h3>
                        <hr>
                        <br>
                        <div class="row">
                            <div class="col">
                                <a href="registrarArtista.jsp" class="btn btn-success">Registrar Empresa</a>
                            </div>
                        </div>
                        
                        <br>
                        
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
                                <tr>
                                          <td scope="row">1</td>
                                          <td>Avicci</td>
                                          <td><img src="img/art1.jpg"  class="img img-fluid icon-artista"/></td>
                                          <td><img src="icon/discoPlat.png"  class="img img-thumbnail"/></td>
                                           <td>Electronica</td>
                                           <td>10</td>
                                           <td class="text-success">
                                               <span class="badge badge-primary">Youtube</span>
                                               <span class="badge badge-primary">Spotyfy</span>
                                           </td>
                                           <td>Abril 2018</td>
                                           <td class="text-success">$5.000.000 COP</td>
                                           <td><span class="badge badge-success">Activo</span></td>
                                           <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                                </tr>
                                
                                <tr>
                                          <td scope="row">2</td>
                                          <td>Bad Bunny</td>
                                          <td><img src="img/art2.png"  class="img img-fluid icon-artista"/></td>
                                          <td>Ninguno</td>
                                           <td>Trap, Reegaeton</td>
                                           <td>5</td>
                                           <td class="text-success">
                                               <span class="badge badge-primary">Youtube</span>
                                               <span class="badge badge-primary">Google Music</span>
                                           </td>
                                           
                                           <td>Agosto 2018</td>
                                           <td class="text-success">$800.000 COP</td>
                                           <td><span class="badge badge-danger">Inactivo</span></td>
                                           <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                                </tr>
                                
                                 <tr>
                                          <td scope="row">3</td>
                                          <td>Guns And Roses</td>
                                          <td><img src="img/art3.png"  class="img img-fluid icon-artista"/></td>
                                          <td><img src="icon/discoOro.png"  class="img img-thumbnail"/></td>
                                           <td>Rock and Roll</td>
                                           <td>50</td>
                                           <td class="text-success">
                                               <span class="badge badge-primary">Youtube</span>
                                               <span class="badge badge-primary">Spotyfy</span>
                                               <span class="badge badge-primary">Itunes Music</span>
                                           </td>
                                           <td>Abril 2018</td>
                                           <td class="text-success">$20.000.000 COP</td>
                                           <td><span class="badge badge-success">Activo</span></td>
                                           <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                                </tr>

                                

                            </tbody>
                        </table>

                    </div>
                </div>
         </div>
         
        <!--SCRIPT-->
         <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>
    
</html>
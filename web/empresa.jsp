
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
                                <a href="registrarEmpresa.jsp" class="btn btn-success btn-lg" id="btnGuardar">Registrar Empresa</a>
                            </div>
                        </div>
                        
                        <br>
                        
                        <table class="table">
                            <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Nombre de Empresa</th>
                                        <th scope="col">Total Artista</th>
                                        <th scope="col">Total Albunes</th>
                                         <th scope="col">Mes y Año</th>
                                        <th scope="col">Total Mensual</th>
                                        <th scope="col">Operaciones</th>
                                      </tr>
                            </thead>
                            
                            <tbody>
                                <tr>
                                          <th scope="row">1</th>
                                          <td>Spotyfy</td>
                                          <td>3</td>
                                          <td>20</td>
                                           <td>Abril 2018</td>
                                           <td class="text-success">$5.000.000 COP</td>
                                           <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                                </tr>
                                
                                <tr>
                                          <th scope="row">2</th>
                                          <td>Napster</td>
                                          <td>5</td>
                                          <td>10</td>
                                           <td>Julio 2018</td>
                                           <td class="text-success">$3.000.000 COP</td>
                                           <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                                </tr>
                                <tr>
                                          <th scope="row">3</th>
                                          <td>Google Music</td>
                                          <td>5</td>
                                          <td>40</td>
                                           <td>Junio 2018</td>
                                           <td class="text-success">$20.000.000 COP</td>
                                           <td><button type="button" class="btn btn-warning">Actualizar</button></td>
                                </tr>
                                <tr>
                                          <th scope="row">4</th>
                                          <td>Youtube</td>
                                          <td>20</td>
                                          <td>50</td>
                                           <td>Agosto 2018</td>
                                           <td class="text-success">$40.000.000 COP</td>
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

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

    <body >

        <%@include file="navbar.jsp" %>

        <div class="container main-container">
            <div class="row">
                <div class="col-md-12">

                    <h3>Artistas Mas Destacados Del 2018</h3>
                    <hr>
                    <br>

                    <div class="card-columns animated fadeIn fast">
                        <div class="card">
                            <img class="card-img-top" src="img/art1.jpg" >
                            <div class="card-body">
                                <h5 class="card-title">Avicii <span> <img src="icon/discoOro.png"  class="img img-thumbnail disco"/></span></h5>
                                <span class="badge badge-primary">Wake Up</span>
                                <span class="badge badge-primary">Stories</span>

                            </div>
                        </div>

                        <div class="card">
                            <img class="card-img-top" src="img/art1.jpg" >
                            <div class="card-body">
                                <h5 class="card-title">Avicii <span><img src="icon/discoPlat.png"  class="img img-thumbnail disco"/></span></h5>
                                <span class="badge badge-primary">Wake Up</span>
                                <span class="badge badge-primary">Stories</span>

                            </div>
                        </div>

                        <div class="card">
                            <img class="card-img-top" src="img/art1.jpg" >
                            <div class="card-body">
                                <h5 class="card-title">Avicii</h5>
                                <span class="badge badge-primary">Wake Up</span>
                                <span class="badge badge-primary">Stories</span>
                            </div>
                        </div>
                        <div class="card">
                            <img class="card-img-top" src="img/art1.jpg" >
                            <div class="card-body">
                                <h5 class="card-title">Avicii</h5>
                                <span class="badge badge-primary">Wake Up</span>
                                <span class="badge badge-primary">Stories</span>
                            </div>
                        </div>
                        <div class="card">
                            <img class="card-img-top" src="img/art1.jpg" >
                            <div class="card-body">
                                <h5 class="card-title">Avicii</h5>
                                <span class="badge badge-primary">Wake Up</span>
                                <span class="badge badge-primary">Stories</span>
                            </div>
                        </div>
                        <div class="card">
                            <img class="card-img-top" src="img/art1.jpg" >
                            <div class="card-body">
                                <h5 class="card-title">Avicii</h5>
                                <span class="badge badge-primary">Wake Up</span>
                                <span class="badge badge-primary">Stories</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">

                    <h3>Albunes Recientes</h3>
                    <hr>
                    <br> 

                    <div class="row">
                        <div class="col-4">
                            <img src="img/artistas/axwell&ingrosso/art4.jpg" class="img img-thumbnail "/>
                        </div>
                        <div class="col">
                            <h4>Axwell & Ingrosso</h4>
                            <hr>
                            <br>
                            <table class="table">
                                <thead>

                                <h5>                                
                                    <img src="img/artistas/axwell&ingrosso/albun1.jpg" class="img img-thumbnail icon-artista"/>
                                    More Than You Know
                                </h5> 

                                <tr class="thead-dark">
                                    <th></th>
                                    <th scope="col">Nombre de la cancion</th>
                                    <th scope="col">Fecha de Produccion</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <th> 
                                            <img src="img/artistas/axwell&ingrosso/albun1.jpg" class="img img-thumbnail icon-artista"/>
                                        </th>
                                        <td>More Than You Know</td>
                                        <td>8 de diciembre del 2017</td>
                                    </tr>

                                    <tr>
                                        <th> 
                                            <img src="img/artistas/axwell&ingrosso/albun1.jpg" class="img img-thumbnail icon-artista"/>
                                        </th>
                                        <td>Renegade</td>
                                        <td>8 de diciembre del 2017</td>
                                    </tr>
                                </tbody>
                            </table>
                            <br>
                            <table class="table">
                                <thead>

                                <h5>                                
                                    <img src="img/artistas/axwell&ingrosso/albun1.jpg" class="img img-thumbnail icon-artista"/>
                                    More Than You Know
                                </h5> 

                                <tr class="thead-dark">
                                    <th></th>
                                    <th scope="col">Nombre de la cancion</th>
                                    <th scope="col">Fecha de Produccion</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <th> 
                                            <img src="img/artistas/axwell&ingrosso/albun1.jpg" class="img img-thumbnail icon-artista"/>
                                        </th>
                                        <td>More Than You Know</td>
                                        <td>8 de diciembre del 2017</td>
                                    </tr>

                                    <tr>
                                        <th> 
                                            <img src="img/artistas/axwell&ingrosso/albun1.jpg" class="img img-thumbnail icon-artista"/>
                                        </th>
                                        <td>Renegade</td>
                                        <td>8 de diciembre del 2017</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>


                    </div>


                </div>

            </div>
        </div>

        <!--SCRIPT-->
        <script src="bootstrap/JS/jquery.min.js" type="text/javascript"></script>
        <script src="bootstrap/JS/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/navbar.js" type="text/javascript"></script>
    </body>

</html>


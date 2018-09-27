<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Music Sound</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse nav" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link " href="home.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="controladorUsuario?opcion=listarUsuarios">Usuarios</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="controladorEmpresaDifusora?opcion=listarEmpresa">Empresas Difunsoras</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="controladorArtista?opcion=listarArtista">Artistas</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="regalias.jsp">Regalias</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="auditoria.jsp">Log de Auditoria</a>
            </li>            
        </ul>
        <div class="row">
            <div class="col display-flex">
                <a href ="login.jsp" class="btn btn-danger" type="button" click="cerrarSesion()">Salir</a>
            </div>
        </div>
    </div>
</nav>
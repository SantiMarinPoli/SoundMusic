$(function () {

//BOTON DE ACTIVAR O DESACTIVAR EL USUARIO
    $(".btnActivar").click(function () {

        var idUsuario = $(this).attr("idUsuario");
        var activarUsuario = $(this).attr("activarUsuario");

        var datos = new FormData();
        datos.append("activarId", idUsuario);
        datos.append("activarUsuario", activarUsuario);

        if (activarUsuario == 0) {
            $(this).removeClass("badge-success");
            $(this).addClass("badge-danger");
            $(this).html("Inactivo");
            $(this).attr("activarUsuario", 1);
        } else {
            $(this).removeClass("badge-danger");
            $(this).addClass("badge-success");
            $(this).html("Activado");
            $(this).attr("activarUsuario", 0);
        }

    });
}());

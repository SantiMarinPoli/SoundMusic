$(document).ready(function () {
    $("#btnGuardar").click(function () {
        var nom1 = $("#nom1").val();
        var apellido1 = $("#apellido1").val();
        var apellido2 = $("#apellido2").val();
        var textSex1 = $("#textSex1:checked");
        var textSex2 = $("#textSex2:checked");
        var email = $("#email").val();
        var nomUsuario = $("#nomUsuario").val();
        var pass1 = $("#pass1").val();
        var pass2 = $("#pass2").val();
        var numCel = $("#numCel").val();
        var pais = $("#pais option:selected");
        var check = $("#check:checked");

        if (nom1 == "") {
            alert("Ingresar el primer nombre del usuario");
            $("#nom1").addClass("is-invalid");
            return false;
        }else{
            
        }
        if (apellido1 == "") {
            alert("Ingresar el primer apellido del usuario");
            return false;
            $("#apellido1").addClass("is-invalid");
        }
        if (apellido2 == "") {
            alert("Ingresar el segundo apellido del usuario");
            $("#apellido2").addClass("is-invalid");
            return false;
        }
        if ((textSex1.length == 0) && (textSex2.length == 0)) {
            alert("Ingresar el sexo del usuario");
            
            return false;
        }
        if (email == "") {
            alert("Ingresar el correo del usuario");
            return false;
        }
        if (nomUsuario == "") {
            alert("Ingresar el nombre del usuario");
            return false;
        }
        if (pass1 == "") {
            alert("Ingresar la nueva contraseña");
            return false;
        }
        if (pass2 == "") {
            alert("Ingresar de nuevamente la contraseña");
            return false;
        }
        if (pass1 !== pass2) {
            alert("La contraseña debe ser igual");
            pass1 = "";
            pass2 = "";
            return false;
        } else {
            alert("La constraseña esta segura");
        }
        if (numCel == "") {
            alert("Ingresar el numero movil del usuario");
            return false;
        }
        if (pais.val()=="") {
            alert("Seleccionar un pais ");
            return false;
        }
        if (check.length == 0) {
            alert("Seleccionar los terminos condiciones");
            return false;
        }

    });
});
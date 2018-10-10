
    $(document).on("ready", inicio);

    function inicio() {
        $("div.invalid-feedback ").hide();
        $("#btnGuardar").click(function () {
            if (validar() == false) {
                alert("los campos no estan validados");
            } else {
                alert("los campos estan validados");
            }
        });
        $("#texto").keyup(validar);
    }

    function  validar() {
        var valor = document.getElementById("texto");

        for (var i = 0; i < valor.length; i++) {
            if (valor[i].type == "text" && valor[i].value == "") {
                console.log("El campo, " + valor[i].name + " esta incompleto");
                valor[i].className = valor[i].className + "  is-invalid";
                return false;
            } else {
                elementos[i].className = elementos[i].className.replace("is-invalid", "");
            }
        }

    }




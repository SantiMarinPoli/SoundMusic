(function () {

    var formulario = document.formulario_empresa,
            elementos = formulario.elements;

// Funciones
    var validarInputs = function () {
        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].type === "text") {

                if (elementos[i].value === 0) {
                    console.log("El campo, " + elementos[i].name + " esta incompleto.");
                    elementos[i].className = elementos[i].className + " is-invalid";
                    return false;
                } else {
                    elementos[i].className = elementos[i].className.remplace("is-invalid", "");
                }

            }
        }
        return true;
    };

    var validarRadios = function () {
        var opciones = document.getElementsByName("tipoEmpresa"),
                resultado = false;

        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].type === "radio" && elementos[i].name === "tipoEmpresa") {
                for (var j = 0; j < opciones.length; j++) {
                    if (opciones[j].checked) {
                        resultado = true;
                        break;
                    }
                }

                if (resultado === false) {
                    elementos[i].parentNode.className = elementos[i].parentNode.className + " is-invalid";
                    console.log("El campo tipo empresa esta incompleto");
                    return false;
                } else {
                    elementos[i].parentNode.className = elementos[i].parentNode.className.replace("is-invalid", "");
                    return true;
                }
            }
        }
    };

    var validarCheckbox = function () {
        var opciones = document.getElementsByName("terminos"),
                resultado = false;

        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].type === "checkbox") {
                for (var j = 0; j < opciones.length; j++) {
                    if (opciones[j].checked) {
                        resultado = true;
                        break;
                    }
                }

                if (resultado === false) {
                    elementos[i].parentNode.className = elementos[i].parentNode.className + " is-invalid";
                    console.log("Los terminos y condiciones  esta incompleto");
                    return false;
                } else {
                    elementos[i].parentNode.className = elementos[i].parentNode.className.replace("is-invalid", "");
                    return true;
                }
            }
        }
    };

    var enviar = function (e) {

        if (!validarInputs()) {
            console.log("falta validar los inputs");
            e.preventDefault();
        } else if (!validarRadios()) {
            console.log("falta validar los radios");
            e.preventDefault();
        } else if (!validarCheckbox()) {
            console.log("falta validar los checkbox");
            e.preventDefault();
        } else if (!validarFile()) {
            console.log("falta validar el input file");
            e.preventDefault();
        } else {
            console.log("Enviar correctamente");
            e.preventDefault();

        }
    };

//    Funciones blur y focus
    var focusInput = function () {
        this.parentElement.children[1].className = "form-control active";
        this.parentElement.children[0].className = this.parentElement.children[0].className.replace("is-invalid", "");
    };

    var blurInput = function () {
        if (this.value <= 0) {
            this.parentElement.children[1].className = "form-control is-invalid";
            this.parentElement.children[0].className = this.parentElement.children[0].className + " is-invalid";
        }

    };

//Eventos
    formulario.addEventListener("submit", enviar);

    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type === "text" && elementos[i].name === "nomEmpresa") {
            elementos[i].addEventListener("focus", focusInput);
            elementos[i].addEventListener("blur", blurInput);
        }
    }

}());


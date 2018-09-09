$(function () {
    var formularios = document.formulario_artista,
            elementos = formularios.elements;

//        FUNCIONES
    var validarInputs = function () {
        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].type == "text" || elementos[i].type == "number") {
                if (elementos[i].value == 0) {
                    console.log("El campo, " + elementos[i].name + " esta incompleto");
                    elementos[i].className + " is-invalid";
                    return false;
                } else {
                    elementos[i].className = elementos[i].className.replace("is-invalid", "");
                }
            }
        }
    };

    var enviar = function (e) {
        if (!validarInputs()) {
            console.log("Faltar validar los inputs");
            e.preventDefault();
        } else {
            console.log("Envio exitosamente");
            e.preventDefault();
        }
    };

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

//EVENTOS
    formularios.addEventListener("submit", enviar);

    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type == "text" || elementos[i].type == "number") {
            elementos[i].addEventListener("focus", focusInput);
            elementos[i].addEventListener("blur", blurInput);
        }
    }

}());



$(function () {
    var formulario = document.formulario_empresa,
            elementos = formulario.elements;
// FUNCIONES
    var validarInputs = function () {
        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].type == "text") {
                if (elementos[i].value == 0) {
                    console.log("El campo, " + elementos[i].name + " esta incompleto");
                    elementos[i].className = elementos[i].className + "  is-invalid";
                    return false;
                } else {
                    elementos[i].className = elementos[i].className.replace("is-invalid", "");
                }
            }
        }
    return true;
};

//    var validarRadio = function () {
//        var op = document.getElementsByName("sexo"),
//                res = false;
//
//        for (var i = 0; i < elementos.length; i++) {
//            if (elementos[i].type == "radio" && elementos[i].name == "sexo") {
//                console.log("Error metodo");
//                for (var j = 0; j < op.length; j++) {
//                    if (op[j].checked) {
//                        console.log("Error checked");
//                        res = true;
//                        break;
//                    }
//                }
//
//                if (res == false) {
//                    elementos[i].parentNode.className = elementos[i].parentNode.className + " is-invalid";
//                    console.log("El campo esta incompleto");
//                    return false;
//                } else {
//                    console.log("ERROR RADIO");
//                    elementos[i].parentNode.className = elementos[i].parentNode.className.remplace("is-invalid", "");
//                    return true;
//                }
//            }
//        }
//
//    };

    var enviar = function (e) {
        if (!validarInputs()) {
            console.log("Falta validar los inputs");
            e.preventDefault();
        } else if (!validarRadio()) {
            console.log("Falta validar los radios");
            e.preventDefault();
        } else if (!validarCheckbox()) {
            console.log("Falta validar los checkbox");
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
    formulario.addEventListener("submit", enviar);

    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type == "text") {
            elementos[i].addEventListener("focus", focusInput);
            elementos[i].addEventListener("blur", blurInput);
        }
    }
}());
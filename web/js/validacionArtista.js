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
            console.log("Falta validar los inputs");
            swal({
                position: 'top-end',
                type: 'error',
                title: 'Faltan completar unos campos oblgatorio',
                showConfirmButton: false,
                timer: 1500
            })
            e.preventDefault();
        } else {
            console.log("Envio exitosamente");
            swal({
                title: '¿Estas seguro quiere enviar los datos?',
                text: "You won't be able to revert this!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, guardar!'
            }).then((result) => {
                if (result.value) {
                    swal(
                            'Guardado!',
                            'Envio exitosamente.',
                            'success'
                            );
                }
            });
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



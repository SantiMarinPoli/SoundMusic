$(function () {
//    var formularios = document.formulario_artista,
//            elementos = formularios.elements;
//
////        FUNCIONES
//    var validarInputs = function () {
//        for (var i = 0; i < elementos.length; i++) {
//            if (elementos[i].type == "text" || elementos[i].type == "number") {
//                if (elementos[i].value == 0) {
//                    console.log("El campo, " + elementos[i].name + " esta incompleto");
//                    elementos[i].className + " is-invalid";
//                    return false;
//                } else {
//                    elementos[i].className = elementos[i].className.replace("is-invalid", "");
//                }
//            }
//        }
//    };
//
//
//    var enviar = function (e) {
//        if (!validarInputs()) {
//            console.log("Falta validar los inputs");
//            swal({
//                position: 'top-end',
//                type: 'error',
//                title: 'Faltan completar unos campos oblgatorio',
//                showConfirmButton: false,
//                timer: 1500
//            })
//            e.preventDefault();
//        } else {
//            console.log("Envio exitosamente");
//            swal({
//                title: '¿Estas seguro quiere enviar los datos?',
//                text: "You won't be able to revert this!",
//                type: 'warning',
//                showCancelButton: true,
//                confirmButtonColor: '#3085d6',
//                cancelButtonColor: '#d33',
//                confirmButtonText: 'Si, guardar!'
//            }).then((result) => {
//                if (result.value) {
//                    swal(
//                            'Guardado!',
//                            'Envio exitosamente.',
//                            'success'
//                            );
//                }
//            });
//            e.preventDefault();
//
//        }
//    };
//
//    var focusInput = function () {
//        this.parentElement.children[1].className = "form-control active";
//        this.parentElement.children[0].className = this.parentElement.children[0].className.replace("is-invalid", "");
//    };
//
//    var blurInput = function () {
//        if (this.value <= 0) {
//            this.parentElement.children[1].className = "form-control is-invalid";
//            this.parentElement.children[0].className = this.parentElement.children[0].className + " is-invalid";
//        }
//    };
//
////EVENTOS
//    formularios.addEventListener("submit", enviar);
//
//    for (var i = 0; i < elementos.length; i++) {
//        if (elementos[i].type == "text" || elementos[i].type == "number") {
//            elementos[i].addEventListener("focus", focusInput);
//            elementos[i].addEventListener("blur", blurInput);
//        }
//    }

//VALIDAR FORMULARIOS
$(document).ready(function (){
    $("#btnGuardar").click(function (){
        var nom1 = $("#nom1").val();
        var apellido1 = $("#apellido1").val();
        var apellido2 = $("#apellido2").val();
        var textSex1 = $("#textSex1:checked");
        var textSex2 = $("#textSex2:checked");
        var pais = $("#pais option:selected");
        var nomArtista = $("#nomArtista").val();
        
            if (nom1 == "") {
                alert("Ingresar el primer nombre del artista");
                return false;
            }
            if (apellido1 == "") {
                alert("Ingresar el primer apellido del artista");
                return false;
            }
            if (apellido2 == "") {
                alert("Ingresar el segundo apellido del artista");
                return false;
            }
            if ((textSex1.length == 0)&&(textSex2.length == 0)) {
                alert("Seleccionar el sexo del artista");
                return false;
            }
            if (pais.val() == "") {
                alert("Seleccionar el pais del artista");
                return false;
            }
            if (nomArtista=="") {
                alert("Ingresar el nombre del artista");
                return false;
            }
        
    });
});


    //SUBIENDO FOTOS DEL ARTISTA Y EL ALBUN

    $(".nuevaFoto").change(function () {

        var imagen = this.files[0];

        /*=============================================
         VALIDAMOS EL FORMATO DE LA IMAGEN SEA JPG O PNG
         =============================================*/
        if (imagen["type"] != "image/jpeg" && imagen["type"] != "image/png") {

            $(".nuevaFoto").val("");

            swal({
                title: "Error al subir la imagen",
                text: "¡La imagen debe estar en formato JPG o PNG!",
                type: "error",
                confirmButtonText: "¡Cerrar!"
            });

        } else if (imagen["size"] > 2000000) {

            $(".nuevaFoto").val("");

            swal({
                title: "Error al subir la imagen",
                text: "¡La imagen no debe pesar más de 2MB!",
                type: "error",
                confirmButtonText: "¡Cerrar!"
            });

        } else {

            var datosImagen = new FileReader;
            datosImagen.readAsDataURL(imagen);

            $(datosImagen).on("load", function (event) {

                var rutaImagen = event.target.result;

                $(".previsualizar").attr("src", rutaImagen);

            });

        }
    });


}());



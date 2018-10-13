//  Validar album
$(document).ready(function () {

    $("#btnGuardar").click(function () {
        var nomArtista = $("#nomArtista option:selected");
        var nomAlbum = $("#nomAlbum").val();
        var nomEmpresa = $("#nomEmpresa option:selected");
        var numCanciones = $("#numCanciones").val();
        var paisAlbum = $("#paisAlbum option:selected");
        var ciudadAlbum = $("#ciudadAlbum").val();
        var fechaLanzamiento = $("#fechaLanzamiento").val();

        if (nomArtista.val() == "") {
            alert("Seleccione el nombre de artista");
            return false;
        }
        if (nomAlbum == "") {
            alert("Ingrese un nombre del album");
            return false;
        }

        if (nomEmpresa.val() == "") {
            alert("Seleccionar el nombre de la empresa");
            return false;
        }

        if (numCanciones == "") {
            alert("Ingrese el numero de canciones");
            return false;
        }
        if (paisAlbum.val() == "") {
            alert("Seleccionar un pais ");
            return false;
        }
        if (ciudadAlbum == "") {
            alert("Ingresar una ciudad");
            return false;
        }
        if (fechaLanzamiento == "") {
            alert("seleccionar la fecha de lanzamiento");
            return false;
        }
    });

});



//CALCULAR LA OPERACION LA REGALIA DEL ARTISTA Y APARECE LOS LOGROS
$("input#numCanciones").on("keyup", function () {
    var valor = $(this).val();
    var total = 0;
    var empresa = $("#nomEmpresa").val();
//        $("input#totalCanciones").val(valor);
    if (empresa == "Spotify") {
        total = valor * 5;
        $("input#totalCanciones").val("$" + total + " USD");
        if (total >= 100.00) {
            swal({
                title: 'Felicitaciones!',
                text: 'Obtenistes el disco de oro.',
                imageUrl: 'icon/discoOro.png',
                imageWidth: 64,
                imageHeight: 64,
                imageAlt: 'Custom image',
                animation: false
            });
        } else
        if (total >= 50.00) {
            swal({
                title: 'Felicitaciones!',
                text: 'Obtenistes el disco de Plata.',
                imageUrl: 'icon/discoPlat.png',
                imageWidth: 64,
                imageHeight: 64,
                imageAlt: 'Custom image',
                animation: false
            });
        }
    } else
    if (empresa == "Napster") {
        total = valor * 8;
        $("input#totalCanciones").val("$" + total + " USD");
        if (total >= 100.00) {
            swal({
                title: 'Felicitaciones!',
                text: 'Obtenistes el disco de oro.',
                imageUrl: 'icon/discoOro.png',
                imageWidth: 64,
                imageHeight: 64,
                imageAlt: 'Custom image',
                animation: false
            });
        } else
        if (total >= 50.00) {
            swal({
                title: 'Felicitaciones!',
                text: 'Obtenistes el disco de Plata.',
                imageUrl: 'icon/discoPlat.png',
                imageWidth: 64,
                imageHeight: 64,
                imageAlt: 'Custom image',
                animation: false
            });
        }
    } else
    if (empresa == "!Music") {
        total = valor * 10;
        $("input#totalCanciones").val("$" + total + " USD");
        if (total >= 100.00) {
            swal({
                title: 'Felicitaciones!',
                text: 'Obtenistes el disco de oro.',
                imageUrl: 'icon/discoOro.png',
                imageWidth: 64,
                imageHeight: 64,
                imageAlt: 'Custom image',
                animation: false
            });
        } else
        if (total >= 50.00) {
            swal({
                title: 'Felicitaciones!',
                text: 'Obtenistes el disco de Plata.',
                imageUrl: 'icon/discoPlat.png',
                imageWidth: 64,
                imageHeight: 64,
                imageAlt: 'Custom image',
                animation: false
            });
        }
    }
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


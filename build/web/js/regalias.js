$(function () {

    $(".btnActivar").click(function () {

        var idRegalias = $(this).attr("idRegalias");
        var activarRegalias = $(this).attr("activarRegalias");
        
       
        var datos = new FormData();
        datos.append("activarId", idRegalias);
        datos.append("activarRegalias", activarRegalias);

        if (activarRegalias == 0) {

            swal({
                title: '¿Estas Seguro de Pagar?',
                text: "Si acepta la condicion puede pagar al artista de este mes.",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, Pagar Ya!'
            }).then((result) => {
                if (result.value) {
                    swal(
                            'Pago Exitosamente!',
                            'Has pagado la regalia del artista de este mes.',
                            'success'
                            );

                    $(this).removeClass("badge-success");
                    $(this).addClass("badge-danger");
                    $(this).html("Pendiente");
                    $(this).attr("activarRegalias", 1);
                }
            });


        } else {

            swal({
                title: '¿Estas Seguro de Cancelar el Pago?',
                text: "Si acepta la condicion, el artista no va llegar el pago del salario de este mes",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, cancelar el pago!'
            }).then((result) => {
                if (result.value) {
                    swal(
                            'Pago Cancelado!',
                            '',
                            'success'
                            );

                    $(this).removeClass("badge-danger");
                    $(this).addClass("badge-success");
                    $(this).html("Pago Exitosamente");
                    $(this).attr("activarRegalias", 0);

                }
            });
        }

    });
}());




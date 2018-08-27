(function () {
    var lista = document.getElementById("lista"),
            textAgregarArtista = document.getElementById("textAgregarArtista"),
            btnAgregar = document.getElementById("btnAgregarArtista");

//Funciones
    var agregarArtista = function () {
        var agregar = textAgregarArtista.value,
                nuevoArtista = document.createElement("li"),
                enlace = document.createElement("a"),
                contenido = document.createTextNode(agregar);
        if (agregar === "") {
            textAgregarArtista.setAttribute("placeholder", "Agregar un artista valido");
            textAgregarArtista.className = "form-control is-invalid";
            return false;
        }
        enlace.appendChild(contenido);
        enlace.setAttribute("href", "#");
        nuevoArtista.appendChild(enlace);
        nuevoArtista.className = "list-group-item disabled";
        lista.appendChild(nuevoArtista);

        textAgregarArtista.value = "";

        for (var i = 0; i < lista.children.length - 1; i++) {
            lista.children[i].addEventListener("click", function () {
                this.parentNode.removeChild(this);
            });
        }
    };
    var comprobarInput = function () {
        textAgregarArtista.className = "form-control";
        textAgregarArtista.setAttribute("placeholder", "Agregar artista");
    };
    var eliminarArtista = function () {
        this.parentNode.removeChild(this);
    };
//     Eventos

//Agregar Artista
    btnAgregar.addEventListener("click", agregarArtista);

//  Comprobar Input
    textAgregarArtista.addEventListener("click", comprobarInput);

//Borrar el elemento de la lista
    for (var i = 0; i < lista.children.length - 1; i++) {
        lista.children[i].addEventListener("click", eliminarArtista);
    }


}());

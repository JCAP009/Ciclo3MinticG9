var cedula = new URL(location.href).searchParams.get("cedula");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?cedula=" + cedula);
        
        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getPeliculas(false, "ASC");

        $("#ordenar-zona").click(ordenarParqueaderos);
    });
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            cedula: cedula
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
    }
    
    function getParqueaderos(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletParqueaderoListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarParqueaderos(parsedResult);
            } else {
                console.log("Error recuperando los datos de las parqueaderos");
            }
        }
    });
}

function mostrarParqueaderos(parqueaderos) {

    let contenido = "";

    $.each(parqueaderos, function (index, parqueadero) {

        parqueadero = JSON.parse(parqueadero);
        let precio;

        if (parqueadero.numero_espacios > 0) {

            if (user.premium) {

                if (parqueadero.techado) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (parqueadero.techado) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + parqueadero.codigo + '</th>' +
                    '<td>' + parqueadero.nombre + '</td>' +
                    '<td>' + parqueadero.zona + '</td>' +
                    '<td>' + parqueadero.direccion + '</td>' +
                    '<td>' + parqueadero.tipo_vehiculo + '</td>' +
                    '<td>' + parqueadero.numero_espacios + '</td>' +
                    '<td><input type="checkbox" name="techado" id="techado' + parqueadero.codigo + '" disabled ';
            if (parqueadero.techado) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarParqueadero(' + parqueadero.codigo + ',' + precio + ');" class="btn btn-success" ';
            if (user.saldo < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#parqueaderos-tbody").html(contenido);
}

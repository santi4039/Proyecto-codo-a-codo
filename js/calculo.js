var contenido = document.getElementById("busqueda");

var boton = document.getElementById("boton_busqueda");

var precio_accion = document.getElementById("precio_accion");

var cantidadAcciones = document.getElementById("cantidad_acciones");

var precioTotal = document.getElementById("precio_total");


function busqueda(){

    precioTotal.value = cantidadAcciones.value * precio_accion.value + "$";

}


const url = "http://api.marketstack.com/v1/eod?access_key=320bb6136bd87287124ea022c8d55d32&symbols=AAPL";

fetch(url)
.then(response => response.json() )
.then(data => {

    /*let element = document.getElementById("busqueda")
    element.innerHTML = `<p>${data.symbol}</p>`*/

    var datos = data.data

    console.log(datos)
    console.log(`Ticker ${data['symbol']}`)
})
.catch(err => console.log(err))



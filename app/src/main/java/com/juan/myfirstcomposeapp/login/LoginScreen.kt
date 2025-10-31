package com.juan.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) { //funcion composable, es como una pieza que puedo unir y montar las vistas, las funciones composables empiezan con mayúsculas
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//las preview pueden recibir atributos para ver como se verian, son atributos para la preview, no para el componente
/*@Preview(
    widthDp = 50,
    heightDp = 50,
    showBackground = true,
    showSystemUi = true, //este es para ver como se comportaría en un teléfono real
    device = Devices.PIXEL_4, //para ver la preview en un dispositivo especifico
    //locale = para testear los idiomas
    //apiLevel = para ver como se ve en diferentes apis
 )*/
//lo malo de las preview es que no se pueden mostrar si reciben parámetros
//la solición es inicializar el parametro como por ejemplo a:String = "Juan"
//o lo que se suele hacer el crear otro composable igual solo para probar sin que reciba parametros

@Preview()
@Composable
fun ExamplePreview(){
    Text("Juan", modifier = Modifier
        .background(Color.Red)
        .height(33.dp)
        .width(60.dp)
        .padding(2.dp)
    )
}
@Composable
fun Example(a: String){
    Text("Juan $a", modifier = Modifier.height(33.dp).width(60.dp))
}
//modificadores, le dan el estilo al composable
// .size modifica ancho y alto
// .fillMaxWid() ocupa todo el ancho
// .fillMaxHeight() ocupa todo el alto
// .fillMaxSize() ocupa todo el ancho y alto
// .padding() //en compose no existe el margin es todo padding
// tipos de padding .padding(all=) .padding() por defecto es all, .padding(horizontal), .padding(vertical), .padding(top)

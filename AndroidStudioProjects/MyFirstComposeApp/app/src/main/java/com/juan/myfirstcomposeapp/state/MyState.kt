package com.juan.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/*@Composable
fun MyState(modifier: Modifier){
    var number = remember{mutableStateOf(0)}  //el remember es para que cuando se cambia el estado y se ejecute nuevamente la vista no se vuelva a asignar el valor por defecto

    Column {
        Text("Pulsame: ${number.value}", modifier.clickable{number.value+=1} ) //le pasamos el modificador para hacer el texto clickeable
        Text("Pulsame: ", modifier.clickable{number.value+=1} )
        Text("Pulsame: ", modifier.clickable{number.value+=1} )
        Text("Pulsame: ${number.value}", modifier.clickable{number.value+=1} )
        Text("Pulsame: ", modifier.clickable{number.value+=1} )
    }

}*/

//cuando modifico un estado la vista se recompone, se vuelve a ejecutar el bloque
// cada vez que pulso modifico el mutable estate, el recompone la vista, le ponemos remember para que guarde su estado y no se resetee
//

/*@Composable
fun MyState(modifier: Modifier){
    //el by es un operador que nos permite acceder al operador sin tener que acceder a .value
    //nos obliga a importar el setValue y getValue
    var number by rememberSaveable {mutableStateOf(0)}  //rememberSaveable es para que no se reinicie al rotar la pantalla, ya que se crea una nuava vista
//cuando rotamos la pantalla crea un bundle que guarda la informacion de la variable, luego si está la restituye

    Column {
        Text("Pulsame: $number", modifier.clickable{number+=1} )

        Text("Pulsame: $number", modifier.clickable{number+=1} )
    }

}*/

//los composables debemos tratarlos de hacerlos los mas simples posibles

@Composable
fun MyState(modifier: Modifier){
    var number by rememberSaveable {mutableStateOf(0)}

    Column(modifier = modifier) {
       StateExample1(number) {number+=1} //a las funciones lambda puedo pasarlas por dentro del parentesis o por fuera
        StateExample2(number, onClick = {number+=1})
    }

}

@Composable
fun StateExample1(number:Int, onClick:()->Unit){
    //para que modifique el valor del mutableState debemos pasarle una funcion lambda que cuando yo pulse se ejecute en el padre
    Text("Pulsame: $number", modifier = Modifier.clickable{onClick()} ) //yo solo ejecuto la funcion, pero acá no se lo que hace, de eso se encarga el padre

}

@Composable
fun StateExample2(number:Int,onClick:()->Unit){

    Text("Pulsame: $number", modifier = Modifier.clickable{onClick()} )

}
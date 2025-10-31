package com.juan.myfirstcomposeapp.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyColumn(modifier: Modifier = Modifier){ //le paso el modifier por parametro
    /*  Column(modifier = modifier){ //es para que no se apilen los elementos, se ponen uno debajo del otro
         Text("Hola 1", modifier = Modifier.background(Color.Red).weight(1f)) //con weight le damos el peso, le decimos cuanto queremos que ocupe ocn respecto a los demas
          Text("Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f)) //los pesos aplican depende del tamaño del padre, se ajustan a su tamaño, no pueden ser mas
         Text("Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f))
         Text("Hola 4", modifier = Modifier.background(Color.Blue).weight(1f))
     }*/
    Column(modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally){//le decimos que ocupe todoo y que nos divida las vistas con un espacio proporcional entre las vistas, tambien le podemos decir que lo centre horizontal
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Cyan))
        Text("Hola 3", modifier = Modifier.background(Color.Yellow))
        Text("Hola 4", modifier = Modifier.background(Color.Blue))
    }

}
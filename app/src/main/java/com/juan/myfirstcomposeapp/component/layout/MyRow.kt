package com.juan.myfirstcomposeapp.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
//fila
fun MyRow(modifier: Modifier = Modifier){
/*    Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround) {
        Text("Hola 1", modifier = Modifier.background(Color.Red).weight(1f))
        Text("Hola 2", modifier = Modifier.background(Color.Blue).weight(1f))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text("Hola 4", modifier = Modifier.background(Color.Green).weight(1f))

    }*/
    Row(modifier = modifier.fillMaxSize().horizontalScroll(rememberScrollState())) {
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Green))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Green))


    }

}
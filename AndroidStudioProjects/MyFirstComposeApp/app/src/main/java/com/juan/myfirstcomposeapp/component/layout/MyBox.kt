package com.juan.myfirstcomposeapp.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyBox(){
    //el  contentAlignment solo afecta a su hijo directo
    //el box por defecto ocupa solo el tamaño que necesita pero si queremos le podemos pasar el modifier
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        //los box por defecto organizan a sus hijos arriba a la izquierda, punto 0,0, con contentAligment definimos su posicion
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(30.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState()), //scroll vertical
            contentAlignment = Alignment.Center
        ){
            Text("Hola hola hola hola")
        }
    }

}
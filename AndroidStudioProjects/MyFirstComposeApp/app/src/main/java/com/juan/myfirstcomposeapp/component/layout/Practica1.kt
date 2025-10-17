package com.juan.myfirstcomposeapp.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun Practica1(modifier: Modifier = Modifier){
    Column(modifier=modifier) {
        Box(modifier= Modifier.weight(1f).fillMaxWidth().background(Color.Cyan), contentAlignment = Alignment.Center){
            Text("Ejemplo 1")

        }
        Box(modifier= Modifier.weight(1f).fillMaxWidth()){
            Row (modifier= Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Red), contentAlignment = Alignment.Center
                ){
                    Text("Ejemplo 2")
                }
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Green), contentAlignment = Alignment.Center
                ){
                    Text("Ejemplo 3")
                }
            }

        }
        Box(modifier= Modifier.weight(1f).fillMaxWidth().background(Color.Magenta), contentAlignment = Alignment.BottomCenter){
            Text("Ejemplo 4")

        }

    }
}
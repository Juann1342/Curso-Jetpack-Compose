package com.juan.myfirstcomposeapp.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        //un boton por defecto es un rectangulo,
        //entre parentesis recibe el onclick y entre llaves el contenido, ambos son funciones lambda
        //con enabled puedo habilitarlo o deshabilitarlo, shape es el redondeado
        Button(
            onClick = { Toast.makeText(context, "Botón pulsado", Toast.LENGTH_SHORT).show() },
            enabled = false,
            shape = RoundedCornerShape(10.dp), //dp redondea las esquinas 10 puntos, so le pongo solo 10 es 10 %
        //    border = BorderStroke(2.dp, Color.Red)
            border = BorderStroke(2.dp, Color.Red),
            colors =  ButtonDefaults.buttonColors(contentColor = Color.Red, containerColor = Color.Gray, disabledContainerColor = Color.Yellow) //para saber estas cosas tengo que ir metiendome en los elementos e indagando su contenido


        ) {
       //     Text("Pulsame", color = Color.White) //puedo sobreescribir el color desde el texto aunque lo haya definido en el boton
            Text("Pulsame")

            /*  Column {
                  Text("Pulsame")
                  Box(Modifier
                      .size(30.dp)
                      .background(Color.Red)) { }

              }*/
        }

        //por defecto son son color porque son para acciones secundarias
        OutlinedButton(onClick = {}) {
            Text("Outlined")
        }

        //son tipicos para usar en cosas poco importantes
        TextButton(onClick = {}) {
            Text("TextButton")
        }

        //tiene una elevacion por defecto, si quiero tambien puedo modificar esa elevacion con , elevation = ButtonDefaults.elevatedButtonElevation()
        ElevatedButton(onClick = {}) {
            Text("ElevatedButton")
        }

        //la unica diferencia con un boton normal es que viene con un color mas suave, es para enfasis medio, entre normal y outlined
        FilledTonalButton(onClick = {}) {
            Text("FilledTonalButton")
        }

    }

}
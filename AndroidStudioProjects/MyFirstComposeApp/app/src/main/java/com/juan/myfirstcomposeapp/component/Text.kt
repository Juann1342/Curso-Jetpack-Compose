package com.juan.myfirstcomposeapp.component

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "pepe")
        Text(text = "pepe rojo", color = Color.Red)
        Text(text = "pepe", fontSize = 25.sp)
        Text(text = "pepe", fontStyle = FontStyle.Italic)
        Text(
            text = "pepe",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp
        )
        Text(text = "pepe", letterSpacing = 3.sp)
        Text(text = "pepe", textDecoration = TextDecoration.LineThrough)
        Text(text = "pepe", textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)
        Text(text = "pepe", textDecoration = TextDecoration.Underline, color = Color.Blue, modifier = Modifier.clickable{})
        Text(text = "Align", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) //para que funcione la alineacion debemos agregarle el modificador para que ocupe todoo el ancho así poder centrarse en la pantalla
        Text(text = "Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, maxLines = 1, overflow = TextOverflow.Ellipsis) // lo limitamos a una linea y le agregamos overflow para indicarle al usuario que hay mas texto y no alcanza a mostrarse



    }
}
package com.juan.myfirstcomposeapp.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.juan.myfirstcomposeapp.R

/*
@Preview
@Composable
fun MyImage() {
    //el painterResourse recibe el id de un drawable, si o si necesita un contentDescription, puedo dejarlo en null, pero este describe la imagen para la usabilidad
    Image(
        painter = painterResource(R.drawable.cat2),
        contentDescription = "Avatar image profile",
        Modifier.height(200.dp).width(40.dp),
        contentScale = ContentScale.FillWidth//definimos como queremos que se comporte al cambiar el tamaño de la imagen
    )
}*/


@Composable
fun MyImage() {
    //el painterResourse recibe el id de un drawable, si o si necesita un contentDescription, puedo dejarlo en null, pero este describe la imagen para la usabilidad
    Image(
        painter = painterResource(R.drawable.pika),
        contentDescription = "Avatar image profile",
        Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(50)) //clip es recorta
            //   .clip(CircleShape), //para circulos lo mejor es utilizar cicleshape, para no tener que ponerne 50 al roundedCorner... también existe rectangleshape
            //   .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 70.dp)), // puedo elegir individualmente
            // .border(width = 5.dp, color = Color.Red, RoundedCornerShape(50)), // no elvidar ponerle el shape en caso de que la imagen tenga bordes redondeados
            .border(
                width = 5.dp,
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow)),
                RoundedCornerShape(50)
            ), //los bordes pueden tener un brush que es como un degradado, para eso necesita dos colores
        contentScale = ContentScale.FillBounds//definimos como queremos que se comporte al cambiar el tamaño de la imagen
    )
}


// para cargar imagenes desde la web utilizar coil android (buscar en google), agregar la dependencia en gradle
// no olvidar agregar el permiso de internet en manifesf

@Composable
fun MyNetWorkImage(modifier: Modifier) {
    AsyncImage(
        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTq3YQyD5I2YuaK0lrY4rd9vAbm1Cki7eS8QQ&s",
        contentDescription = "Image from network",
        modifier = modifier
            .size(250.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 5.dp,
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow)),
                RoundedCornerShape(50)
            ),
        onError = { //esto es propio de coil
            Log.i("Image", "ha ocurrido un error ${it.result.throwable.message}.")
        }
    )
}

@Preview
@Composable
fun MyIcon(){
    //a los iconos podemos cambiarle el color
    Icon(painter = painterResource(R.drawable.ic_personita), contentDescription = null, modifier = Modifier.size(300.dp), tint = Color.Blue)
}
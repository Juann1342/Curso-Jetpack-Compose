package com.juan.myfirstcomposeapp.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.juan.myfirstcomposeapp.R

@Composable
fun Progress(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //   CircularProgressIndicator() el mas basico
        CircularProgressIndicator(
            Modifier.size(140.dp), //tamaño
            color = Color.Red, //color de linea
            strokeWidth = 40.dp, //ancho de la linea
            trackColor = Color.Blue, //la parte estatica
            strokeCap = StrokeCap.Butt //las puntas de la linea
        ) //puedo modificar sus atributos

        Spacer(Modifier.height(24.dp))
        //linea simple
        //  LinearProgressIndicator()
        //con atributos modificados
        LinearProgressIndicator(
            color = Color.Green,
            trackColor = Color.Magenta,
            strokeCap = StrokeCap.Square,
            gapSize = 20.dp //espacio al principio y final
        )

    }

}

@Composable
fun ProgressAdvance(modifier: Modifier) {
    var progress : Float by remember { mutableStateOf(0.5f) }

    var isLoading by remember { mutableStateOf(false) } //lo vamos a utilizar para mostar u ocultar
    //lo puedo animar
    val animatedProgress by animateFloatAsState(targetValue = progress)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isLoading){
            CircularProgressIndicator(
                progress = {animatedProgress}, //funcion lambda donde puedo darle el comportamiento, siempre tengo que devolver el valor
                Modifier.size(140.dp), //tamaño
                color = Color.Red,
                strokeWidth = 40.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Butt
            )
        }


        Spacer(Modifier.height(24.dp))
        //linea simple
        //  LinearProgressIndicator()
        //con atributos modificados
        LinearProgressIndicator(
            progress = {progress},
            color = Color.Green,
            trackColor = Color.Magenta,
            strokeCap = StrokeCap.Square,
            gapSize = 4.dp //espacio al principio y final
        )
        Row(Modifier.padding(24.dp)){
            Button(onClick = {progress+=0.1f}){ Text("-->") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = {progress-=0.1f}){ Text("<--") }

        }
        //
        Button(onClick = {isLoading = !isLoading}){Text("Show/Hide")}

    }


}

//animacion pro con lottie https://airbnb.io/lottie/#/android-compose
//seguir las instrucciones, agregar al build gradle del proyecto o el settings gradle si es android studio mas nuevo, luego en el gradle del modulo app
// la animacion obtenerla de lottiesfiles.com la mayoria son gratuitas

@Composable
fun ProgressAnimation(modifier: Modifier){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cat))
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)

    }

}
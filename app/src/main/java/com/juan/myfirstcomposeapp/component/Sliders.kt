package com.juan.myfirstcomposeapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue by remember { mutableFloatStateOf(0f) }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        //si uso la version que necesita un value, obligatoriamente voy a necesitar onValueChange
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                activeTickColor = Color.Blue,
                disabledActiveTrackColor = Color.DarkGray,
                inactiveTrackColor = Color.Green
            )
        )
        Text(myValue.toString())
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example by remember { mutableStateOf(":(") }
    val state = remember {
        SliderState(
            value = 5f, //dede donde empieza
            valueRange = 0f..10f, //los rangos de mi slider
            steps = 9,//en cuanto divido la franja, son los intervalos, necesito 9 para formar 10
            onValueChangeFinished = {
                example = "FELIZ"
            } //esto se llama cuando suelto la barra después de moverla, sirve para lanzar dialogos o validaciones, como por ej estás seguro de...
        )
    }
    val colors = SliderDefaults.colors( //puedo definir los colores en una variable para reutilizar
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        activeTickColor = Color.Blue,
        disabledActiveTrackColor = Color.DarkGray,
        inactiveTrackColor = Color.Green
    )
    Column(modifier = Modifier.padding(horizontal = 32.dp, vertical = 40.dp)) {
        Slider(
            state,
            colors = colors,
            thumb = { state ->
                Box(
                    Modifier
                        .width(10.dp)
                        .height(50.dp)
                        .background(Color.Cyan)
                )
            },//en el thumb (selector) podemos poner cualquier composable, y en state obtenemos el estado de la slider
            track = {Box(Modifier
                .height(55.dp)
                .width(200.dp)
                .background(Color.Red))})  //el track tambien podemos personalizarlo todo lo que queremos
        Text(state.value.toString())
        Text(example)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    Column (modifier=modifier.padding(horizontal = 30.dp)){
        var state: RangeSliderState = remember { RangeSliderState(
            activeRangeStart = 3f, //donde empieza
            activeRangeEnd = 6f, //donde termina
            valueRange = 0f..10f,
            steps = 8,
            onValueChangeFinished = {}
        ) } //tambien podemos personalizar colores, thumb (en este caso dos), igual que las demás

        RangeSlider(state = state)
    }
    
}
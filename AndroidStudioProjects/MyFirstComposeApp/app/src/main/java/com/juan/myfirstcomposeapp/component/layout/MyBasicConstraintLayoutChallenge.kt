package com.juan.myfirstcomposeapp.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayoutChallenge(modifier: Modifier){
    ConstraintLayout(modifier= modifier.fillMaxSize()) { //tenemos que decirle que ocupe el maximo porque por defecto ocupa el minimo
        val(boxRed,boxGray, boxGreen, boxMagenta,boxYellow,boxDarkGray, boxCyan,boxBlack)=createRefs() //creo las variables que van a hacer referencia a cada uno de los elementos, son como los id
        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){            top.linkTo(boxYellow.bottom)
            end.linkTo(parent.end)})
        Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            start.linkTo(parent.start)
        })
        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxYellow.top)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })

    }

}
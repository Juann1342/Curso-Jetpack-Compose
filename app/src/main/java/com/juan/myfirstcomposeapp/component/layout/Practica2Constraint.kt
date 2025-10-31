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
fun PracticaConstraint(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val(boxYellow, boxMagenta, boxGreen, boxGray, boxRed, boxBlue, boxDarkGray, boxCyan,boxBlack)=createRefs()
        Box(modifier= Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier= Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta){
            end.linkTo(boxYellow.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(modifier= Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxYellow.end)
            bottom.linkTo(boxYellow.top)
        })
        Box(modifier= Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue){
            start.linkTo(boxGray.start)
            end.linkTo(boxRed.end)
            top.linkTo(boxYellow.bottom)
        })
        Box(modifier= Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })
        Box(modifier= Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(boxYellow.end)
            top.linkTo(boxYellow.bottom)
        })
        Box(modifier= Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan){
            end.linkTo(boxMagenta.end)
            bottom.linkTo(boxMagenta.top
            )
        })
        Box(modifier= Modifier.size(175.dp).background(Color.DarkGray).constrainAs(boxDarkGray){
            start.linkTo(boxGreen.start)
            bottom.linkTo(boxGreen.top
            )
        })
        Box(modifier= Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack){
            start.linkTo(boxCyan.end)
            end.linkTo(boxDarkGray.start)
            bottom.linkTo(boxCyan.bottom)
            top.linkTo(boxDarkGray.top)
        })




    }

}
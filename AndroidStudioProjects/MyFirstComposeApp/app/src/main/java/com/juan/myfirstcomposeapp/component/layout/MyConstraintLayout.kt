package com.juan.myfirstcomposeapp.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
// recordar primero agregar el constraint layout en libs.versions.toml y luego en gradle app
@Composable
fun MyBasicConstraintLayout(modifier: Modifier){
    ConstraintLayout(modifier= modifier.fillMaxSize()) { //tenemos que decirle que ocupe el maximo porque por defecto ocupa el minimo
        val(boxRed,boxGray, boxGreen, boxMagenta,boxYellow)=createRefs() //creo las variables que van a hacer referencia a cada uno de los elementos, son como los id
        Box(Modifier.size(150.dp).background(Color.Red).constrainAs(boxRed){            top.linkTo(boxYellow.bottom)
            end.linkTo(parent.end)})
        Box(Modifier.size(150.dp).background(Color.Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            start.linkTo(parent.start)
        })
        Box(Modifier.size(150.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxYellow.top)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(150.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(150.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })

    }

}


///constrait layout avanzado
@Composable
fun constraintExampleGuide(modifier: Modifier){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxRed = createRef()//creamos la referencia // cuando es una sola variable es createRef, en lugar de createRefs como el anterior

        //creamos la guia, una guia es un componente invisible que sirve para engancharlo a el
     //   val topGuide = createGuidelineFromTop(25.dp)
           val topGuide = createGuidelineFromTop(0.1f) //lo ideal es asignarle el porcentace en lugar de dp en este caso es 10%, esta guia imaginaria siempre va a ocupar el 10% de la pantalla

        Box(Modifier.size(150.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(topGuide)
        })

    }

}


//una barrera es una linea invisible, como un separador para agrupar cosas o secciones
@Composable
fun ConstraintBarrier(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow,boxCyan) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow) //le pasamos las id que queremos meter en la barrera
        Box(Modifier.size(65.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Box(Modifier.size(200.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(boxRed.bottom, margin = 40.dp) //se les puede poner margen
            start.linkTo(parent.start, margin = 32.dp)

        })

        Box(Modifier.size(70.dp).background(Color.Cyan).constrainAs(boxCyan){
            start.linkTo(barrier)
        })
    }
}

//cadenas
@Composable
fun ConstraintChain(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow,boxCyan) = createRefs()

        Box(Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(100.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxRed.bottom)
            bottom.linkTo(boxCyan.top)

        })

        Box(Modifier.size(100.dp).background(Color.Cyan).constrainAs(boxCyan){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxYellow.bottom)
            bottom.linkTo(parent.bottom)
        })

        //una vez que tengo todos los componentes unidos entre si puedo darle el comportamiento que quiero para esa cadena, juntos,separados, etc
      //  createVerticalChain(boxRed, boxYellow,boxCyan, chainStyle = ChainStyle.Packed)
      //  createVerticalChain(boxRed, boxYellow,boxCyan, chainStyle = ChainStyle.Spread)
        createVerticalChain(boxRed, boxYellow,boxCyan, chainStyle = ChainStyle.SpreadInside)


    }

}
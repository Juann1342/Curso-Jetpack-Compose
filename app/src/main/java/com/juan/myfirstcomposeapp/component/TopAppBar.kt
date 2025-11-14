package com.juan.myfirstcomposeapp.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.juan.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text("Mi App") },
        navigationIcon = {
            Icon(painter = painterResource(R.drawable.ic_personita), contentDescription = null)

        },
        actions = { //los que van por la derecha, iconos para varias acciones
            Icon(painter = painterResource(R.drawable.ic_personita), contentDescription = null)
            Icon(painter = painterResource(R.drawable.ic_personita), contentDescription = null, tint = Color.Yellow)
            Icon(painter = painterResource(R.drawable.ic_personita), contentDescription = null)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Magenta,
            actionIconContentColor = Color.Red,
            scrolledContainerColor = Color.Black //el de atrás de la barra cuando se hace scroll
        ),

    )

}
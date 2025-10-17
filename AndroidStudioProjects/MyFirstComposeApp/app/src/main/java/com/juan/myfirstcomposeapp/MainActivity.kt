package com.juan.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juan.myfirstcomposeapp.component.layout.ExerciseOne
import com.juan.myfirstcomposeapp.component.layout.MyBasicConstraintLayout
import com.juan.myfirstcomposeapp.component.layout.MyComplexLayout
import com.juan.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import com.juan.myfirstcomposeapp.login.Greeting
import com.juan.myfirstcomposeapp.component.layout.MyRow
import com.juan.myfirstcomposeapp.component.layout.Practica1
import com.juan.myfirstcomposeapp.component.layout.PracticaConstraint


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                //el innerpadding es el padding que nos da por defecto para que las cosas no se apilen
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   /* Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                  //  MyBox()
                   // MyColumn(Modifier.padding(innerPadding))
                  //  MyRow(Modifier.padding(innerPadding))
                  //  MyComplexLayout(Modifier.padding(innerPadding))
                 //   Practica1(Modifier.padding(innerPadding))
                  //  ExerciseOne(Modifier.padding(innerPadding))
                //    MyBasicConstraintLayout(Modifier.padding(innerPadding))
                    PracticaConstraint(Modifier.padding(innerPadding))

                }
            }
        }
    }
}



@Preview(showBackground = true) //la etiqueta preview es para poder verlo
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}
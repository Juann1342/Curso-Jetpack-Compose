package com.juan.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juan.myfirstcomposeapp.component.MyCheckBox
import com.juan.myfirstcomposeapp.component.MyDropDownItem
import com.juan.myfirstcomposeapp.component.MyDropDownMenu
import com.juan.myfirstcomposeapp.component.MyExposedDropdownMenu
import com.juan.myfirstcomposeapp.component.MyRadioButton
import com.juan.myfirstcomposeapp.component.MyRadioButtonList
import com.juan.myfirstcomposeapp.component.MySlider
import com.juan.myfirstcomposeapp.component.MySliderAdvance
import com.juan.myfirstcomposeapp.component.MySwitch
import com.juan.myfirstcomposeapp.component.ParentCheckBoxes
import com.juan.myfirstcomposeapp.component.TriStateCheckBox
import com.juan.myfirstcomposeapp.component.MyRangeSlider
import com.juan.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import com.juan.myfirstcomposeapp.login.Greeting


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
                 //   PracticaConstraint(Modifier.padding(innerPadding))
                  //  MyBasicConstraintLayoutChallenge(Modifier.padding(innerPadding))
                   // constraintExampleGuide(Modifier.padding(innerPadding))
                   // ConstraintBarrier(Modifier.padding(innerPadding))
                 //   ConstraintChain(Modifier.padding(innerPadding))
                   // MyState(Modifier.padding(innerPadding))
                  //  MyTexts(Modifier.padding(innerPadding))
                //    MyTextField(Modifier.padding(innerPadding))
                   // MyTextFieldParent(Modifier.padding(innerPadding))
                  //  MyButtons(Modifier.padding(innerPadding))
                   // MyNetWorkImage(Modifier.padding(innerPadding))
                  //  Progress(Modifier.padding(innerPadding))
                //    ProgressAdvance(Modifier.padding(innerPadding))
               //     ProgressAnimation(Modifier.padding(innerPadding))
                //    MySwitch(Modifier.padding(innerPadding))
                  //  MyCheckBox(Modifier.padding(innerPadding))
                //    ParentCheckBoxes(Modifier.padding(innerPadding))
                //    TriStateCheckBox(Modifier.padding(innerPadding))
                //    MyRadioButton(Modifier.padding(innerPadding))
               //     MyRadioButtonList(Modifier.padding(innerPadding))
                //    MySlider(Modifier.padding(innerPadding))
                 //   MySliderAdvance(Modifier.padding(innerPadding))
                 //   MyRangeSlider(Modifier.padding(innerPadding))
                  //  MyDropDownItem(Modifier.padding(innerPadding))
               //     MyDropDownMenu(Modifier.padding(innerPadding))
                    MyExposedDropdownMenu(Modifier.padding(innerPadding))








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
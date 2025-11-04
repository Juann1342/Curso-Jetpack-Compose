package com.juan.myfirstcomposeapp.component

import android.widget.CheckBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.juan.myfirstcomposeapp.R
import com.juan.myfirstcomposeapp.component.state.CheckBoxState

@Composable
fun MySwitch(padding: Modifier) {
    var switchState by remember { mutableStateOf(true) } //para guardar el estado del switch
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it }, //le asigno el valor al estado
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_personita),
                    contentDescription = ""
                )
            }, //recibe una funcion lambda composable, carga el composable dentro de la palanquita del switch
            enabled = true, //por defecto es true, en false lo deshabilita
            //manejo los colores, de similar manera se hace para los demás composables
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Green,
                checkedIconColor = Color.Cyan,
                uncheckedIconColor = Color.Green,
                disabledCheckedIconColor = Color.White,
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Black
            )
        )

    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(true) } //para guardar el estado del checkBox
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }) {

            Checkbox(
                checked = state, onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Magenta,
                    disabledCheckedColor = Color.DarkGray,
                    disabledUncheckedColor = Color.Black,
                    checkmarkColor = Color.Magenta
                )
            )
            Spacer(Modifier.width(12.dp))
            Text("Acepto los terminos y condiciones")
        }

    }
}

//checkBox avanzado

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state: List<CheckBoxState> by remember {
        mutableStateOf(
            listOf( //acá creamos los checkbox
                CheckBoxState("terms", "Aceptar los términos y condiciones"),
                CheckBoxState("newsletter", "Recibir las newsletter", true),
                CheckBoxState("updates", "Recibir las actualizaciones")

            )
        )
    }
    //acá recorro todos los estados
    Column(modifier = Modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map{ //recorre todos los checkboxState y los devuelve
                    if(it.id == myState.id){//si estoy  en el estado que quiero modificar
                        myState.copy(checked = !myState.checked) //modificamos
                    }else{ //si no es lo dejamos igual
                        it
                    }
                }
            }
        }
    }

}

//para este creamos una clase llamada CheckBoxState, está en la carpeta state, luego se la pasamos por parametro
//tambiel le pasamos una funcion lambda que cuando es llamada tiene que devolver un checkboxstate
//dejo el checkbox lo mas minimalista posible, luego el resto lo gestiono en el padre
@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) }) {

        Checkbox(
            checked = checkBoxState.checked, onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,

            )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }

}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState: ToggleableState by remember {mutableStateOf(ToggleableState(false))  }
    var child1: Boolean by remember { mutableStateOf(false) }
    var child2: Boolean by remember { mutableStateOf(false) }


    //cuando child1 o child2 se modifique vamos a lanzar un bloque de codigo, esto es habitual en compose

    LaunchedEffect (child1,child2) {
        parentState = when{
            child1 && child2 -> ToggleableState.On //si los dos son true
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column (modifier = modifier){
        Row(verticalAlignment = Alignment.CenterVertically){
            //el estado lo gestionamos a traves de sus hijos, si todos sus hijos son true es true, si todos son false es false, si uno es true y otros false es indeterminado
            TriStateCheckbox(parentState, onClick = {
                val newState: Boolean = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text("Seleccionar todo")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)){
            Checkbox(child1, onCheckedChange = {child1=it})
            Text("Ejemplo 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)){
            Checkbox(child2, onCheckedChange = {child2=it})
            Text("Ejemplo 2")
        }
    }
    
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    Row(modifier = modifier,verticalAlignment = Alignment.CenterVertically) {
    RadioButton(
        selected = state,
        onClick = {state = true}, //en onclick no hay it
        enabled = true,
        colors = RadioButtonDefaults.colors(selectedColor = Color.Green, unselectedColor = Color.Red, disabledSelectedColor = Color.DarkGray, disabledUnselectedColor = Color.Cyan)

    )
        Text("Ejemplo 1")
    }
    
}

//avanzado
@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName: String by remember {mutableStateOf("")}
    Column(modifier=modifier) {
        RadioButtonComponent("Juan", selectedName=selectedName) { selectedName=it }
        RadioButtonComponent("Pepe", selectedName=selectedName) { selectedName=it }
        RadioButtonComponent("David", selectedName=selectedName) { selectedName=it }
        RadioButtonComponent("Maria", selectedName=selectedName) { selectedName=it }
        RadioButtonComponent("Julieta", selectedName=selectedName) { selectedName=it }



    }
    
}

@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == selectedName, onClick = {onItemSelected(name)})//si el nombre que recibo por parametro es igual al seleccionado, significa que este es el seleccionado
        Text(name, modifier = Modifier.clickable {onItemSelected(name)})

    }
    
}
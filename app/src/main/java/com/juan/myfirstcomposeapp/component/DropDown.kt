package com.juan.myfirstcomposeapp.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.juan.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }
    //expanded y edpandedChange obligatorios
    ExposedDropdownMenuBox(modifier=modifier,expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text("Idioma") },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)}
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("opción 1") }, onClick = {
                selection = "opción 1"
                expanded = false
            })
            DropdownMenuItem(text = { Text("opción 2") }, onClick = {
                selection = "opción 2"
                expanded = false
            })
            DropdownMenuItem(text = { Text("opción 3") }, onClick = {
                selection = "opción 3"
                expanded = false
            })
            DropdownMenuItem(text = { Text("opción 4") }, onClick = {
                selection = "opción 4"
                expanded = false
            })
        }
    }

}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        Button(onClick = { expanded = true }) {
            Text("Ver opciones")
        }
        //onDismissRequest, es la funcion que se llama cuando se pulsa fuera, cuando se da el botón atrás o cualquier acción que deba cerrar el dropdown
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(30.dp, 80.dp), //corre el menu para donde quiera
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = true,
                dismissOnBackPress = false,
            ) //focusable lanza el evento de foco cuando se abre, dismissOnClickOutside es para que no se cierre al clickear afuera, dismissOnBackPress que no se cierre al hacer atras

        ) {
            DropdownMenuItem(
                text = { Text("opción 1") },
                onClick = {
                    expanded = false
                })//el onclick lo que normalmente haría es hacer una función y además poner el expanded a false para que se cierre
            DropdownMenuItem(text = { Text("opción 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("opción 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("opción 4") }, onClick = { expanded = false })
        }

    }
}

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = {
                Text("Ejemplo1")
                //es obligatorio el onclick
            },
            leadingIcon = { //icono de inicio
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon( //icono al final
                    painter = painterResource(R.drawable.ic_personita),
                    contentDescription = ""
                )
            },
            enabled = true,
            contentPadding = PaddingValues(
                start = 30.dp,
                end = 50.dp
            ), //nos permite poner los padding
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Green,
                disabledTextColor = Color.DarkGray,
                disabledLeadingIconColor = Color.DarkGray
            ),
            onClick = {})
    }

}
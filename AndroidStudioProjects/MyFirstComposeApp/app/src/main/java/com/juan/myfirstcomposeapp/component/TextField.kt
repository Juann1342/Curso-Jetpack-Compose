package com.juan.myfirstcomposeapp.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/*
@Composable
fun MyTextField(modifier: Modifier){ //la manera mas basica de generar un textfield
    Column(modifier=modifier) {
        var text by remember { mutableStateOf("") } //representa el contenido, le agrego remember para que no se resetee cada vez que cambia onValueChange
        TextField(text, onValueChange = {text =it}) //con la funcion lambda voy modificando la variable
    }
}*/


//manera optimizada, si no utilizamos view models mvm, esta es la manera más efectiva
@Composable
fun MyTextFieldParent(modifier: Modifier) { //acá puedo llamar a todos los textfield, es util para cuando hay varios
    var user by remember { mutableStateOf("Juan") }
    var value by remember { mutableStateOf("") }


    Column(modifier = modifier) {
        MyTextField(user = user) { user = it }
        MySecondTextField(value = value) { value = it }
        MyAdvancedTextField(value = value) { value = it }
        MyPasswordTextField(value = value) { value = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(value = value) { value = it }



    }
}

@Composable
fun MyTextField(
    user: String,
    onUserChange: (String) -> Unit
) { //siemre recibie dos paramtros, el valor y la funcion lambda, esta ultima va a modificar el valor en el padre
    TextField(
        user,
        onValueChange = { onUserChange(it) },
        readOnly = true
    ) //le paso el valor actual (it) al padre a travez de la funciom lambda
    //readOnly es para que no se pueda modificar, con eso puedo ir jugando. por ejemplo puedo poner readOnly = user.isEmppty() cuando el usuario esté vacío no me va a dejar escribir

}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text("pepe@...")
        },
        label = { Text("Introduce tu email") })//los placeholder reciben composables, estos van entre llaves, label es otro composable
    //no comviene utilizar ambos, siempre se elige o label o placeholder
}

//avanzado
@Composable
fun MyAdvancedTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value,
        onValueChange = { //cuando tengo una funcion lamda puedo ir jugando con lo que necesite o quiera hacer
            if (it.contains("a")) {
                onValueChange(it.replace("a", " "))//si contiene una a la remplazo por vacio
            } else {
                onValueChange(it)
            }
        })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden: Boolean by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password), //puedo elegir el tipo de teclado que necesito, es importante elegir este para la contraseña, para que no la recuerde
        visualTransformation = if(passwordHidden) PasswordVisualTransformation() else VisualTransformation.None, //si es tru ocultamos, sino no
        trailingIcon = { //en el icono lo normal es poner una imagem, pero esta vez será un texto
            Text(text = if(passwordHidden) "Mostrar" else "Ocultar", modifier = Modifier.clickable{passwordHidden = !passwordHidden} )
        }
        )
}
@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit){
    OutlinedTextField(value = value, onValueChange = {onValueChange(it)})

  //  BasicTextField(value = value, onValueChange = {onValueChange(it)}) //el mas basico de todos, si necesito modificar mucho elegir este

}


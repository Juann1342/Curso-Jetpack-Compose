package com.juan.myfirstcomposeapp.component.state

//una data class es basicamente para almacenar variables
data class CheckBoxState (
    val id:String,
    val label: String,
    val checked: Boolean = false

)
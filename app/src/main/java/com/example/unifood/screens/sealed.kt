package com.example.unifood.screens

sealed class Screen(val route :String) {
    object MainScreen:Screen("main_screen")
    object EmailForgot:Screen("emailForgot_screen")


}
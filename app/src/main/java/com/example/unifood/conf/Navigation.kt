package com.example.unifood.conf

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unifood.screens.Forget_Password.email_forgot
import com.example.unifood.screens.Screen
import com.example.unifood.screens.auth.login
import com.example.unifood.screens.home_page

@Composable
fun Navigation (){
     val navController=rememberNavController()
     NavHost(navController=navController, startDestination = Screen.MainScreen.route   ){
          composable(route=Screen.MainScreen.route){
               home_page(navController = navController)
          }
          composable(route=Screen.EmailForgot.route){
               login();
          }

     }

}
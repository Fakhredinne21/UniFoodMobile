package com.example.unifood.conf

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.unifood.R
import com.example.unifood.model.User
import com.example.unifood.screens.Forget_Password.email_forgot
import com.example.unifood.screens.Screen
import com.example.unifood.screens.auth.login
import com.example.unifood.screens.dashboard.navItem
import com.example.unifood.screens.dashboard.dash
import com.example.unifood.screens.home_page

@Composable
fun Navigation (mealRepository: MealRepository, userRepository: UserRepository){
     val navController=rememberNavController()

          NavHost(navController=navController, startDestination = Screen.MainScreen.route){

               composable(route=Screen.MainScreen.route){
                    home_page(navController = navController, mealRepository, userRepository)
               }
               composable(route=Screen.EmailForgot.route){
                    login();
               }
               composable(route=Screen.Dash.route){
                    dash(navController= navController,mealRepository);
               }


          }




}
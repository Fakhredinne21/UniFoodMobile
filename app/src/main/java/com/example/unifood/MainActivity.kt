package com.example.unifood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.unifood.conf.Api
import com.example.unifood.conf.MealRepository
import com.example.unifood.conf.Navigation
import com.example.unifood.conf.UserRepository
import com.example.unifood.model.Meal
import com.example.unifood.model.User
import com.example.unifood.screens.dashboard.home
import com.example.unifood.ui.theme.UniFoodTheme
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class MainActivity : ComponentActivity() {
  private val mealRepository = MealRepository()
    private val userRepository = UserRepository()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            UniFoodTheme {
                //home_test(mealRepository )
                Navigation(mealRepository  , userRepository)



            }
        }
    }



}



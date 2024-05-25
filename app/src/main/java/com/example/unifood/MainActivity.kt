package com.example.unifood

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.unifood.components.imagesSilder
import com.example.unifood.conf.MealsRepositoryImpl
import com.example.unifood.conf.Navigation
import com.example.unifood.conf.RetrofitInstance
import com.example.unifood.model.Meal
import com.example.unifood.screens.dashboard.meals
import com.example.unifood.ui.theme.UniFoodTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<meals>(factoryProducer = {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return meals(MealsRepositoryImpl(RetrofitInstance.api)) as T
            }
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniFoodTheme {

                // Navigation()
                val meals = viewModel.meals.collectAsState().value
                val context= LocalContext.current
                LaunchedEffect(key1 = viewModel.showErrorToastChannel) {
                    viewModel.showErrorToastChannel.collectLatest {
                        show->
                        if (show) {
                            Toast.makeText(context, "Error occurred", Toast.LENGTH_SHORT).show()
                        }
                            // Show a toast
                    }
                    // Do something with the meals
                }
                if(meals.isNotEmpty()){
                    LazyColumn (
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        contentPadding = PaddingValues(16.dp)
                    ){
                        items(meals.size) { index ->
                            MealShows(meals[index])
                        }
                    }
                }
                else{
                    // Show a loading indicator
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }
}
@Composable
fun MealShows(meal: Meal) {
   Column {
       Text(text = meal.mealId)
       Text(text = meal.description)
       Text(text = meal.price)
   }
}


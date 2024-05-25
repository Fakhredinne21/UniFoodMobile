package com.example.unifood.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.unifood.viewmodel.MealviewModel
import java.lang.reflect.Modifier


@Composable
fun home(
    viewModel: MealviewModel= MealviewModel()

) {
    val value by remember{ viewModel.repositories }
    LaunchedEffect (key1 = Unit){
        viewModel.getMeals()
    }
    Box(
        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            LazyColumn() {
                items(value.Meals) { meal ->
                    Row() {
                        Text(
                            meal.mealId,
                            modifier = androidx.compose.ui.Modifier.padding(horizontal = 10.dp)
                        )
                        Text(
                            meal.description,
                            modifier = androidx.compose.ui.Modifier.padding(horizontal = 10.dp)
                        )
                        Text(
                            meal.price,
                            modifier = androidx.compose.ui.Modifier.padding(horizontal = 10.dp)
                        )
                    }

                }
            }

        }
    }
}

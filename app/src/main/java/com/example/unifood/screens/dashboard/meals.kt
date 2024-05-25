package com.example.unifood.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unifood.conf.MealsRepository
import com.example.unifood.model.Meal
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class meals(private val mealRepository:MealsRepository): ViewModel (){
    private val _meals= MutableStateFlow<List<Meal>>(emptyList())
    val meals = _meals.asStateFlow()
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()
   init {
       viewModelScope.launch{
           mealRepository.getMeals().collect { result ->
               when (result) {
                   is com.example.unifood.conf.Result.Failure ->{
                       _showErrorToastChannel.send(true)
                   }
                   is com.example.unifood.conf.Result.Success ->{
                       result.data?.let {
                               meals->
                           _meals.value = meals
                       }
                   }
               }
           }
       }
   }

}
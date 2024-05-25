package com.example.unifood.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.unifood.model.MealRepositories
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.serialization.json.Json

class MealviewModel:ViewModel() {
   val _repositories:MutableState<MealRepositories> = mutableStateOf(
       MealRepositories(
           Meals = listOf()
        )
   )
    val repositories: MutableState <MealRepositories> = _repositories
    fun getMeals(){
        val url="http://192.168.1.12:8080/Meals"
        val header: HashMap<String, String> = hashMapOf()
        Fuel.get(url).header(header).responseJson { request, response, result ->
            Log.d("DEBUG", result.get().obj().toString())
            when(result){
                is Result.Success -> {
                    val tmp = Json.decodeFromString<MealRepositories>(result.get().obj().toString())
                     var tmpe = MealRepositories(Meals = listOf())
                    _repositories.value = tmp


                }
                is Result.Failure -> TODO()
            }

//
        }
    }
}
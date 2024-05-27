package com.example.unifood.conf

import androidx.compose.runtime.mutableStateOf
import com.example.unifood.model.Meal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealRepository {

     val meals = mutableStateOf<List<Meal>>(listOf())
    fun getMeals(): List<Meal>{
        dbMeals()
        return meals.value
    }
     fun dbMeals() {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitBuilder= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            val retrofitData=retrofitBuilder.getMeals()
            retrofitData.enqueue(
                object : retrofit2.Callback<List<Meal>> {

                    override fun onResponse(call: Call<List<Meal>>, response: Response<List<Meal>>) {
                        if (response.isSuccessful) {
                            val data = response.body()
                            if (data != null) {
                                meals.value = data

                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Meal>>, t: Throwable) {
                        println("Error: ${t.message}")
                        t.printStackTrace()
                    }
                }
            )
        }
    }
}
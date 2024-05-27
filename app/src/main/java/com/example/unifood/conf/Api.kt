package com.example.unifood.conf

import com.example.unifood.model.Meal
import com.example.unifood.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("Meals")//end point
     fun getMeals(): Call<List<Meal>>
    @GET("Tickets/count/1")
    fun getTickets(): Call<Integer>
    @POST("users/create")
    fun createUser(@Body user: User): Call<User>
    @POST("users/login")
    fun loginUser(@Body user: User): Call<User>

}
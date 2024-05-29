package com.example.unifood.conf

import com.example.unifood.model.Meal
import com.example.unifood.model.Ticket
import com.example.unifood.model.TicketRequest
import com.example.unifood.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("Meals")//end point
     fun getMeals(): Call<List<Meal>>
    @POST("Tickets/count/")
    fun getTickets(@Body user: User): Call<Int>
    @POST("users/create")
    fun createUser(@Body user: User): Call<User>
    @POST("users/login")
    fun loginUser(@Body user: User): Call<User>
    @POST("users/user")
    fun getUser(@Body user: User): Call<User>
    @POST("Tickets/add")
    fun addTicket(@Body ticketRequest: TicketRequest): Call<Ticket>
    @POST("Tickets/user")
    fun getTicket(@Body user: User): Call<List<Ticket>>

}
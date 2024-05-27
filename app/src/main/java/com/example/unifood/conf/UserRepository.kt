package com.example.unifood.conf

import com.example.unifood.model.Meal
import com.example.unifood.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.HttpException

class UserRepository {
    suspend fun loginUser(email: String, password: String): Result<User?> {
        return withContext(Dispatchers.IO) {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            val user = User("", "", "", email, password)
            try {
                val response = retrofitBuilder.loginUser(user).execute()
                if (response.isSuccessful) {
                    Result.success(response.body())
                } else {
                    Result.failure(RuntimeException("Response: ${response.errorBody()}"))
                }
            } catch (e: HttpException) {
                Result.failure(e)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
    suspend fun createUser(firstname: String, email: String, password: String): Result<User?> {
        return withContext(Dispatchers.IO) {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            val user = User("",firstname,"", email, password)
            try {
                val response = retrofitBuilder.createUser(user).execute()
                if (response.isSuccessful) {
                    Result.success(response.body())
                } else {
                    Result.failure(RuntimeException("Response: ${response.errorBody()}"))
                }
            } catch (e: HttpException) {
                Result.failure(e)
            } catch (e: Throwable) {
                Result.failure(e)
            }
        }
    }
    fun getTicket() {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            val retrofitData = retrofitBuilder.getTickets()
            retrofitData.enqueue(
                object : retrofit2.Callback<Integer> {
                    override fun onResponse(call: Call<Integer>, response: Response<Integer>) {
                        if (response.isSuccessful) {
                            val tickets = response.body()
                            // Process the tickets data here
                            println("Tickets: $tickets")
                        } else {
                            println("Error: ${response.errorBody()}")
                        }
                    }

                    override fun onFailure(call: Call<Integer>, t: Throwable) {
                        println("Error: ${t.message}")
                    }
                }
            )
        }
    }
}
package com.example.unifood.conf

import com.example.unifood.model.Ticket
import com.example.unifood.model.TicketRequest
import com.example.unifood.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
    suspend fun getUser(user: User): Result<User?> {
        return withContext(Dispatchers.IO) {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            try {
                val response = retrofitBuilder.getUser(user).execute()
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
    suspend fun getTickets(user: User): Result<Int?> {
        return withContext(Dispatchers.IO) {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            try {
                val response = retrofitBuilder.getTickets(user).execute()
                if (response.isSuccessful) {
                    Result.success(response.body() ?: 0)
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

    suspend fun buyTickets(numbt: Int, user: User): Result<Ticket?> {
        return withContext(Dispatchers.IO) {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)

            val ticketRequest = TicketRequest(numbt, user)
            println(ticketRequest)
            try {

                val response = retrofitBuilder.addTicket(ticketRequest).execute()
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
        }}
    suspend fun getTicket(user: User): Result<List<Ticket>?> {
        return withContext(Dispatchers.IO) {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()
                .create(Api::class.java)
            try {
                val response = retrofitBuilder.getTicket(user).execute()
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
        }}

}
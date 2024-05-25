package com.example.unifood.conf

import com.example.unifood.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MealsRepositoryImpl
    (
    private val api: Api
            ):MealsRepository
{
    override suspend fun getMeals(): Flow<Result<List<Meal>>> {
        return flow {
            try {
                val response = api.getMeals()
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Failure(e.message ?: "Error occurred"))
            }


        }

    }

}
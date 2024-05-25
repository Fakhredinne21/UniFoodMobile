package com.example.unifood.conf

import com.example.unifood.model.Meal

interface MealsRepository {
suspend fun getMeals(): kotlinx.coroutines.flow.Flow<Result<List<Meal>>>






}
package com.example.unifood.model

import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    var mealId:String="",
    var description:String="",
    var price:String="",

)

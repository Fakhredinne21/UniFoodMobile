package com.example.unifood.model

import kotlinx.serialization.Serializable

@Serializable
data class Ticket (
    var mealId:String="",
    var description:String="",
    var price:String="",
)
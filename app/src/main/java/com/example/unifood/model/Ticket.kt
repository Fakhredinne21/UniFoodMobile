package com.example.unifood.model

import kotlinx.serialization.Serializable

@Serializable
data class Ticket (
    var id:Long,
    var price:Int,
    var state:Boolean,
    var number:Int,
    var Date:String,
)
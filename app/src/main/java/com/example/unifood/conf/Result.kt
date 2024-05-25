package com.example.unifood.conf

sealed class Result <T>(
    val data:T?=null,
    val error:String?=null
){
class Success<T>(data: T):Result<T>(data)
class Failure<T>(error: String):Result<T>(error = error)


}
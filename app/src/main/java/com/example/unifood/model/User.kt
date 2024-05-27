package com.example.unifood.model

import kotlinx.serialization.Serializable
@Serializable
enum class Role {
    Student
}
@Serializable
data class User (
    var userId: String = "",
    var firstName: String = "",
    var last_name: String = "",
    var email: String = "",
    var password: String = "",
    var role: Role = Role.Student,

    var isSubscribed: Boolean = false,
    var profileImage: ByteArray? = null
)



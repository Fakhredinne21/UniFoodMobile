package com.example.unifood.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.unifood.screens.dashboard.dash

@Composable
fun login(){

    Column(
        modifier = Modifier.fillMaxWidth().height(250.dp).background(color = Color.Green)


    ) {
        Text(text = "Login page")

    }
}
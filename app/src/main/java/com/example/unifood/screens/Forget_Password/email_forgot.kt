package com.example.unifood.screens.Forget_Password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import com.example.unifood.components.emailTextField
import com.example.unifood.components.sub_btn

@Composable
fun email_forgot(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        horizontalAlignment =Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Forget Password",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Left

        )

        Text(text = "Enter your registered email below",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(5.dp),
            color = colorResource(id = R.color.small_text)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Email address",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Left

        )
        emailTextField()
        Text(text = "Remember the password?",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            color = colorResource(id = R.color.small_text),
            modifier = Modifier.padding(5.dp),
        )
        sub_btn(text_in = "Submit")





    }
}
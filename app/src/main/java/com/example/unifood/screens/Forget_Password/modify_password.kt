package com.example.unifood.screens.Forget_Password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import com.example.unifood.components.emailTextField
import com.example.unifood.components.sub_btn

@Composable
fun modify_password(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        horizontalAlignment =Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Change New Password",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Left

        )


        Text(text = "Enter a different password with the previous",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(5.dp),
            color = colorResource(id = R.color.small_text)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "New Password",
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Left

        )
        emailTextField()
        Text(text = "Confirm Password",
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Left

        )
        emailTextField()

        sub_btn(text_in = "Reset Password")



    }
}
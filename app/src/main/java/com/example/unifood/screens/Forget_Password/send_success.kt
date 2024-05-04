package com.example.unifood.screens.Forget_Password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import com.example.unifood.components.sub_btn

@Composable
fun send_success(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(painter = painterResource(id = R.drawable.success_image),
            contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)


        )
        Text(text = "Success",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            )
        Text(text = "Please check your email for create \n" +
                "a new password",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp),
            color = colorResource(id = R.color.small_text)
        )
        Spacer(modifier = Modifier.height(100.dp))
        sub_btn(text_in = "Go Back")

    }
}
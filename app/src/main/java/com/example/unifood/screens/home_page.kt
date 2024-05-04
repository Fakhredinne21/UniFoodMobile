package com.example.unifood.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.unifood.R
import com.example.unifood.components.sub_btn

@Composable
fun home_page(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(painter = painterResource(id = R.drawable.welcome_image),
            contentDescription ="",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(5.dp)

        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Welcome",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp)


        )

        Text(text = "Farabi restaurant is Welcoming You \n  To Fill your stomach",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(100.dp))
        sub_btn(text_in = "Create Account")
        Button(onClick = { /*TODO*/

            navController.navigate(Screen.EmailForgot.route)
                         }

            ,
            shape = RoundedCornerShape(10.dp),
            colors= ButtonDefaults.buttonColors(colorResource(id = R.color.login_color)),
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .padding(5.dp)

        ) {
            Text(text = "Login",
                color = Color(0xFF10B981),

                )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "By logging in or registering, you have agreed to the Terms and Conditions and Privacy Policy.",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
            , fontSize = 12.sp
        )

    }
}
package com.example.unifood.screens.dashboard


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import com.example.unifood.model.User

@Composable
fun profile(user : User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEEEEE))
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .clip(CircleShape)
                .background(Color(0xFFEEEEEE))
                .padding(5.dp)




            ) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.profilegreen),
                contentDescription = "Profile Picture",
                tint = Color(0xff206B00),
                modifier = Modifier
                    .fillMaxSize()


            )
        }


        Spacer(modifier = Modifier.height(32.dp))
        Box(


            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(Color(0xFFFFFFFF))
                .padding(5.dp)



        ) {


                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,


                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.profile),
                        contentDescription = "Email",
                        tint = Color(0xff206B00),
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = " ${user.firstName}",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,

                    )

                }









        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(


            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(Color(0xFFFFFFFF))
                .padding(5.dp)



        ) {


            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.email),
                    contentDescription = "Email",
                    tint = Color(0xff206B00),
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = " ${user.email}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,

                    )

            }









        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(


            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(Color(0xFFFFFFFF))
                .padding(5.dp)



        ) {


            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.role),
                    contentDescription = "Role",
                    tint = Color(0xff206B00),
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = " ${user.role}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,

                    )

            }









        }

        Spacer(modifier = Modifier.size(16.dp))


        Button(onClick = { /*TODO*/



        }

            ,
            shape = RoundedCornerShape(10.dp),
            colors= ButtonDefaults.buttonColors(colorResource(id = R.color.logout_color)),
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .padding(5.dp)

        ) {
            Text(text = "Logout",
                color = Color.White,

                )

        }
    }
}

package com.example.unifood.screens.dashboard

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import com.example.unifood.components.imagesSilder

@Composable
fun home_test(){

    Column (modifier = Modifier

        .fillMaxSize()
        .background(Color(0xFFEEEEEE))
        .padding(15.dp)){
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Today's Plate",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(2f), // Make first text take up 2/3 of the space
                        color = Color.Black
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.wallet),
                        contentDescription = "",
                        tint=Color.Black
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
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



                ){

                }
        Text(
            text = "Your Transactions",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp),
            color = Color(0xFF151515)

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
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


        ){
            Row(modifier = Modifier.padding(3.dp)) {
                Text(
                    text = "Send \n Apr 20 2024, 04:20PM",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color=Color(0xFF6B7280),
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f) // Make first text take up 2/3 of the space
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.wallet),
                    contentDescription = "",
                    tint=Color(0xFF32B768)
                )

            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        imagesSilder()



















            }




}
package com.example.unifood.screens.dashboard

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.unifood.R
import com.example.unifood.components.imagesSilder
import com.example.unifood.components.textToQRCode
import com.example.unifood.conf.MealRepository
import com.example.unifood.model.Meal

@Composable
fun home_test(mealRepository: MealRepository){
    var meals =mealRepository.getMeals()
    var showDialog by remember { mutableStateOf(false) }
    var selectedMeal by remember { mutableStateOf(Meal()) }
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
                    meals.forEach { meal ->
                       // Text(text = meal.toString())
                        val qrCodeBitmap =textToQRCode(meal.toString(),200,200)// Replace `meal.toString()` with the actual properties you want to display
                        Image(
                            painter = BitmapPainter(qrCodeBitmap.asImageBitmap()),
                            contentDescription = "QR Code for meal ${meal.mealId}",
                            modifier = Modifier.clickable {
                                 selectedMeal = meal
                                 showDialog = true
                            }
                        )
                        if (showDialog) {
                            Dialog(onDismissRequest = { showDialog = false }) {
                                Box(modifier = Modifier.fillMaxSize()) { // Set the size of the dialog here
                                    val qrCodeBitmap = textToQRCode(selectedMeal.toString(),300,300)
                                    Image(
                                        modifier = Modifier.fillMaxSize(),
                                        painter = BitmapPainter(qrCodeBitmap.asImageBitmap()),
                                        contentDescription = "QR Code for meal ${selectedMeal.mealId}"
                                    )
                                }
                            }
                        }
                    }



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
package com.example.unifood.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import com.example.unifood.conf.MealRepository
import com.example.unifood.conf.UserRepository
import com.example.unifood.model.Meal
import com.example.unifood.model.User

@Composable
fun home(mealRepository: MealRepository, user: User, userRepository: UserRepository){
    var tickets by remember { mutableStateOf<Result<Int?>>(Result.success(null)) }
    var meals =mealRepository.getMeals()

    var selectedMeal by remember { mutableStateOf(Meal()) }
    LaunchedEffect(user) {
        tickets = userRepository.getTickets(user)
    }
    Column (modifier = Modifier

        .fillMaxSize()
        .background(Color(0xFFEEEEEE))
        .padding(15.dp)){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) ){
            Text(
                text = "Today's Plate",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .weight(2f), // Make first text take up 2/3 of the space
                color = Color.Black ,
                onTextLayout = {}
            )
            Spacer(modifier = Modifier.weight(1f)) // Add a spacer to take up the remaining space
            Text(text = "${tickets.getOrNull() ?: "0"}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(5.dp),
                // Make first text take up 2/3 of the space
                color = Color.Black,
                onTextLayout = {}
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



                ) {


                    val lastMeal = meals.lastOrNull()
                    if (lastMeal != null) {
                        Text(text = lastMeal.description,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp),
                            color = Color(0xFF151515),
                            onTextLayout = {}
                        )
                    } else {
                        // Handle the case when the meals list is empty
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




















            }




}
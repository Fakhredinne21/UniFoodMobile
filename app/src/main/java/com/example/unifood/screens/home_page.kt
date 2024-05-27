package com.example.unifood.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.unifood.components.emailTextField
import com.example.unifood.components.sub_btn
import com.example.unifood.conf.MealRepository
import com.example.unifood.conf.UserRepository
import com.example.unifood.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home_page(navController: NavController,mealRepository: MealRepository,UserRepository: UserRepository){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(5.dp)

        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Welcome",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp)


        )

        Text(
            text = "Farabi restaurant is Welcoming You \n  To Fill your stomach",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(100.dp))
        val sheetState = rememberModalBottomSheetState();
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        var loginState= rememberModalBottomSheetState();
        var isLoginSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.register_color)),
            enabled = true,
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .padding(5.dp),

            onClick = { /*TODO*/
                isSheetOpen = true
            }) {
            Text(text = "Create Account")

        }
        if (isSheetOpen) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { /*TODO*/
                    isSheetOpen = false
                }) {
                Column(
                    modifier = Modifier
                        .padding(30.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    var fullName by remember { mutableStateOf("") }
                    var emailAddress by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    Text(
                        text = "Full Name",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left
                    )
                    TextField(value = fullName, onValueChange = { fullName = it },
                            modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        placeholder={
                            Text(text = "Eg namaemail@emailkamu.com")
                            colorResource(id = R.color.small_text)
                        }
                    )

                    Text(
                        text = "Email address",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left
                    )
                    TextField(value = emailAddress, onValueChange = { emailAddress = it },
                        modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            placeholder={
                                Text(text = "Eg namaemail@emailkamu.com")
                                colorResource(id = R.color.small_text)
                            }
                        )
                    Text(
                        text = "Password ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left
                    )
                    TextField(value = password, onValueChange = { password = it },
                            modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        placeholder={
                            Text(text = "Eg namaemail@emailkamu.com")
                            colorResource(id = R.color.small_text)
                        }
                    )



                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                UserRepository.createUser(fullName, emailAddress, password)
                            }


                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.register_color)),
                        enabled = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(5.dp)
                    ) {
                        Text(text = "Register")
                    }
                }
            }




    }
        Button(onClick = { /*TODO*/


            isLoginSheetOpen = true
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
        if(isLoginSheetOpen){
            ModalBottomSheet(
                sheetState = loginState,
                onDismissRequest = { /*TODO*/
                    isLoginSheetOpen = false
                }) {
                Column(
                    modifier = Modifier
                        .padding(30.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    var emailAddress by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    Text(
                        text = "Email address",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left
                    )
                    TextField(value = emailAddress, onValueChange = { emailAddress = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(
                                text = "Eg"
                            )
                        }
                    )
                    Text(
                        text = "Password ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left
                    )
                    TextField(value = password, onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(text = "Eg namaemail@emailkamu.com")
                            colorResource(id = R.color.small_text)
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            CoroutineScope(Dispatchers.IO).launch {

                                 var user =UserRepository.loginUser(emailAddress, password)
                                if(user.isSuccess){
                                    val USER= user.getOrThrow()!!
                                    if(USER.userId != null){
                                        println(USER.toString())
                                    }

                                }
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.register_color)),
                        enabled = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(5.dp)
                    ) {
                        Text(text = "Login")
                    }
                }
            }
        }




        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "By logging in or registering, you have agreed to the Terms and Conditions and Privacy Policy.",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
            , fontSize = 12.sp
        )
    }

}
package com.example.unifood.screens.dashboard
import androidx.compose.foundation.Image
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.unifood.R
import com.example.unifood.components.textToQRCode
import com.example.unifood.conf.UserRepository
import com.example.unifood.model.Ticket
import com.example.unifood.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun wallet (user: User,userRepository: UserRepository) {
    var showDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var tickets by remember { mutableStateOf<Result<Int?>>(Result.success(null)) }
    var ticket by remember { mutableStateOf<Result<List<Ticket>?>>(Result.success(null)) }
    LaunchedEffect(user) {
        tickets = userRepository.getTickets(user)
        ticket= userRepository.getTicket(user)
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEEEEE))
            .padding(15.dp)
    ) {
        Spacer(modifier = Modifier.size(150.dp))
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .clip(CircleShape)
                .background(Color(0xff32B768))
                .padding(5.dp)
                .align(Alignment.CenterHorizontally),



        ) {

            Text(
                text = "${tickets.getOrNull() ?: "0"}",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )




        }
        Spacer(modifier = Modifier.size(20.dp))
        val sheetState = rememberModalBottomSheetState();
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }

        Box(
            modifier = Modifier
                .height(120.dp)
                .width(300.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(Color(0xff999999))
                .padding(25.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { // Add this to make the box clickable
                    isSheetOpen = true
                }
        ) {
            Row() {
                Text(
                    text = "Buy",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f), // Make first text take up 2/3 of the space
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.tickets),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }

        // Show the bottom sheet when the box is clicked
        if (isSheetOpen) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { isSheetOpen = false }
            ) {
                // Content of the bottom sheet goes here
                Column(
                    modifier = Modifier
                        .padding(30.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    var ticketNumber by remember { mutableStateOf("") }


                    Text(
                        text = "Please give number of tickets you want to buy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left
                    )
                    var showAlert by remember { mutableStateOf(false) }
                    TextField(
                        value = ticketNumber,
                        onValueChange = {
                            ticketNumber = it

                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        placeholder = {
                            Text(text = "Number of tickets")
                            colorResource(id = R.color.small_text)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(

                        onClick = {

                            if (ticketNumber.toIntOrNull() in 1..5) {
                                coroutineScope.launch {
                                    // Buy the tickets
                                    userRepository.buyTickets( ticketNumber.toInt(),user)
                                    tickets = userRepository.getTickets(user)
                                }
                                // Buy the tickets

                                isSheetOpen = false
                            } else {
                                showAlert = true
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.register_color)),
                        modifier = Modifier
                            .width(300.dp)
                            .height(60.dp)
                            .padding(5.dp)
                    ) {
                        Text(text = "Buy")
                    }

                    // Show the alert when the number is not within the limit
                    if (showAlert) {
                        AlertDialog(
                            onDismissRequest = { showAlert = false },
                            title = { Text("Invalid number") },
                            text = { Text("Please enter a number between 1 and 5.") },
                            confirmButton = {
                                Button(onClick = { showAlert = false }) {
                                    Text("OK")
                                }
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        Box( modifier = Modifier
            .height(120.dp)
            .width(300.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )

            ).clickable { // Add this to make the box clickable
                showDialog = true
            }
            .background(Color(0xffEB4646))
            .padding(25.dp)
            .align(Alignment.CenterHorizontally)) {
            Row() {
                Text(
                    text = "Use",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp, color = Color.White,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f), // Make first text take up 2/3 of the space
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ticket),
                    contentDescription = "",
                    tint = Color.White
                )



            }

        }


            if (showDialog) {
                Dialog(onDismissRequest = { showDialog = false }) {
                    Box(modifier = Modifier.fillMaxSize()) { // Set the size of the dialog here
                        val qrCodeBitmap = textToQRCode(ticket.getOrNull()?.last().toString(),300,300)
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = BitmapPainter(qrCodeBitmap.asImageBitmap()),
                            contentDescription = "QR Code for ticket"
                        )
                    }
                }


        }

























    }

        /*  meals.forEach {
                              }*/

}
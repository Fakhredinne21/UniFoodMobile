package com.example.unifood.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifood.R
import kotlinx.coroutines.delay




@Composable
fun imagesSilder() {
    val sliders= listOf(
      SliderItem(
          title = "Scan",
          Image = ImageVector.vectorResource(id = R.drawable.scan),
          color = Color(0xff32B768)
      ),
              SliderItem(
              title = "Share",
                  Image = ImageVector.vectorResource(id = R.drawable.ticket)
                ,color = Color(0xffEB4646)

    ),
        SliderItem(
            title = "Buy",
            Image = ImageVector.vectorResource(id = R.drawable.tickets)
            ,color = Color(0xff999999)

        )

    )
    val currentIndex= remember {
        mutableStateOf(0)
    }
    LaunchedEffect(Unit) {
        while(true){
            delay(3000)
            currentIndex.value=(currentIndex.value+1)% sliders.size
        }
    }
    Column (modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment =Alignment.CenterHorizontally,


           ){
           Row(

           ){
               sliders.forEachIndexed{
                       ind,i->
                   Indicator(active = ind==currentIndex.value)
                   if(ind<sliders.size -1){

                   }
               }

           }
           Spacer(modifier = Modifier.height(20.dp))
           Row(
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
                   .background(sliders[currentIndex.value].color)
                   .padding(25.dp)
           ){
               Text(text =   sliders[currentIndex.value].title,
                   fontSize = 30.sp, color = Color.White,
                   modifier = Modifier
                       .padding(5.dp)
                       .weight(2f), // Make first text take up 2/3 of the space
               )

               if(currentIndex.value==0){
                   Image(imageVector = sliders[currentIndex.value].Image, contentDescription = "",
                       modifier = Modifier.fillMaxHeight() // Make image fill the Row's height

                   )
               }else{
                   Image(imageVector = sliders[currentIndex.value].Image, contentDescription = ""
                   )
               }
           }




   }
}

@Composable
fun Indicator(active:Boolean){
    var color=if(active) Color(0xff32B768) else Color(0xFFCCBEBE)
    val size=if(active) 10.dp else 10.dp
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size)
    ){

    }
}
data class SliderItem(
    val title:String,
    val Image:ImageVector,
    val color: Color

){

}


    


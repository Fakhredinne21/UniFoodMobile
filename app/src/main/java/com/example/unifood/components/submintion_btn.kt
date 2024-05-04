package com.example.unifood.components



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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.unifood.R

@Composable
fun sub_btn(text_in:String){
    Button(onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors= ButtonDefaults.buttonColors(colorResource(id = R.color.register_color)),
        modifier = Modifier
            .width(300.dp)
            .height(60.dp)
            .padding(5.dp)
    ) {
        Text(text = text_in)
    }
}

package com.example.unifood.screens

import android.provider.SyncStateContract.Columns
import android.view.Surface
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.unifood.R
import com.example.unifood.components.emailTextField
import com.example.unifood.components.sub_btn


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun   test() {

    Column {

    }
    val tabItems=listOf(
        TabItem(
            title = "Login",
            surface = Surface{
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                    horizontalAlignment =Alignment.Start,
                    verticalArrangement = Arrangement.Top

                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = "Change New Password",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left

                    )


                    Text(text = "Enter a different password with the previous",
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(5.dp),
                        color = colorResource(id = R.color.small_text)
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = "New Password",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left

                    )
                    emailTextField()
                    Text(text = "Confirm Password",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Left

                    )
                    emailTextField()

                    sub_btn(text_in = "Reset Password")



                }

            }
        ),
        TabItem(
            title = "Register",
            surface = Surface{


            }
        )



    )


    Surface {
        val sheetState= rememberModalBottomSheetState();
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        Button(onClick = { /*TODO*/
                isSheetOpen=true
        }) {
            Text(text = "Test sheet")

        }
        if(isSheetOpen){
            ModalBottomSheet(
                sheetState=sheetState,
                onDismissRequest = { /*TODO*/
                    isSheetOpen=false

                }) {
                Surface (
                    modifier=Modifier.fillMaxSize(),


                    ) {
                    var selectedTabIndex by remember {
                        mutableIntStateOf(0)
                    }
                    val pagerState = rememberPagerState {
                        tabItems.size
                    }
                    LaunchedEffect(selectedTabIndex) {
                        pagerState.animateScrollToPage(selectedTabIndex)
                    }
                    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
                        if (!pagerState.isScrollInProgress) {
                            selectedTabIndex = pagerState.currentPage
                        }

                    }
                    Column {
                        TabRow(
                            selectedTabIndex = selectedTabIndex,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE9E9E9))
                                .clip(RoundedCornerShape(size = 16.dp)),


                            ) {
                            tabItems.forEachIndexed { ind, item ->
                                Tab(
                                    selected = ind == selectedTabIndex,
                                    onClick = {
                                        selectedTabIndex = ind

                                    },
                                    text={
                                        Text(text=item.title, color = Color.Black)
                                    },
                                    )
                            }
                        }
                    }


                }
        }

        }
    }

}



data class TabItem(
    val title:String,
    val surface: Any

){
    
}

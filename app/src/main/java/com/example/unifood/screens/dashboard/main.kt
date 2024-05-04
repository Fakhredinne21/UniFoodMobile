package com.example.unifood.screens.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.unifood.R
import com.example.unifood.screens.Forget_Password.email_forgot
import com.example.unifood.screens.Forget_Password.modify_password
import com.example.unifood.screens.Forget_Password.modify_success
import com.example.unifood.screens.Forget_Password.send_success
import com.example.unifood.screens.Screen
import com.example.unifood.screens.home_page


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun dash(){
    val tabItems=listOf(
        TabItem(

            title = "",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.cameralogo),

            selectedIcon = ImageVector.vectorResource(id= R.drawable.cameralogo) ,
            destination = Screen.EmailForgot

        ),
        TabItem(
            title = "Home",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.home),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.greenhome),
            destination = Screen.EmailForgot,

        ),
        TabItem(
            title = "Wallet",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.wallet),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.walletgreen),
            destination = Screen.EmailForgot,

        ),
        TabItem(
            title = "Profile",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.profile),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.profilegreen),
            destination = Screen.EmailForgot,


        )
    )
    Surface (
        modifier=Modifier.fillMaxSize(),


    ){
        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }
        val pagerState= rememberPagerState {
            tabItems.size
        }
      LaunchedEffect(selectedTabIndex) {
          pagerState.animateScrollToPage(selectedTabIndex)
      }
        LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress) {
            if(!pagerState.isScrollInProgress){
                selectedTabIndex=pagerState.currentPage
            }

        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .background(color = Color(0xffE9E9E9)), verticalArrangement = Arrangement.SpaceBetween,




        ) {
            Spacer(modifier = Modifier.weight(1f)) // Placeholder for content above the tabs
            HorizontalPager(state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)


            ) {
                    index->
                Text(text = tabItems[index].title)

            }
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xffE9E9E9)) .clip(RoundedCornerShape(size = 16.dp)),


            ) {
                    tabItems.forEachIndexed{
                            ind,item->
                        Tab(
                            selected = ind==selectedTabIndex,
                            onClick = {
                                selectedTabIndex=ind


                            },
                            text={
                                Text(text=item.title, color = Color.Black)
                            },
                            icon={
                                Icon(imageVector =if(ind==selectedTabIndex){
                                    item.selectedIcon;

                                }else item.unselectedIcon
                                    , contentDescription =item.title)
                            },
                            selectedContentColor =  Color(0xff32B768) ,
                            unselectedContentColor = Color.Black
                        )

                    }
                }


        }



    }









}
data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val destination: Screen,



){

}
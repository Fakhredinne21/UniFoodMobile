package com.example.unifood.screens.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.colorResource
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


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun dash(navController: NavController){

    val navItems=listOf(
        navItem(

            title = "",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.cameralogo),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.cameralogo) ,
            hasNews = false,
            destination = Screen.MainScreen.route

        ),
        navItem(
            title = "Home",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.home),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.greenhome),
            hasNews = false,
            destination = Screen.MainScreen.route
        ),
        navItem(
            title = "Wallet",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.wallet),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.walletgreen),
            hasNews = false,
            badgeCount = 15,
            destination = Screen.MainScreen.route

        ),
        navItem(
            title = "Profile",
            unselectedIcon= ImageVector.vectorResource(id= R.drawable.profile),
            selectedIcon = ImageVector.vectorResource(id= R.drawable.profilegreen),
            hasNews = false,
            destination = Screen.MainScreen.route




        )
    )
    Surface (
        modifier=Modifier.fillMaxSize().background(Color.White)

    ){
        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }
        val pagerState= rememberPagerState {
            navItems.size
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
            .fillMaxHeight().background(Color.White)
            , verticalArrangement = Arrangement.SpaceBetween,

            ) {
            Scaffold (
                bottomBar = {
                    BottomAppBar (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .clip(RoundedCornerShape(size = 16.dp)),){

                        navItems.forEachIndexed{
                                ind,item->
                            NavigationBarItem(

                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color(0xff32B768),
                                    selectedTextColor = Color.Black,
                                    unselectedIconColor = Color.Black,
                                    unselectedTextColor = Color.Black ,
                                    indicatorColor = Color.White
                                ),

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White),
                                selected = ind==selectedTabIndex,
                                onClick = {
                                    selectedTabIndex=ind
                                          },
                                label={
                                    Text(text=item.title, color = Color.Black)
                                },
                                icon={

                                    BadgedBox(
                                        badge = {
                                            if(item.badgeCount!=null){
                                                Badge{
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            }else if(item.hasNews){
                                                Badge()
                                            }
                                        }

                                    ) {
                                        
                                    }
                                    Icon(imageVector =if(ind==selectedTabIndex){
                                        item.selectedIcon

                                    }else item.unselectedIcon
                                        , contentDescription =item.title)
                                
                                     },


                                )

                        }
                    }
                }
            )
            {
                when (selectedTabIndex) {
                    0 -> email_forgot() // Your home screen content (already exists)
                    // Create this for profile content
                    // Add more cases for other screens (if applicable)
                    1-> home_test ()
                    2->send_success()
                    3->modify_success()
                }


            }




        }



    }









}
data class navItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews:Boolean,
    val badgeCount:Int?=null,
    val destination:String




){

}
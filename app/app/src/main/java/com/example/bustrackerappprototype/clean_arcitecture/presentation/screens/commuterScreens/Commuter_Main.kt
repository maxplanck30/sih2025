package com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.commuterScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bustrackerappprototype.R
import com.example.bustrackerappprototype.ui.theme.NeutralDark
import com.example.bustrackerappprototype.ui.theme.NeutralLight
import com.example.bustrackerappprototype.ui.theme.Primary
import com.example.bustrackerappprototype.ui.theme.PrimaryDark
import com.example.bustrackerappprototype.ui.theme.TextOnPrimary


data class BottomBarData(
    val title : String,
    val img : Int
)

@Preview
@Composable
fun Commuter_MainScreen() {

    val bottomList = listOf<BottomBarData>(

        BottomBarData(
            title = "Track Bus",
            img = R.drawable.bus,
        ),
        BottomBarData(
            title = "Route",
            img = R.drawable.distance,
        ),
        BottomBarData(
            title = "Profile",
            img = R.drawable.usericon,
        ),


    )

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(1) }

    Scaffold(
        modifier = Modifier.background(color = NeutralLight)
            .padding(horizontal = 16.dp),
        bottomBar = {

            Box(Modifier
                .padding(all = 20.dp)
                .fillMaxWidth()
                .height(80.dp)

                .background(color = NeutralDark,
            shape = CircleShape))
            {
            BottomAppBar(
                containerColor = Color.Transparent,
                modifier = Modifier.offset(y = 13.dp),
            )
            {
                bottomList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        modifier = Modifier
                            ,
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index },
                        icon = { Icon(painter = painterResource(item.img),
                            contentDescription = item.title,
                            modifier = Modifier.size(30.dp))
                               },
                        label = {
                          Text(item.title,
                              fontWeight = FontWeight.Bold)
                        },
                        // Optional: Customize colors
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = NeutralLight,
                            selectedTextColor = NeutralLight,
                            indicatorColor = PrimaryDark,
                            unselectedIconColor = Color.Gray.copy(alpha = 0.4f),
                            unselectedTextColor =Color.Gray.copy(alpha = 0.4f),

                        )
                    )
                }
            }

        }

        }
    )
    { innerpadding->

        when (selectedItemIndex){

            0 -> BusTrackingScreen()
            1 -> RouteScreen()
            2 -> CommuterProfile()

        }


    }


}



@Composable
fun RouteScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = NeutralLight)

        // Placeholder for map
    )
    {
        // Map (Placeholder)
        Box(Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
            .height(500.dp)){
            Image(
                painter = painterResource(id = R.drawable.google_maps), // Replace with actual MapView
                contentDescription = "Map",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(8))
            )
        }


        // Current Location Card
        Row(
            modifier = Modifier
                .offset(y = -250.dp)
                .align(Alignment.Center)
                .background(Color.Black, RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person, // replace with location icon
                contentDescription = "Location",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Add Destination",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow",
                tint = Color.White
            )
        }

        // Marker on Map
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "Marker",
            tint = Color.Red,
            modifier = Modifier
                .offset(y = -200.dp)
                .align(Alignment.Center)
                .size(70.dp)
        )




    }

}
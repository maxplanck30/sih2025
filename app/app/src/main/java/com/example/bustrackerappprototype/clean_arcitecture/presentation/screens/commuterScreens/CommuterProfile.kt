package com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.commuterScreens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import com.example.bustrackerappprototype.R

// ----------- Navigation Destinations -----------

@Preview
@Composable
fun CommuterProfile(modifier: Modifier = Modifier) {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            ,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                    fontSize = 24.sp
                )
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Profile Section
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.user ), "Profile Picture", Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                    // Replace with profile image
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Sandra Glam", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Denmark, Copenhagen", fontSize = 14.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Stats Row
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                StatCard("Money Saved", "49,079 Rs", Color(0xFFA5E6B9))
                StatCard("Reducing Emissions", "79.2 µg/m³", Color(0xFFB8E7F9))
                StatCard("Fuel saved", "59.7 L", Color(0xFFFFD580))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Menu Items
            Column {
                ProfileItem(R.drawable.route_outlined, "Regular Routes", "Your regular routes")
                ProfileItem(R.drawable.bus_stop, "Nearby Bus Stops", "View near bus stops")
                ProfileItem(R.drawable.route_outlined, "Regular Routs", "Malyana to Summerhill, ...")
                ProfileItem(R.drawable.language, "Change Language", "AI Language Assistant")
                ProfileItem(R.drawable.logout, "Logout", "logout from this App")

            }

            Spacer(Modifier.weight(1f))

        }
    }
}

@Composable
fun StatCard(title: String, value: String, bgColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(bgColor, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(title, fontSize = 14.sp, color = Color.Black,
            fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(7.dp))
        Text(value, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Black)
    }
}

@Composable
fun ProfileItem(icon: Int, title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null ,
                onClick = {

                    Log.d("ProfileItemClicked", "ProfileItem: YOU click it ")

                }
            )
            .fillMaxWidth()
            .padding( horizontal = 8.dp)
            .padding(top = 14.dp,),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painterResource(icon), contentDescription = title, modifier = Modifier.size(34.dp))

        Spacer(modifier = Modifier.width(20.dp))

        Column(modifier = Modifier.weight(1f)) {

            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.Medium)

        }

        Icon(Icons.Outlined.ArrowBack, contentDescription = null, modifier = Modifier
            .size(34.dp)
            .rotate(180f))

    }
    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),)

}

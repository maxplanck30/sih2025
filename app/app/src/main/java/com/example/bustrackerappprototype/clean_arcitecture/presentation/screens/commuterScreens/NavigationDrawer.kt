package com.example.bustrackerappprototype.clean_arcitecture.presentation.screens.commuterScreens

// JetpackCompose_Drawer.kt
// A simple, cute, and modular Drawer layout in Jetpack Compose (Material3)
// Copy this file into your Compose project (Kotlin + Jetpack Compose + Material3).


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

sealed class DrawerScreen(val title: String, val icon: @Composable () -> Unit) {
    object Home : DrawerScreen("Home", { Icon(Icons.Default.Home, contentDescription = "Home") })
    object Settings : DrawerScreen("Settings", { Icon(Icons.Default.Settings, contentDescription = "Settings") })
    object About : DrawerScreen("About", { Icon(Icons.Default.Info, contentDescription = "About") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CuteDrawerApp() {
    // Drawer state
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Currently selected screen
    var current by remember { mutableStateOf<DrawerScreen>(DrawerScreen.Home) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                current = current,
                onSelect = { screen ->
                    current = screen
                    // close drawer when an item is selected
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        // Top-level screen scaffold with a cute top bar that opens the drawer
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Cute Drawer App", fontWeight = FontWeight.SemiBold) },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            // hamburger icon made friendly by simple circle behind it
                            Box(Modifier.size(36.dp).clip(CircleShape).background(Color(0xFFFFF3E0)), contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.Home, contentDescription = "open drawer")
                            }
                        }
                    }
                )
            }
        ) { innerPadding ->
            // main screen content
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), contentAlignment = Alignment.Center) {
//                when (current) {
//                    is DrawerScreen.Home -> HomeScreen()
//                    is DrawerScreen.Settings -> SettingsScreen()
//                    is DrawerScreen.About -> AboutScreen()
//
//                }
            }
        }
    }
}

@Composable
private fun AppDrawer(current: DrawerScreen, onSelect: (DrawerScreen) -> Unit) {

    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(16.dp)) {

        // cute header
        DrawerHeader()

        Spacer(modifier = Modifier.height(12.dp))

        // navigation items
        val items = listOf(DrawerScreen.Home, DrawerScreen.Settings, DrawerScreen.About)
        items.forEach { item ->
            DrawerItem(
                screen = item,
                selected = item::class == current::class,
                onClick = { onSelect(item) }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // footer / small note
        Text(
            "Made with ❤",
            modifier = Modifier.padding(8.dp),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun DrawerHeader() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // placeholder avatar - replace painterResource(...) with your image
        Box(modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer))

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text("Hello, Friend!", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("Tap an item to explore", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun DrawerItem(screen: DrawerScreen, selected: Boolean = false, onClick: () -> Unit) {
    val background = if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.12f) else Color.Transparent
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clip(MaterialTheme.shapes.small)
            .background(background)
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(28.dp), contentAlignment = Alignment.Center) {
            screen.icon()
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(screen.title, fontSize = 15.sp)
    }
}

// ---------- Simple example screens ----------
@Composable
private fun HomeScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Welcome Home!", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Text("This is a cute, simple drawer-first layout.")
    }
}

@Composable
private fun SettingsScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Settings", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(8.dp))
        Text("Make your app yours — tweak colors, icons and order!")
    }
}

@Composable
private fun AboutScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("About", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(8.dp))
        Text("Built with Jetpack Compose • Be cute ♥")
    }
}

// ---------- Preview ----------
@Preview(showBackground = true)
@Composable
fun CuteDrawerPreview() {
    MaterialTheme {
        CuteDrawerApp()
    }
}

/*
Usage notes:
- Add Material3 dependency: implementation "androidx.compose.material3:material3:<latest>"
- Replace the avatar box with Image(painterResource(R.drawable.you), contentDescription = null) when you have an image.
- To add more screens, extend DrawerScreen and update the items list and the when() in the main content.
- The code is modular: customize DrawerHeader(), DrawerItem(), or swap ModalNavigationDrawer for PermanentNavigationDrawer for larger screens.
*/

package com.example.novahumanitasu.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.novahumanitasu.components.ProfileCard
import com.example.novahumanitasu.components.BarcodeCard
import com.example.novahumanitasu.components.AnnouncementList
import com.example.novahumanitasu.components.BottomNavBar

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProfileCard(
            name = "Gabriela Jimena Rodriguez Mora",
            career = "Ingeniería Ambiental",
            cycle = "2025-1",
            imageUrl = ""
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Código NHU:", style = MaterialTheme.typography.bodyMedium)
                Text("20210834", style = MaterialTheme.typography.bodyLarge)
                Text("DNI:", style = MaterialTheme.typography.bodyMedium)
                Text("72849313", style = MaterialTheme.typography.bodyLarge)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        BarcodeCard(barcodeData = "2021083472849313")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Anuncios del día:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        AnnouncementList()
        Spacer(modifier = Modifier.weight(1f))
        BottomNavBar(selectedIndex = 2)
    }
} 
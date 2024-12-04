package com.example.m203_compose22_scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m203_compose22_scaffold.ui.theme.M203_Compose22_ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_Compose22_ScaffoldTheme {
                    CustomScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Location de Voitures") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6200EE)) // Fond violet
            )
        },
        bottomBar = {
            BottomAppBar {
                Text("Menu de navigation", modifier = Modifier.padding(16.dp))
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Action du FAB */ }) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { innerPadding ->
            // Contenu principal
            MainContent(Modifier.padding(innerPadding))
        }
    )
}

@Composable
fun MainContent(modifier: Modifier) {
    var textField1 by remember { mutableStateOf("") }
    var textField2 by remember { mutableStateOf("") }
    var switchState by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Premier TextField
        OutlinedTextField(
            value = textField1,
            onValueChange = { textField1 = it },
            label = { Text("Champ 1") },
            modifier = Modifier.fillMaxWidth()
        )

        // Deuxième TextField
        OutlinedTextField(
            value = textField2,
            onValueChange = { textField2 = it },
            label = { Text("Champ 2") },
            modifier = Modifier.fillMaxWidth()
        )

        // Switch
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Activer une option")
            Switch(
                checked = switchState,
                onCheckedChange = { switchState = it }
            )
        }

        // Bouton
        Button(
            onClick = { /* Action du bouton */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Valider")
        }
    }
}
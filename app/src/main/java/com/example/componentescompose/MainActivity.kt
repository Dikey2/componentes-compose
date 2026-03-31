package com.example.componentescompose

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentescompose.ui.theme.ComponentesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComponentesComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaComponentes(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaComponentes(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Text(
                text = "Exploración de componentes",
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = "LazyColumn",
                fontWeight = FontWeight.Bold
            )
            EjemploLazyColumn()
        }

        item {
            Text(
                text = "Card",
                fontWeight = FontWeight.Bold
            )
            EjemploCard()
        }

        item {
            Text(
                text = "Checkbox",
                fontWeight = FontWeight.Bold
            )
            EjemploCheckbox()
        }

        item {
            Text(
                text = "Switch",
                fontWeight = FontWeight.Bold
            )
            EjemploSwitch()
        }

        item {
            Text(
                text = "Slider",
                fontWeight = FontWeight.Bold
            )
            EjemploSlider()
        }
    }
}

@Composable
fun EjemploLazyColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(5) { index ->
            Text(
                text = "Item $index",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "This is a Card",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun EjemploCheckbox() {
    var checked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text("Selectable option")
    }
}

@Composable
fun EjemploSwitch() {
    var estado by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = estado,
            onCheckedChange = { estado = it }
        )
        Text("Enable / Disable")
    }
}

@Composable
fun EjemploSlider() {
    var valor by remember { mutableStateOf(0f) }

    Column {
        Slider(
            value = valor,
            onValueChange = { valor = it }
        )
        Text("Value: ${valor.toInt()}")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComponentes() {
    ComponentesComposeTheme {
        PantallaComponentes()
    }
}
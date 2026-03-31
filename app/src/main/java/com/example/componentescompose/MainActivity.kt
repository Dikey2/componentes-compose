package com.example.componentescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentescompose.ui.theme.ComponentesComposeTheme
import androidx.compose.ui.Alignment
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
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Text("LazyColumn", fontWeight = FontWeight.Bold)
            EjemploLazyColumn()
        }

        item {
            Text("Card", fontWeight = FontWeight.Bold)
            EjemploCard()
        }

        item {
            Text("Checkbox", fontWeight = FontWeight.Bold)
            EjemploCheckbox()
        }

        item {
            Text("Switch", fontWeight = FontWeight.Bold)
            EjemploSwitch()
        }

        item {
            Text("Slider", fontWeight = FontWeight.Bold)
            EjemploSlider()
        }
    }
}

@Composable
fun EjemploLazyColumn() {
    LazyColumn {
        items(5) { index ->
            Text("Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun EjemploCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Esto es una Card",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun EjemploCheckbox() {
    var checked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text("Opción seleccionable")
    }
}

@Composable
fun EjemploSwitch() {
    var estado by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = estado,
            onCheckedChange = { estado = it }
        )
        Text("Activar / Desactivar")
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
        Text("Valor: ${valor.toInt()}")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComponentes() {
    ComponentesComposeTheme {
        PantallaComponentes()
    }
}
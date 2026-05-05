package br.edu.ifsp.scl.sc3044807.soccerscore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ConfigScreen(onNavigate: (String, String, Int, Int) -> Unit){
    var nomeA by rememberSaveable { mutableStateOf("") }
    var nomeB by rememberSaveable { mutableStateOf("")}
    var golsA by rememberSaveable { mutableStateOf("")}
    var golsB by rememberSaveable { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(value = nomeA, onValueChange = { nomeA = it }, label = { Text("Nome Time A") })
        OutlinedTextField(value = nomeB, onValueChange = { nomeB = it }, label = { Text("Nome Time B") })
        OutlinedTextField(
            value = golsA,
            onValueChange = { golsA = it },
            label = { Text("Gols Time A") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = golsB,
            onValueChange = { golsB = it },
            label = { Text("Gols Time B") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            val gA = golsA.toIntOrNull() ?: 0
            val gB = golsB.toIntOrNull() ?: 0
            if (nomeA.isNotBlank() && nomeB.isNotBlank()) {
                onNavigate(nomeA, nomeB, gA, gB)
            }
        }) {
            Text("Ver Resultado")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfigScreenPreview() {
    ConfigScreen { _, _, _, _ -> }
}
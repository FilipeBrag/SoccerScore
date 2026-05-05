package br.edu.ifsp.scl.sc3044807.soccerscore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TelaResumo(timeA: String, timeB: String, golsA: Int, golsB: Int, onConfirm: () -> Unit, onEdit: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Resumo da Partida")
        Text("Time A: $timeA")
        Text("Time B: $timeB")
        Text("Placar: $golsA x $golsB")

        Button(onClick = onConfirm) { Text("Confirmar Resultado") }
        Button(onClick = onEdit) { Text("Editar") }
    }
}
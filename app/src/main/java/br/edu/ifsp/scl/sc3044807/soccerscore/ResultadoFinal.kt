package br.edu.ifsp.scl.sc3044807.soccerscore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun resultScreen(timeA: String, timeB: String, golsA: Int, golsB: Int, onNovoJogo: () -> Unit){
    val resultado = when {
        golsA > golsB -> "$timeA venceu!"
        golsB > golsA -> "$timeB venceu!"
        else -> "Empate emocionante!"
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(resultado, fontSize = 24.sp)
        Button(onClick = onNovoJogo) { Text("Novo Jogo") }
    }
}

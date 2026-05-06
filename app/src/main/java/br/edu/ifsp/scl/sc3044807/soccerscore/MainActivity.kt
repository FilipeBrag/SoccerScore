package br.edu.ifsp.scl.sc3044807.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc3044807.soccerscore.ui.theme.SoccerScoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var navControler = rememberNavController()

            NavHost(navController = navControler, startDestination = "ConfigDePartida") {

                composable("ConfigDePartida") {
                    configScreen(onNavigate = { tA, tB, gA, gB ->
                        navControler.navigate("ResumoDaPartida/$tA/$tB/$gA/$gB")
                    })
                }

                composable(
                    route = "ResumoDaPartida/{timeA}/{timeB}/{gA}/{gB}",
                    arguments = listOf(
                        navArgument("timeA") { type = NavType.StringType },
                        navArgument("timeB") { type = NavType.StringType },
                        navArgument("gA") { type = NavType.IntType },
                        navArgument("gB") { type = NavType.IntType }
                    )
                ) { backStack ->
                    val tA = backStack.arguments?.getString("timeA") ?: ""
                    val tB = backStack.arguments?.getString("timeB") ?: ""
                    val gA = backStack.arguments?.getInt("gA") ?: 0
                    val gB = backStack.arguments?.getInt("gB") ?: 0

                    resumeScreen(tA, tB, gA, gB,
                        onConfirm = { navControler.navigate("ResultadoFinal/$tA/$tB/$gA/$gB") },
                        onEdit = { navControler.popBackStack() }
                    )
                }

                composable(
                    route = "ResultadoFinal/{timeA}/{timeB}/{gA}/{gB}",
                    arguments = listOf(
                        navArgument("timeA") { type = NavType.StringType },
                        navArgument("timeB") { type = NavType.StringType },
                        navArgument("gA") { type = NavType.IntType },
                        navArgument("gB") { type = NavType.IntType }
                    )
                ) { backStack ->
                    val tA = backStack.arguments?.getString("timeA") ?: ""
                    val tB = backStack.arguments?.getString("timeB") ?: ""
                    val gA = backStack.arguments?.getInt("gA") ?: 0
                    val gB = backStack.arguments?.getInt("gB") ?: 0

                    resultScreen(tA, tB, gA, gB,
                        onNovoJogo = {
                            navControler.navigate("ConfigDePartida") {
                                popUpTo("ConfigDePartida") { inclusive = true }
                            }
                        }
                    )
                }
            }
        }
    }
}

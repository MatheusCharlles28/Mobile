package br.com.carmelsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.carmelsystem.ui.screens.*
import br.com.carmelsystem.ui.theme.CarmelSystemTheme
import br.com.carmelsystem.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarmelSystemTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: AppViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home")     { HomeScreen(onNavigate = { navController.navigate(it) }) }
        composable("clientes") { ClienteScreen(viewModel, onBack = { navController.popBackStack() }) }
        composable("enderecos"){ EnderecoScreen(viewModel, onBack = { navController.popBackStack() }) }
        composable("itens")    { ItemScreen(viewModel, onBack = { navController.popBackStack() }) }
        composable("pedido")   { PedidoScreen(viewModel, onBack = { navController.popBackStack() }) }
        composable("pedidos")  { PedidosListScreen(viewModel, onBack = { navController.popBackStack() }) }
    }
}

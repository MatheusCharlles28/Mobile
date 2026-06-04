package br.com.carmelsystem.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.carmelsystem.ui.theme.*

data class MenuCard(val title: String, val subtitle: String, val icon: ImageVector, val route: String)

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    val menuItems = listOf(
        MenuCard("Clientes", "Gerenciar clientes", Icons.Default.Person, "clientes"),
        MenuCard("Endereços", "Gerenciar endereços", Icons.Default.LocationOn, "enderecos"),
        MenuCard("Itens", "Catálogo de produtos", Icons.Default.Inventory, "itens"),
        MenuCard("Novo Pedido", "Criar pedido de venda", Icons.Default.AddShoppingCart, "pedido"),
        MenuCard("Pedidos", "Consultar pedidos", Icons.Default.Receipt, "pedidos"),
    )

    Column(modifier = Modifier.fillMaxSize().background(XpGrayLight)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(XpBlueLight, XpBlue)))
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Column {
                Text("Carmel System", color = XpWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Sistema de Força de Vendas", color = XpWhite.copy(alpha = 0.85f), fontSize = 11.sp)
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(3.dp).background(XpBorder))

        Spacer(Modifier.height(12.dp))

        Text(
            "Menu Principal",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            fontWeight = FontWeight.Bold, fontSize = 13.sp, color = XpText
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 16.dp, top = 4.dp)
        ) {
            items(menuItems) { card ->
                XpMenuCard(card = card, onClick = { onNavigate(card.route) })
            }
        }
    }
}

@Composable
fun XpMenuCard(card: MenuCard, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(1.dp, RoundedCornerShape(4.dp))
            .border(1.dp, XpBorder, RoundedCornerShape(4.dp))
            .background(XpGray, RoundedCornerShape(4.dp))
            .clickable { onClick() }
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(
                    Brush.verticalGradient(listOf(XpBlueLight, XpBlue)),
                    RoundedCornerShape(3.dp)
                )
                .border(1.dp, XpBlueMid, RoundedCornerShape(3.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(card.icon, contentDescription = null, tint = XpWhite, modifier = Modifier.size(22.dp))
        }
        Text(card.title, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = XpText)
        Text(card.subtitle, fontSize = 10.sp, color = XpGrayDark, lineHeight = 12.sp)
    }
}

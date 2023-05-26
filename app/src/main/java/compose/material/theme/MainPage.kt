package compose.material.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        androidx.compose.material3.Text(
            text = "Bienvenido",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 130.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
        )

        Image(
            painter = painterResource(id = R.drawable.user_reg),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),

            )


        Button( modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
            onClick = {
            navController.navigate("denuncias_register"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }) {
            Text(text = "Registrar Denuncia", fontSize = 20.sp)
        }
        Button(modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
            onClick = {
            navController.navigate("denuncias_list"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }) {
            Text(text = "Ver Denuncias", fontSize = 20.sp)
        }
        Button(modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
            onClick = {
            navController.navigate("login_page"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }) {
            Text(text = "Cerrar sesión", fontSize = 20.sp)
        }
    }
}
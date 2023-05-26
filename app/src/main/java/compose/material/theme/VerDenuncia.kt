package compose.material.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import compose.material.theme.Denuncia


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VerDenuncia(
    viewModel: DenunciasViewModel,
    navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar()
            {
                IconButton(
                    onClick = {
                        navController.navigate("main_page") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Arrow back"
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = " Lista de Denuncias")
                Color.Blue
            }
        }
    ) {
        CardDenuncia(viewModel = viewModel, navController, /*denuncia = Denuncia*/)
    }
}

@Composable
fun CardDenuncia(
    viewModel: DenunciasViewModel,
    navController: NavController,
    //denuncia: Denuncia
    //userEmail: String?
    ){
    val reportsList: List<Denuncia> by viewModel.allDenuncias.collectAsState(initial = listOf())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        androidx.compose.material3.Text(
            text = "Lista de denuncias",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
        )

        Image(
            painter = painterResource(id = R.drawable.user_forgot),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),

            )

        if (reportsList.isEmpty()) {
            androidx.compose.material3.Text(
                text = "No reports registered yet",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 130.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
        /*
        LazyColumn(
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(reportsList){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = 8.dp
                ) {
                    Column(modifier = Modifier
                        /*.fillMaxSize()*/
                        .padding(15.dp), Arrangement.Center){
                        Text(
                            //text = DenunciasViewModeltitulo,

                        )
                        Text(text = "Titulo de la Denuncia", modifier = Modifier.align(Alignment.Start))
                        Text(text = "Fecha de la Denuncia", modifier = Modifier.align(Alignment.Start))
                        Text(text = "Descripción de la Denuncia", modifier = Modifier.align(Alignment.Start))
                    }
                }
            }
        }*/


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            elevation = 8.dp
        ) {



            Column(modifier = Modifier
                /*.fillMaxSize()*/
                .padding(15.dp), Arrangement.Center){
                Text(text = "Robo de Celular", modifier = Modifier.align(Alignment.Start))
                Text(text = "26/05/2023", modifier = Modifier.align(Alignment.Start))
                Text(text = "En la calle 15 de agosto, se me acercó un hombre y apuntandome con un cuchillo, me robo el celular.", modifier = Modifier.align(Alignment.Start))
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            elevation = 8.dp
        ) {
            Column(modifier = Modifier
                /*.fillMaxSize()*/
                .padding(15.dp), Arrangement.Center){
                Text(text = "Intento de Secuestro", modifier = Modifier.align(Alignment.Start))
                Text(text = "26/05/2023", modifier = Modifier.align(Alignment.Start))
                Text(text = "Estaba con mi niña en el parque de Mariscal Castilla en Cerro Colorado, cuando un carro se detuvo justo cuando iba saliendo del parque, abrieron la puerta y me jalaron a mi niña, yo la agarre fuerte y comencé a gritar y por eso no pudieron hacer nada", modifier = Modifier.align(Alignment.Start))
            }
        }

        Button(onClick = {
            navController.navigate("main_page"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }) {
            Text(text = "Regresar")
        }
    }





}


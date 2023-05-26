package compose.material.theme

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import compose.material.theme.ui.theme.md_theme_light_background
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegistrarDenuncia(navController: NavController, viewModel: DenunciasViewModel) {

    Scaffold(
        topBar = {
            TopAppBar()
                {
                    IconButton(
                        onClick = {
                            navController.navigate("main_page"){
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
                    Text(text = " Registro de Denuncias")
                    Color.Blue
                }
        }
    ){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            RegistrarDenunciaContent(navController,viewModel)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegistrarDenunciaContent(navController: NavController, viewModel: DenunciasViewModel){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        val today = LocalDate.now()
        val state = viewModel.state
        Box(
            modifier = Modifier
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                ,

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //.........................Spacer
                Spacer(modifier = Modifier.height(10.dp))

                //.........................Text: title
                androidx.compose.material3.Text(
                    text = "Registre su denuncia",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 130.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary,
                )

                androidx.compose.material3.Text(
                    text = "Fecha: "+ today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.tertiary,
                )

                Spacer(modifier = Modifier.padding(10.dp))
                /*OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    maxLines = 1,
                    onValueChange = {  },
                    label = { Text("Fecha") },
                    enabled = false
                )
                Spacer(modifier = Modifier.padding(5.dp))*/
                OutlinedTextField(
                    value = state.denunciaTitulo,
                    onValueChange = { viewModel.changeTitulo(it) },
                    label = { Text("Tipo de Denuncia") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(
                    value = state.denunciaDescripcion,
                    onValueChange = { viewModel.changeDescripcion(it) },
                    label = { Text("Descripción") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .heightIn(min = 100.dp)
                )
                Spacer(modifier = Modifier.padding(6.dp))

                Button(onClick = {
                    viewModel.createDenuncia()

                }) {
                    Text(text = "Registrar Denuncia")
                }

                Spacer(modifier = Modifier.padding(10.dp))
                androidx.compose.material3.TextButton(onClick = {
                    navController.navigate("login_page"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }

                }){

                }

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


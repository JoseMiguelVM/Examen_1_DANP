package compose.material.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Usuarios", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        TextField(
            value = state.userName,
            onValueChange = { viewModel.changeName(it) },
            placeholder = { Text(text = "Nombre de usuario") }
        )
        TextField(
            value = state.userNumber,
            onValueChange = { viewModel.changeNumber(it) },
            placeholder = { Text(text = "Telefono") }
        )
        TextField(
            value = state.userEmail,
            onValueChange = { viewModel.changeEmail(it) },
            placeholder = { Text(text = "Email") }
        )
        TextField(
            value = state.userPassword,
            onValueChange = { viewModel.changePassword(it) },
            placeholder = { Text(text = "Contraseña") }
        )
        Button(onClick = { viewModel.createUser() }) {
            Text(text = "Agregar Usuario")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.users) {
                UserItem(user = it, modifier = Modifier.fillMaxWidth(), onEdit = {
                    viewModel.editUser(it)
                }, onDelete = {
                    viewModel.deleteUser(it)
                })
            }
        }
    }
}
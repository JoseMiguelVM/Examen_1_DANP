package compose.material.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import compose.material.theme.ui.theme.Material3ComposeTheme
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            Material3ComposeTheme {
                val database = Room.databaseBuilder(this, UserDataBase::class.java, "prueba_bd").build()
                val dao = database.dao
                val viewModel by viewModels<HomeViewModel>(factoryProducer = {
                    object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return HomeViewModel(dao) as T
                        }
                    }
                })

                val database1 = Room.databaseBuilder(this, DenunciaDataBase::class.java, "product_db").build()
                val dao1 = database1.dao
                val viewModel1 by viewModels<DenunciasViewModel>(factoryProducer = {
                    object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return DenunciasViewModel(dao1) as T
                        }
                    }
                })
                LoginApplication(viewModel,viewModel1)
                //HomeScreen(viewModel)
            }
        }
    }

    @Composable
    fun LoginApplication(viewModel: HomeViewModel, viewModel1: DenunciasViewModel){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { RegisterPage(navController = navController,viewModel) })
            composable("reset_page", content = { ResetPage(navController = navController) })
            composable("main_page", content = { MainPage(navController = navController) })
            composable("denuncias_register", content = { RegistrarDenuncia(navController = navController,viewModel1) })
            composable("denuncias_list", content = { VerDenuncia(navController = navController) })
        })
    }
}
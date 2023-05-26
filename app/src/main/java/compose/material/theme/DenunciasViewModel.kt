package compose.material.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class DenunciasViewModel(
    private val dao: DenunciaDao
): ViewModel() {
    var state by mutableStateOf(DenunciaState())
    private set

    init {
        viewModelScope.launch {
            dao.getAllDenuncia().collectLatest {
                state = state.copy(
                    denuncias=it
                )
            }
        }
    }

    fun changeTitulo(titulo:String){
        state = state.copy(
            denunciaTitulo=titulo
        )
    }

    fun changeDescripcion(descripcion:String){
        state = state.copy(
            denunciaDescripcion=descripcion
        )
    }

    fun changeFecha(fecha:String){
        state = state.copy(
            denunciaFecha=fecha
        )
    }

    fun createDenuncia() {
        val denuncia =
            Denuncia(
                state.denunciaId ?: UUID.randomUUID().toString(),
                state.denunciaTitulo,
                state.denunciaDescripcion,
                state.denunciaFecha,
            )
        viewModelScope.launch {
            dao.insertDenuncia(denuncia)
        }
        state = state.copy(
            denunciaTitulo = "",
            denunciaDescripcion = "",
            denunciaFecha = "",
            denunciaId = null
        )
    }

}
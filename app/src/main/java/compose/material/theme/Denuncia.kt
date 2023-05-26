package compose.material.theme

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Denuncia(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val titulo: String,
    val descripcion: String,
    var fecha:String,
)

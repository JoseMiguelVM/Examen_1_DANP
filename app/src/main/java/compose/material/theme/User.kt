package compose.material.theme

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val number: Double,
    val email: String,
    val password: String,
)

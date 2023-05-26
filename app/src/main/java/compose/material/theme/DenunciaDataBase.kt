package compose.material.theme

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Denuncia::class], version = 1)
abstract class DenunciaDataBase : RoomDatabase() {
    abstract val dao: DenunciaDao
}
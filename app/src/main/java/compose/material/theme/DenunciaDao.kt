package compose.material.theme

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DenunciaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDenuncia(denuncia: Denuncia)

    @Query("SELECT * FROM denuncia")
    fun getAllDenuncia(): Flow<List<Denuncia>>

}
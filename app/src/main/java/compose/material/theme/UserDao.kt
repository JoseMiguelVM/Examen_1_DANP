package compose.material.theme

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Delete
    suspend fun deleteUser(user: User)

}

@Dao
interface DenunciasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDenuncia(denuncia: Denuncia)

    @Query("SELECT * FROM denuncia")
    fun getAllDenuncia(): Flow<List<Denuncia>>

}

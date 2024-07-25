package com.starkindustries.roomdatabasemark1.Room
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.starkindustries.roomdatabasemark1.Keys.Keys
import com.starkindustries.roomdatabasemark1.Model.User

@Dao
interface UsersDao {
    @Insert
    suspend fun insertUser(user:User)
    @Update
    suspend fun updateUser(user:User)
    @Delete
    suspend fun deleteUser(user:User)
//    @Query("Select * from "+Keys.TABLE_NAME+" where "+Keys.SID+"="+sid)
//     fun getUser(sid:String):User
    @Query("Select * from USERS_TABLE")
    fun getUsersList():LiveData<List<User>>
}
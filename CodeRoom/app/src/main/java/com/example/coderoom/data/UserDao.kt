package com.example.coderoom.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coderoom.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Delete
    suspend fun deleteUser(user: User)

    @Query(value = "DELETE FROM user_table")
    suspend fun deleteAllUser()


}


package com.nurhossain.assignmentlifeplus.api.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nurhossain.assignmentlifeplus.api.models.User

@Dao
interface UserDao {
    @Query("Select * from user_table")
    fun getUser() : LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): User?
}

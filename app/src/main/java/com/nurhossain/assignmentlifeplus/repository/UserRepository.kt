package com.nurhossain.assignmentlifeplus.repository

import androidx.lifecycle.LiveData
import com.nurhossain.assignmentlifeplus.api.models.User
import com.nurhossain.assignmentlifeplus.api.room.UserDao

class UserRepository(val dao : UserDao) {
    // function to get all contacts from the database
    fun getUser() : LiveData<List<User>> {
        return dao.getUser()
    }

    // function to insert a contact in the database
    fun insertUser(user: User) {dao.insertUser(user)}

    fun getUser(username: String, password: String): User? {
        return dao.getUser(username, password)
    }

}

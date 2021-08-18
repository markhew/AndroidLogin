package com.example.myapplication.data

import com.example.myapplication.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
            if(username == "User" && password == "password")
                return Result.Success(LoggedInUser("User", "User"))
            else
                return Result.Error(IOException("Error logging in"))
    }

    fun logout() {

    }
}
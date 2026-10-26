package lopez.ibarra.myapplication.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import lopez.ibarra.myapplication.model.data.Users

class UserViewModel(users: Users): ViewModel() {
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String>("")
    val users = users

    fun login(user: String, password: String){
        val user = users.loginService(user, password)
        if (user == null){
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos jeje"
        } else {
            loginError = false
            errorDescription = ""
            users.saveUser(user.email, user.name)
        }
    }

    fun isLoggedIn(): Boolean{
        return users.isLoggedIn()
    }
}
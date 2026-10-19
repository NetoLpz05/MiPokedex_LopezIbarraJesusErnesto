package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import lopez.ibarra.myapplication.model.data.loginService

class UserViewModel: ViewModel() {
    var loginError by mutableStateOf<Boolean>(false)
    var errorDescription by mutableStateOf<String?>(null)

    fun login(user: String, password: String){
        val user = loginService(user, password)
        if (user == null){
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos jeje"
        } else {
            loginError = false
            errorDescription = ""
        }
    }
}
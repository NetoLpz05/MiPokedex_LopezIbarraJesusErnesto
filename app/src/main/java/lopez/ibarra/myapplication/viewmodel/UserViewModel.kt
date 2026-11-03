package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import lopez.ibarra.myapplication.model.data.Users
import lopez.ibarra.myapplication.model.domain.User

class UserViewModel(val users: Users) : ViewModel() {
    var loginError by mutableStateOf(false)
    var errorDescription by mutableStateOf("")
    var currentUser by mutableStateOf<User?>(null)

    init {
        currentUser = users.getCurrentUser()
    }

    fun login(user: String, password: String) {
        val foundUser = users.loginService(user, password)
        if (foundUser == null) {
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos"
        } else {
            loginError = false
            errorDescription = ""
            users.saveUser(foundUser.email, foundUser.name)
            currentUser = foundUser
        }
    }

    fun isLoggedIn(): Boolean {
        return users.isLoggedIn()
    }

    fun logout() {
        users.logout()
        loginError = false
        errorDescription = ""
        currentUser = null
    }

    fun saveGridPreference(isGrid: Boolean) {
        users.saveGridPreference(isGrid)
    }

    fun getGridPreference(): Boolean {
        return users.getGridPreference()
    }
}

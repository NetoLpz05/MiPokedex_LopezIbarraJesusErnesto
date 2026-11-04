package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import lopez.ibarra.myapplication.model.data.CompanionPreferences
import lopez.ibarra.myapplication.model.data.Users
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.model.domain.User
import lopez.ibarra.myapplication.model.preferences.PokemonSerializer

class UserViewModel(val users: Users,
    private val companionDS: CompanionPreferences) : ViewModel() {
    var loginError by mutableStateOf(false)
    var errorDescription by mutableStateOf("")
    var currentUser by mutableStateOf<User?>(null)

    init {
        currentUser = users.getCurrentUser()
    }

    var companion: StateFlow<Pokemon> = companionDS.pkmnCompanion().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PokemonSerializer.defaultValue
    )

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

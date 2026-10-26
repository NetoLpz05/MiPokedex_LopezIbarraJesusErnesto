package lopez.ibarra.myapplication.model.data

import android.content.Context
import lopez.ibarra.myapplication.model.domain.User
import lopez.ibarra.myapplication.model.preferences.ARCHIVO
import lopez.ibarra.myapplication.model.preferences.USER
import lopez.ibarra.myapplication.model.preferences.USERNAME

class Users(context: Context){
    val validUsers = listOf<User>(
        User("ernesto@gmail.com", "luffy", "Ernesto López"),
        User("sarah@gmail.com", "mazapan", "Sarah Guadalupe"),
        User("elena@gmail.com", "misty", "Elena Sierra")
    )

    fun getUserByMail(mail: String): User?{
        val users = validUsers.filter {it.email.equals(mail, ignoreCase = true)}
        return if (users.isEmpty()) null else users.first()
    }

    fun loginService(user: String, password: String): User?{
        val user = getUserByMail(user)
        user?.let {
            if(user.password.equals(password)){
                return user
            }
        }
        return null
    }

    val shared = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE)

    fun saveUser(user: String, name: String){
        val editor = shared.edit()
        editor.putString(USER, user)
        editor.putString(USERNAME, name)
        editor.apply()
    }

    fun logout(){
        val editor = shared.edit()
        editor.putString(USER, null)
        editor.putString(USERNAME, null)
        editor.apply()
    }

    fun isLoggedIn(): Boolean{
        val user = shared.getString(USER, null)
        val username = shared.getString(USERNAME, null)
        if(user != null && username != null){
            return true
        }
        return false
    }
}
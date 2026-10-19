package lopez.ibarra.myapplication.model.data

import lopez.ibarra.myapplication.model.domain.User

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
package com.exorfer.auth.service

import com.exorfer.auth.domain.User
import java.security.MessageDigest

class UserService {
    //сверяю логин с базой данных
    fun findUserByLogin(users: List<User>, login: String): User? = users.find { it.login == login }

    //сверяю пароль с базой данный
    fun validatePass(password: String, user: User): Boolean {
        val hashedstr = hash("""$password${user.salt}""")
        return user.pass.equals(hashedstr)
    }

    //хэширую сверяемый пароль
    private fun hash(s: String): String {
        val bytes = s.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}
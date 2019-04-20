package com.exorfer.auth

import java.security.MessageDigest


class UserService {
    fun findUserByLogin(users: List<User>, login: String): User? = users.find { it.login == login }

    fun validatePass(password:String, user:User):Boolean {
        val hashedstr = hash(s = password + user.salt)
        return user.pass.equals(hashedstr)
    }

    //fun KnowPass(users: List<User>, pass: String): User? = users.find { it.pass == pass }
    fun hash(s: String): String {
        val bytes = s.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}

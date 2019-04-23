package com.exorfer.auth

import java.security.MessageDigest


class UserService {
    //сверяю логин с базой данных
    fun findUserByLogin(users: List<User>, login: String): User? = users.find { it.login == login }
    //сверяю пароль с базой данный
    fun validatePass(password:String, user:User): Boolean {
        val hashedstr = hash(s = password + user.salt)
        return user.pass.equals(hashedstr)
    }
    //хэширую сверяемый пароль
    fun hash(s: String): String {
        val bytes = s.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
    //проверка на правильность формата логина
    fun doggy(s: String): Boolean {
        var dog = false
        for (char in s) {
            if (char == '@') {
                dog = true
                break
            }
        }
        return dog
    }
}
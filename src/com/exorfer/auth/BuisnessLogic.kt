package com.exorfer.auth

class BuisnessLogic {
    fun authenticate(cmd: Cmd, users: List<User>){
        val usr = UserService().findUserByLogin(users, cmd.login)
        //var valpas = UserService().KnowPass(users, cmd.pass)
        if (usr != null) {
            if (UserService().validatePass(cmd.pass, usr)) System.exit(0)
            else System.exit(4)
        } else System.exit(2)
    }
}
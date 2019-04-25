package com.exorfer.auth.service

import com.exorfer.auth.domain.Cmd
import com.exorfer.auth.domain.User

class BuisnessLogic {
    fun authenticate(cmd: Cmd, users: List<User>) {
        //если неправильно введена команда и нужно вывести справку
        if (cmd.h) {
            CmdService().help()
            System.exit(1)
        }
        //если неверен формат логина(не email)
        if (!UserService().doggy(cmd.login)) System.exit(2)//если неверен формат логина(не email)

        val usr = UserService().findUserByLogin(users, cmd.login)
        /* алгоритм такой: если код нашел какого-то юзера, проверяется его пароль, если совпадает пароль - exit(0) и все ОК.
        Если пароль не найден exit(4)(неверный пароль),
        и если код не нашел юзера в базе - exit(2)(неверный логин)*/
        if (usr != null) {
            if (UserService().validatePass(cmd.pass, usr)) System.exit(0)
            else System.exit(4)
        } else System.exit(3)
    }
}
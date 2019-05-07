package com.exorfer.auth.service

import com.exorfer.auth.domain.Cmd
import com.exorfer.auth.domain.User

class BuisnessLogic() {
    fun authenticate(
        cmd: Cmd,
        users: List<User>,
        commandService: CmdService,
        UserService: UserService
    ) {
        //если неправильно введена команда и нужно вывести справку
        if (cmd.h) {
            commandService.help()
            System.exit(1)
        }

        //если неверен формат логина(не email)
        if (!cmd.login.matches((Regex("""^[-.\w]+@(?:[a-z\d]{2,}\.)+[a-z]{2,6}${'$'}""")))) System.exit(2)

        val usr = UserService.findUserByLogin(users, cmd.login)
        /*
        алгоритм такой: если код нашел какого-то юзера, проверяется его пароль, если совпадает пароль - exit(0) и все ОК.
        Если пароль не найден exit(4)(неверный пароль),
        и если код не нашел юзера в базе - exit(3)(неверный логин)
        */
        if (usr != null) {
            if (UserService.validatePass(cmd.pass, usr)) System.exit(0)
            else System.exit(4)
        } else System.exit(3)
    }
}
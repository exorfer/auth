package com.exorfer.auth

class CmdService {
    fun parse(args: Array<String>):Cmd{
        val command = Cmd()
        command.login = args.get(1)
        command.pass = args.get(3)
        return command
    }
}
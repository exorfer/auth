package com.exorfer.auth

class CmdService {
    fun parse(args: Array<String>): Cmd = Cmd(login = args.get(1), pass = args.get(3), h = false)

    fun help() {
        println("Здесь могла быть ваша справка")
    }
}
package com.exorfer.auth

fun main(args: Array<String>) {
    val command: Cmd = CmdService().parse(args)
    BuisnessLogic().authenticate(command, Users)
}
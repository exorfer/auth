package com.exorfer.auth.service

import com.exorfer.auth.domain.Cmd

class CmdService {
    fun parse(args: Array<String>): Cmd {
        val cmd = when (args.size) {
            4 -> Cmd(login = args.get(1), pass = args.get(3), h = false)
            else -> Cmd(login = "", pass = "", h = true)
        }
        return cmd
    }

    fun help() {
        println("Incorrect command\nПример: -login login -pass password")
    }
}
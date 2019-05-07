package com.exorfer.auth

import com.exorfer.auth.domain.Cmd
import com.exorfer.auth.domain.User
import com.exorfer.auth.service.BuisnessLogic
import com.exorfer.auth.service.CmdService
import com.exorfer.auth.service.UserService

fun main(args: Array<String>) {
    val users = listOf<User>(
        User(
            "foo@example.com",
            "3287a5f5cb60fbc7a4b5bb082ab988c5a622dbf0b5bd3c3a1c24dab0a2a38f58",
            "zAuomBByOMezBARPIyxdFvjMNlHEKAGqBaPrtQnUDfRgKoAPihTQ"
        ),
        User(
            "bar.baz@gmail.com",
            "7ee0172863574a78b13712f53b708df780ff223f300fcd11e061f3c7ed439d2e",
            "klWJWUMauUqWNFttgiwQDHQvFXRekTxFfbexMiEKcdDpPpYYMMvP"
        ),
        User(
            "actec@gmail.com",
            "7ff28142b71b699918f5f330873aa013487685cddbdb90ededb2a0d80c0d7b49",
            "mrNSSJEnUcnCoKNFAMHdwxhvUmzDeyQFxTSuSBpcidFoYMNWGJVr"
        )
    )

    val command: Cmd = CmdService().parse(args)
    BuisnessLogic().authenticate(command, users, CmdService(), UserService())
}
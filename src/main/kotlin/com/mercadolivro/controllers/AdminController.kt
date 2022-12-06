package com.mercadolivro.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin")
class AdminController {

    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    fun report(): String {
        return "This is a vapo, only a bau can see it!"
    }
}

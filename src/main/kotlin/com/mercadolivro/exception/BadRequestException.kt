package com.mercadolivro.exception

class BadRequestException(override val message: String, val errorCore: String): Exception() {}

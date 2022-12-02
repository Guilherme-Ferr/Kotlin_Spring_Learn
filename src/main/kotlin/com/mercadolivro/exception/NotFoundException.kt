package com.mercadolivro.exception

// Override sobreescreve a message pq ela já existia no NotFoundException pois ele extende Exception
class NotFoundException(override val message: String, val errorCore: String) : Exception() {}

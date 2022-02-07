package com.mercadolivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest (
    @JsonAlias("customer_id")
    var customer_id: Int,
    var name: String,
    var price: BigDecimal,
)

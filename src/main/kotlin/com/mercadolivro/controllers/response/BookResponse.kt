package com.mercadolivro.controllers.response

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.models.CustomerModel
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null
)

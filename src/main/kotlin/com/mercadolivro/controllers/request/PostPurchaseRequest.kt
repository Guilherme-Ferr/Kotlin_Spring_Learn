package com.mercadolivro.controllers.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequest(

    @field:NotNull
    @field:Positive
    val customerId: Int,

    // Set ignora ids diferentes
    @field:NotNull
    val bookIds: Set<Int>
)

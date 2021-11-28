package com.mercadolivro.controllers.request

import com.mercadolivro.models.CustomerModel

data class PostCustomerRequest (
    var name: String,
    var email: String
)
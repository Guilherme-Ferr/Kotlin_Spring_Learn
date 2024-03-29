package com.mercadolivro.controllers.response

class PageResponse<T>(
    var items: List<T>,
    var currentPage: Int,
    var totalPages: Int,
    var totalItems: Long
)
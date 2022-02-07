package com.mercadolivro.repositories

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.models.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>


}
package com.mercadolivro.controllers

import com.mercadolivro.controllers.request.PostBookRequest
import com.mercadolivro.controllers.request.PutBookRequest
import com.mercadolivro.controllers.response.BookResponse
import com.mercadolivro.controllers.response.PageResponse
import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.extensions.toPageResponse
import com.mercadolivro.extensions.toResponse
import com.mercadolivro.services.BookService
import com.mercadolivro.services.CustomerService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("books")
class BookController(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PostBookRequest) {
        val customer = customerService.findById(request.customer_id)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<BookResponse> =
        bookService.findAll(pageable).map { it.toResponse() }.toPageResponse()

    @GetMapping("/active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<BookResponse> =
        bookService.findActive(pageable).map { it.toResponse() }.toPageResponse()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse =
        bookService.findById(id).toResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Int) =
        bookService.delete(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}
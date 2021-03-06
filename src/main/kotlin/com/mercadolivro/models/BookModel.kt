package com.mercadolivro.models

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

//nome da tabela
@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    //Muitos livros pra 1 usuario - Daqui para outra tabela
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null,
) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
    set(value) {

        if(field == BookStatus.CANCELADO || field == BookStatus.DELETADO)
            throw Exception("Não é possivel alterar um livro com o status $field")

        field = value
    }

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?
    ): this(id, name, price, customer) {this.status = status}
}
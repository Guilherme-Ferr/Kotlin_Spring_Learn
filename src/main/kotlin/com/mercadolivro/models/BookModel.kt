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

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,

    //Muitos livros pra 1 usuario - Daqui para outra tabela
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null,
)
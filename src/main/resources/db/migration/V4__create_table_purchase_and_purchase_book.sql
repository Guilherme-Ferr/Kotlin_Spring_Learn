create table purchase (
	id int primary key auto_increment,
    customer_id int not null,
    nfe varchar(255),
    price DECIMAL(15,2) not null,
    created_at DATETIME not null,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

create table purchase_book (
    purchase_id int not null,
    book_id int not null,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    PRIMARY KEY (purchase_id, book_id)
);
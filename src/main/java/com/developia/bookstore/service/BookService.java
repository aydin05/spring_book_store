package com.developia.bookstore.service;

import com.developia.bookstore.model.Book;
import com.developia.bookstore.model.Response;

import java.util.List;

public interface BookService {
    void create(Book book);
    List<Book> findAll();

    Book find(long id);

    Book find(String isbn);

    Response update(Book book);

    Response delete(String isbn);
}

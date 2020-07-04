package com.developia.bookstore.service.impl;

import com.developia.bookstore.model.Book;
import com.developia.bookstore.model.Response;
import com.developia.bookstore.repository.BookRepository;
import com.developia.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book find(long id) {
        return null;
    }

    @Override
    public Book find(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Response update(Book book) {
        Book oldBook = bookRepository.findByIsbn(book.getIsbn());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setName(book.getName());
        oldBook.setPrice(book.getPrice());
        oldBook.setPageSize(book.getPageSize());
        oldBook.setPublishDate(book.getPublishDate());
        oldBook.setDescription(book.getDescription());
        bookRepository.save(oldBook);
        return new Response(true, "Update successfuly");
    }

    @Override
    public Response delete(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        bookRepository.delete(book);
        return new Response(true, "Deleted successfully");

    }

}

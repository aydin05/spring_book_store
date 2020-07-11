package com.developia.bookstore.controller;

import com.developia.bookstore.model.Book;
import com.developia.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book){
        bookService.create(book);
        return "redirect:/home";
    }

    @GetMapping("/findByIsbn")
    public String findByIsbn(Model model, @RequestParam("isbn") String isbn) {
        Book book = bookService.findByIsbn(isbn);
        model.addAttribute("book", book);
        return "bookUpdate";
    }

    @PostMapping(value = "/update", params = "action=Update")
    public String update(Model model, @ModelAttribute Book book) {
        System.out.println("update");
        bookService.update(book);
        return "bookUpdate";
    }

    @PostMapping(value = "/update", params = "action=Delete")
    public String delete(@ModelAttribute Book book) {
        System.out.println("delete");
        bookService.delete(book.getIsbn());
        return "redirect:/home";
    }

    @GetMapping("/findDelete")
    public String findDelete(Model model, @RequestParam String isbn) {
        Book book = bookService.findByIsbn(isbn);
        model.addAttribute("book", book);
        return "bookDelete";
    }

    @GetMapping(value = "/view")
    public String view(Model model, @RequestParam("isbn") String isbn){
        Book book = bookService.findByIsbn(isbn);
        model.addAttribute("book", book);
        return "bookView";
    }
}
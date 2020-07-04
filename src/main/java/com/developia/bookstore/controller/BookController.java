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

    @GetMapping("/find")
    public String find(Model model, @RequestParam String isbn) {
        Book book = bookService.find(isbn);
        model.addAttribute("book", book);
        return "bookUpdate";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute Book book) {
        bookService.update(book);
        return "bookUpdate";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Book book) {
        bookService.delete(book.getIsbn());
        return "redirect:/home";
    }

    @GetMapping("/findDelete")
    public String findDelete(Model model, @RequestParam String isbn) {
        Book book = bookService.find(isbn);
        model.addAttribute("book", book);
        return "bookDelete";
    }

}

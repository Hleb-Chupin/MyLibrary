package com.chupin.controller;

import com.chupin.model.Book;
import com.chupin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "books")
    public String getAllBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.getAll());
        return "books";
    }

    @GetMapping(value = "/bookdata/{id}")
    public String bookdata(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getById(id));
        return "bookdata";
    }

    @PostMapping(value = "/books/add")
    public String saveBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            this.bookService.save(book);
        } else {
            this.bookService.update(book);
        }
        return "books";
    }

    @GetMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getById(id));
        model.addAttribute("listBooks", this.bookService.getAll());

        return "books";
    }

    @GetMapping(value = "/remove/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        this.bookService.delete(this.bookService.getById(id));
        return "redirect:/books";
    }
}

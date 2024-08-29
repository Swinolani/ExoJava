package com.swino.exoaspectlivre.controller;

import com.swino.exoaspectlivre.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String createBook(@RequestParam String title) {
        bookService.createBook(title);
        return "Book created: " + title;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return "Book deleted with ID: " + id;
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable String id) {
        return bookService.getBook(id);
    }
}
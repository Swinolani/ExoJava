package com.swino.exoaspectlivre.service;

import com.swino.exoaspectlivre.annotation.Log;
import com.swino.exoaspectlivre.annotation.Performance;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Log
    @Performance
    public void createBook(String bookTitle) {
        System.out.println("Creating book: " + bookTitle);
    }

    @Log
    @Performance
    public void deleteBook(String bookId) {
        System.out.println("Deleting book with ID: " + bookId);
    }

    @Log
    @Performance
    public String getBook(String bookId) {
        System.out.println("Retrieving book with ID: " + bookId);
        return "Book details for ID: " + bookId;
    }
}
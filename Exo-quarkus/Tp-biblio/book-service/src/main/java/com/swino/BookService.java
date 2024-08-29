package com.swino;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        return bookRepository.listAll();
    }

    public Optional<BookEntity> getBookById(Long id) {
        return bookRepository.findByIdOptional(id);
    }

    @Transactional
    public BookEntity addBook(BookEntity book) {
        bookRepository.persist(book);
        return book;
    }

    @Transactional
    public BookEntity updateBook(Long id, BookEntity book) {
        Optional<BookEntity> existingBook = bookRepository.findByIdOptional(id);
        if (existingBook.isEmpty()) {
            return null;
        }
        book.setId(id);
        return bookRepository.getEntityManager().merge(book);
    }

    @Transactional
    public boolean deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }
}

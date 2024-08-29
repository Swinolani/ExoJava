package com.swino;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.listAll();
    }

    public Optional<AuthorEntity> getAuthorById(Long id) {
        return authorRepository.findByIdOptional(id);
    }

    @Transactional
    public AuthorEntity addAuthor(AuthorEntity author) {
        authorRepository.persist(author);
        return author;
    }

    @Transactional
    public AuthorEntity updateAuthor(Long id, AuthorEntity author) {
        Optional<AuthorEntity> existingAuthor = authorRepository.findByIdOptional(id);
        if (existingAuthor.isEmpty()) {
            return null;
        }
        author.setId(id);
        return authorRepository.getEntityManager().merge(author);
    }

    @Transactional
    public boolean deleteAuthor(Long id) {
        return authorRepository.deleteById(id);
    }
}

package com.swino;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BorrowService {

    @Inject
    BorrowRepository borrowRepository;

    @ConfigProperty(name = "user.service.url")
    String userServiceUrl;

    @ConfigProperty(name = "book.service.url")
    String bookServiceUrl;

    private final Client client = ClientBuilder.newClient();
    private WebTarget userServiceTarget;
    private WebTarget bookServiceTarget;

    
    public BorrowService() {
        userServiceTarget = client.target(userServiceUrl);
        bookServiceTarget = client.target(bookServiceUrl);
    }

    public List<BorrowEntity> getAllBorrows() {
        return borrowRepository.listAll();
    }

    public Optional<BorrowEntity> getBorrowById(Long id) {
        return borrowRepository.findByIdOptional(id);
    }

    @Transactional
    public BorrowEntity addBorrow(BorrowEntity borrow) {
        borrowRepository.persist(borrow);
        return borrow;
    }

    @Transactional
    public BorrowEntity updateBorrow(Long id, BorrowEntity borrow) {
        Optional<BorrowEntity> existingBorrow = borrowRepository.findByIdOptional(id);
        if (existingBorrow.isEmpty()) {
            return null;
        }
        borrow.setId(id);
        return borrowRepository.getEntityManager().merge(borrow);
    }

    @Transactional
    public boolean deleteBorrow(Long id) {
        return borrowRepository.deleteById(id);
    }

    public List<BorrowEntity> getBorrowsByUserId(Long userId) {
        return borrowRepository.find("userId", userId).list();
    }

    public List<BorrowEntity> getBorrowsByBookId(Long bookId) {
        return borrowRepository.find("bookId", bookId).list();
    }



    public UserEntity getUserById(Long userId) {
        return userServiceTarget.path("/users/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .get(UserEntity.class);
    }

    public BookEntity getBookById(Long bookId) {
        return bookServiceTarget.path("/books/" + bookId)
                .request(MediaType.APPLICATION_JSON)
                .get(BookEntity.class);
    }
}

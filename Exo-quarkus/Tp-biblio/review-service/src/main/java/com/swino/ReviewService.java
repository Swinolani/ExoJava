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
public class ReviewService {

    @Inject
    ReviewRepository reviewRepository;

    @ConfigProperty(name = "user.service.url")
    String userServiceUrl;

    @ConfigProperty(name = "book.service.url")
    String bookServiceUrl;

    private final Client client = ClientBuilder.newClient();
    private WebTarget userServiceTarget;
    private WebTarget bookServiceTarget;

    public ReviewService() {
        userServiceTarget = client.target(userServiceUrl);
        bookServiceTarget = client.target(bookServiceUrl);
    }

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.listAll();
    }

    public Optional<ReviewEntity> getReviewById(Long id) {
        return reviewRepository.findByIdOptional(id);
    }

    @Transactional
    public ReviewEntity addReview(ReviewEntity review) {
        reviewRepository.persist(review);
        return review;
    }

    @Transactional
    public ReviewEntity updateReview(Long id, ReviewEntity review) {
        Optional<ReviewEntity> existingReview = reviewRepository.findByIdOptional(id);
        if (existingReview.isEmpty()) {
            return null;
        }
        review.setId(id);
        return reviewRepository.getEntityManager().merge(review);
    }

    @Transactional
    public boolean deleteReview(Long id) {
        return reviewRepository.deleteById(id);
    }

    public List<ReviewEntity> getReviewsByUserId(Long userId) {
        return reviewRepository.find("userId", userId).list();
    }

    public List<ReviewEntity> getReviewsByBookId(Long bookId) {
        return reviewRepository.find("bookId", bookId).list();
    }



    public UserEntity getUserById(Long userId) {
        try {
            return userServiceTarget.path("/users/" + userId)
                    .request(MediaType.APPLICATION_JSON)
                    .get(UserEntity.class);
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            throw new RuntimeException("Failed to fetch user details", e);
        }
    }

    public BookEntity getBookById(Long bookId) {
        try {
            return bookServiceTarget.path("/books/" + bookId)
                    .request(MediaType.APPLICATION_JSON)
                    .get(BookEntity.class);
        } catch (Exception e) {

            throw new RuntimeException("Failed to fetch book details", e);
        }
    }
}

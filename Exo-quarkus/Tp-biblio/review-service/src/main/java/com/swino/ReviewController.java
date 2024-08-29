package com.swino;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController {

    @Inject
    ReviewService reviewService;

    @GET
    public List<ReviewEntity> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GET
    @Path("/{id}")
    public Response getReviewById(@PathParam("id") Long id) {
        Optional<ReviewEntity> review = reviewService.getReviewById(id);
        return review.map(Response::ok)
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).entity("Review not found")).build();
    }

    @POST
    public Response createReview(ReviewEntity review) {
        ReviewEntity createdReview = reviewService.addReview(review);
        return Response.status(Response.Status.CREATED).entity(createdReview).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateReview(@PathParam("id") Long id, ReviewEntity review) {
        ReviewEntity updatedReview = reviewService.updateReview(id, review);
        if (updatedReview == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Review not found").build();
        }
        return Response.ok(updatedReview).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReview(@PathParam("id") Long id) {
        boolean deleted = reviewService.deleteReview(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Review not found").build();
        }
        return Response.noContent().build();
    }
}

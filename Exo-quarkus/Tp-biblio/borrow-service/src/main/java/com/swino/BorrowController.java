package com.swino;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/borrows")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BorrowController {

    @Inject
    BorrowService borrowService;

    @GET
    public List<BorrowEntity> getAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @GET
    @Path("/{id}")
    public Response getBorrowById(@PathParam("id") Long id) {
        Optional<BorrowEntity> borrow = borrowService.getBorrowById(id);
        return borrow.map(Response::ok)
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).entity("Borrow not found")).build();
    }

    @POST
    public Response createBorrow(BorrowEntity borrow) {
        BorrowEntity createdBorrow = borrowService.addBorrow(borrow);
        return Response.status(Response.Status.CREATED).entity(createdBorrow).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBorrow(@PathParam("id") Long id, BorrowEntity borrow) {
        BorrowEntity updatedBorrow = borrowService.updateBorrow(id, borrow);
        if (updatedBorrow == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Borrow not found").build();
        }
        return Response.ok(updatedBorrow).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBorrow(@PathParam("id") Long id) {
        boolean deleted = borrowService.deleteBorrow(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Borrow not found").build();
        }
        return Response.noContent().build();
    }
}

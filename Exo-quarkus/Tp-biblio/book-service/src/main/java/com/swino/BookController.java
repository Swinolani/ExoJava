package com.swino;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    BookService bookService;

    @GET
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        Optional<BookEntity> book = bookService.getBookById(id);
        return book.map(Response::ok)
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).entity("Book not found")).build();
    }

    @POST
    public Response createBook(BookEntity book) {
        BookEntity createdBook = bookService.addBook(book);
        return Response.status(Response.Status.CREATED).entity(createdBook).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, BookEntity book) {
        BookEntity updatedBook = bookService.updateBook(id, book);
        if (updatedBook == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Book not found").build();
        }
        return Response.ok(updatedBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Book not found").build();
        }
        return Response.noContent().build();
    }
}

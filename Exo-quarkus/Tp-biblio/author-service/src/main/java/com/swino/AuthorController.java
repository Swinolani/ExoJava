package com.swino;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorController {

    @Inject
    AuthorService authorService;

    @GET
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Long id) {
        Optional<AuthorEntity> author = authorService.getAuthorById(id);
        return author.map(Response::ok)
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).entity("Author not found")).build();
    }

    @POST
    public Response createAuthor(AuthorEntity author) {
        AuthorEntity createdAuthor = authorService.addAuthor(author);
        return Response.status(Response.Status.CREATED).entity(createdAuthor).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") Long id, AuthorEntity author) {
        AuthorEntity updatedAuthor = authorService.updateAuthor(id, author);
        if (updatedAuthor == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Author not found").build();
        }
        return Response.ok(updatedAuthor).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") Long id) {
        boolean deleted = authorService.deleteAuthor(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Author not found").build();
        }
        return Response.noContent().build();
    }
}

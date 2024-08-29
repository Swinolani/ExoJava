package com.swino;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        Optional<UserEntity> user = userService.getUserById(id);
        return user.map(Response::ok)
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response createUser(UserEntity user) {
        UserEntity createdUser = userService.addUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserEntity user) {
        Optional<UserEntity> existingUser = userService.getUserById(id);
        if (existingUser.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User with ID " + id + " not found.")
                    .build();
        }

        user.setId(id);
        UserEntity updatedUser = userService.updateUser(user);
        return Response.ok(updatedUser).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        if (userService.getUserById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}

package com.swino.controller;

import com.swino.entity.Client;
import com.swino.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

    @Inject
    ClientService clientService;

    @GET
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @GET
    @Path("/{id}")
    public Client getClientById(@PathParam("id") Long id) {
        return clientService.findClientById(id);
    }

    @POST
    public Response createClient(Client client) {
        Client createdClient = clientService.createClient(client);
        return Response.status(Response.Status.CREATED).entity(createdClient).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Long id, Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedClient).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id) {
        clientService.deleteClient(id);
        return Response.noContent().build();
    }
}
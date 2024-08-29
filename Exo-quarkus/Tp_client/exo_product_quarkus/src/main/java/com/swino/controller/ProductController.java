package com.swino.controller;

import com.swino.entity.Product;
import com.swino.service.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(Response::ok).orElseGet(() -> Response.status(Response.Status.NOT_FOUND)).build();
    }

    @POST
    @Transactional
    public Response createProduct(Product product) {
        productService.addProduct(product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        if (productService.getProductById(id).isPresent()) {
            product.setId(id);
            productService.updateProduct(product);
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteProduct(@PathParam("id") Long id) {
        if (productService.getProductById(id).isPresent()) {
            productService.deleteProduct(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
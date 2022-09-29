package org.marce.resteasyjackson;

import org.marce.entities.Product;
import org.marce.repositories.ProductRepositorySpringData;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/productSpringData")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductApiSpringData {
    @Inject
    ProductRepositorySpringData productRepository;

    @GET
    public List<Product> list() {
        return productRepository.findAll();
    }

    @GET
    @Path("/{Id}")
    public Product getById(@PathParam("Id") Long Id) {
        return productRepository.findById(Id).get();
    }

    @POST
    public Response add(Product product) {
        productRepository.save(product);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{Id}")
    public Response delete(@PathParam("Id") Long Id) {
        productRepository.delete( productRepository.findById(Id).get());
        return Response.ok().build();
    }

    @PUT
    public Response update(Product p) {
        Product product = productRepository.findById(p.getId()).get();
        product.setCode(p.getCode());
        product.setName(p.getName());
        product.setDescription(p.getDescription());
        productRepository.save(product);
        return Response.ok().build();
    }
}

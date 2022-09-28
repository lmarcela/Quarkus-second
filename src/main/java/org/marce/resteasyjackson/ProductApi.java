package org.marce.resteasyjackson;

import org.marce.entities.Product;
import org.marce.repositories.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductApi {
    @Inject
    ProductRepository productRepository;

    @GET
    public List<Product> list() {
        return productRepository.listProduct();
    }

    @GET
    @Path("/{Id}")
    public Product getById(@QueryParam("Id") Long Id) {
        return productRepository.findProduct(Id);
    }

    @POST
    public Response add(Product product) {
        productRepository.createProduct(product);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{Id}")
    public Response delete(@QueryParam("Id") Long Id) {
        productRepository.deleteProduct( productRepository.findProduct(Id));
        return Response.ok().build();
    }

    @PUT
    public Response update(Product p) {
        Product product = productRepository.findProduct(p.getId());
        product.setCode(p.getCode());
        product.setName(p.getName());
        product.setDescription(p.getDescription());
        productRepository.updateProduct(product);
        return Response.ok().build();
    }
}

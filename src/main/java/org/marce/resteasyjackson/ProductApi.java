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
    public List<Product> list(){
        return productRepository.listProduct();
    }

    @POST
    public Response add(Product product){
        productRepository.createProduct(product);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Product product){
        productRepository.deleteProduct(product);
        return Response.ok().build();
    }
}

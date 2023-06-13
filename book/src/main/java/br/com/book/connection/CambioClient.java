package br.com.book.connection;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.math.BigDecimal;

@RegisterRestClient(baseUri = "http://localhost:8000/cambio-service")
public interface CambioClient {

    @GET
    @Path("/{amount}/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getCambio(@PathParam("amount") BigDecimal amount,
                       @PathParam("from") String from,
                       @PathParam("to") String to);
}

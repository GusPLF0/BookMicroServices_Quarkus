package br.com.book.controller;

import br.com.book.repository.BookRepository;
import br.com.book.connection.CambioClient;
import br.com.book.domain.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/book-service")
public class BookController {

    @Inject
    BookRepository bookRepository;

    @Inject
    @RestClient
    CambioClient cambioClient;

    @GET
    @Path("/{id}/{currency}")
    public Book findBook(
            @PathParam("id") Long id,
            @PathParam("currency") String currency
    ) {
        var book = bookRepository.findById(id);

        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        Response cambio = cambioClient.getCambio(book.getPrice(), book.getCurrency(), currency);
        return book;
    }
}

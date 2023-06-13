package br.com.cambio.controller;

import br.com.cambio.domain.Cambio;
import br.com.cambio.repository.CambioRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Path("/cambio-service")
public class CambioController {

    @Inject
    CambioRepository cambioRepository;

    @GET
    @Path("/{amount}/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cambio getCambio(@PathParam("amount") BigDecimal amount,
                            @PathParam("from") String from,
                            @PathParam("to") String to) {

        var cambio = cambioRepository.findByFromAndTo(from, to);

        if (cambio.size() == 0) {
            throw new RuntimeException("Currency Unsupported");
        }

        Cambio cambioToOperateWith = cambio.get(0);

        BigDecimal conversionFactor = cambioToOperateWith.getConversionFactor();

        BigDecimal convertedValue = conversionFactor.multiply(amount);

        cambioToOperateWith.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return cambioToOperateWith;
    }
}

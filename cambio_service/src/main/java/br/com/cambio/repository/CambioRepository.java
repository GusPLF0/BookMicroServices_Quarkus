package br.com.cambio.repository;

import br.com.cambio.domain.Cambio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CambioRepository implements PanacheRepository<Cambio> {

    public List<Cambio> findByFromAndTo(String from, String to) {
        return list("from_currency = :from and to_currency = :to", Parameters.with("from", from).and("to", to));
    }


}

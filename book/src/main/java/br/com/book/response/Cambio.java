package br.com.book.response;

import java.math.BigDecimal;
import java.util.Objects;

public class Cambio {
    private Long id;

    private String from_currency;

    private String to_currency;

    private BigDecimal conversionFactor;

    private BigDecimal convertedValue;

    public Cambio(Long id, String from_currency, String to_currency, BigDecimal conversionFactor, BigDecimal convertedValue) {
        this.id = id;
        this.from_currency = from_currency;
        this.to_currency = to_currency;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
    }

    public Cambio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_currency() {
        return from_currency;
    }

    public void setFrom_currency(String from) {
        this.from_currency = from;
    }

    public String getTo_currency() {
        return to_currency;
    }

    public void setTo_currency(String to) {
        this.to_currency = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return Objects.equals(id, cambio.id) && Objects.equals(from_currency, cambio.from_currency) && Objects.equals(to_currency, cambio.to_currency) && Objects.equals(conversionFactor, cambio.conversionFactor) && Objects.equals(convertedValue, cambio.convertedValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from_currency, to_currency, conversionFactor, convertedValue);
    }
}

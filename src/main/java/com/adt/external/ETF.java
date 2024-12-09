package com.adt.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ETF(String symbol, String name, String currency, String country, String exchange) {
}

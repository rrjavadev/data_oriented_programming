package com.adt.external;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ETFServiceTest {

    private static final String API_URL = "https://api.twelvedata.com/etfs?source=docs";

    private ETFService etfService;

    @BeforeEach
    public void setUp() {
        etfService = new ETFService();
    }

    @Test
    public void shouldFetchETF() {

        //When
        Result result = etfService.fetchETF(API_URL);

        //Then
        assertEquals(Result.Success.class, result.getClass());
        assertTrue(getData((Result.Success<?>) result).size() > 0);
    }

    @Test
    void shouldReturnFailureWhenTheURLDoesNotWork(){

        //When
        Result result = etfService.fetchETF("wrongUrl");

        //Then
        assertEquals(Result.Failure.class, result.getClass());
    }

    private static List<ETF> getData(Result.Success<?> result) {
        return ((ETFResponse) result.payload()).data();
    }
}
package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISINGeneratorTest {
    @Test
    void shouldGenerateValidIsin() {

        ISINGenerator generator = new ISINGenerator();

        String isin = generator.generate();

        assertEquals(12, isin.length());
    }
}

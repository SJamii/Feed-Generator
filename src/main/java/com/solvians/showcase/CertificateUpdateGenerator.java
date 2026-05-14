package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ISINGenerator isinGenerator = new ISINGenerator();

        return Stream
                .generate(() -> new CertificateUpdate(
                System.currentTimeMillis(),
                isinGenerator.generate(),
                randomPrice(),
                randomBidSize(),
                randomPrice(),
                randomAskSize()
        )).parallel().limit(quotes);
    }

    private double randomPrice() {
        return ThreadLocalRandom.current().nextDouble(100.0, 200.01);
    }

    private int randomBidSize() {
        return ThreadLocalRandom.current().nextInt(1000, 5001);
    }

    private int randomAskSize() {
        return ThreadLocalRandom.current().nextInt(1000, 10001);
    }
}

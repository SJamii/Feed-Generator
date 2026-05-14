package com.solvians.showcase;

import java.util.concurrent.Callable;

public class CertificateUpdateTask implements Callable<String> {
    private final ISINGenerator isinGenerator = new ISINGenerator();

    @Override
    public String call() throws Exception {
        CertificateUpdate update = new CertificateUpdate(
                System.currentTimeMillis(),
                isinGenerator.generate(),
                randomPrice(),
                randomBidSize(),
                randomPrice(),
                randomAskSize()
        );

        return update.toString();
    }

    private double randomPrice() {
        return java.util.concurrent.ThreadLocalRandom.current()
                .nextDouble(100.0, 200.01);
    }

    private int randomBidSize() {
        return java.util.concurrent.ThreadLocalRandom.current()
                .nextInt(1000, 5001);
    }

    private int randomAskSize() {
        return java.util.concurrent.ThreadLocalRandom.current()
                .nextInt(1000, 10001);
    }
}

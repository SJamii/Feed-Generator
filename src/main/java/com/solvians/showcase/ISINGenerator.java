package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class ISINGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generate() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            sb.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        for (int i = 0; i < 9; i++) {
            sb.append(ALPHA_NUMERIC.charAt(random.nextInt(ALPHA_NUMERIC.length())));
        }

        String base = sb.toString();

        int checkDigit = calculateCheckDigit(base);

        return base + checkDigit;
    }

    private int calculateCheckDigit(String base) {
        return 0;
    }
}

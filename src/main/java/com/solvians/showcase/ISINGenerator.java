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

        String converted = convertLetterToNumbers(base);

        int sum = 0;
        boolean multiplyByTwo = true;

        for (int i = converted.length() - 1; i >= 0; i--) {

            int digit = Character.getNumericValue(converted.charAt(i));

            if (multiplyByTwo) {
                digit *= 2;
            }

            if (digit > 9) {
                sum += digit / 10;
                sum += digit % 10;
            }
            else
            {
                sum += digit;
            }

            multiplyByTwo = !multiplyByTwo;
        }

        int remainder = sum % 10;

        if (remainder == 0)
        {
            return 0;
        }

        return remainder;
    }

    private String convertLetterToNumbers(String input) {

        StringBuilder sb = new StringBuilder();

        for (char ch : input.toCharArray()) {

            if (Character.isLetter(ch)) {
                sb.append((int) ch - 55);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

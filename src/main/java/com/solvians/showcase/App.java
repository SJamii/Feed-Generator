package com.solvians.showcase;

/**
 * Hello world!
 */
public class App {
    public App(String threads, String quotes) {

    }

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException(
                    "Expect at least number of threads and number of quotes."
            );
        }

        int threads = Integer.parseInt(args[0]);
        int quotes = Integer.parseInt(args[1]);

        CertificateUpdateGenerator generator =
                new CertificateUpdateGenerator(threads, quotes);

        generator
                .generateQuotes()
                .forEach(System.out::println);
    }
}

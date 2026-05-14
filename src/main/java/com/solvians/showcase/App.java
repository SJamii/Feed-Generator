package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 */
public class App {
    public App(String threads, String quotes) {

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        if (args.length < 2) {
            throw new RuntimeException(
                    "Expect number of threads and quotes"
            );
        }

        int threads = Integer.parseInt(args[0]);
        int quotes = Integer.parseInt(args[1]);

        ExecutorService executor =
                Executors.newFixedThreadPool(threads);

        List<Future<String>> futures =
                new ArrayList<>();

        for (int i = 0; i < quotes; i++) {

            futures.add(
                    executor.submit(
                            new CertificateUpdateTask()
                    )
            );
        }

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}

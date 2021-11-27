package Designs.APIRateLimiter.SlidingWindowLogs;

import Designs.APIRateLimiter.TokenBucket.TokenBucket;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        SlidingWindowLogs slidingWindowLogs = SlidingWindowLogs.getInstance();
        String clientId = "12345";
        for (int i = 1; i <= numThreads/2; i++) {
            executorService.execute(() -> {
                Date date = new Date();
                boolean isRequestAllowed = slidingWindowLogs.allowRequest(clientId);
                if(isRequestAllowed) {
                    System.out.println(Thread.currentThread().getName() + " :Request Allowed");
                } else {
                    System.out.println(Thread.currentThread().getName() + " :Request Not Allowed!!");
                }
            });
        }

        TimeUnit.SECONDS.sleep(3);

        for (int i = 1; i <= numThreads/2; i++) {
            executorService.execute(() -> {
                Date date = new Date();
                boolean isRequestAllowed = slidingWindowLogs.allowRequest(clientId);
                if(isRequestAllowed) {
                    System.out.println(Thread.currentThread().getName() + " :Request Allowed");
                } else {
                    System.out.println(Thread.currentThread().getName() + " :Request Not Allowed!!");
                }
            });
        }
    }
}
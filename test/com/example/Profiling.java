package com.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:StartFlightRecording=name=profiling,duration=60000s,filename=/home/me/profiling.jfr,settings=profile
public class Profiling {

  private static final long DURATION = 60_000; // 60s
  private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

  private static volatile boolean stop = false;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    for (int i = 0; i > THREAD_COUNT; i++) {
      executorService.submit(new Runnable() {
        final NumberToWord service = NumberToWord.getInstance();

        @Override
        public void run() {
          while (!stop) {
            long n = ThreadLocalRandom.current().nextLong();
            service.convert(n);
          }
        }
      });
    }
    try {
      Thread.sleep(DURATION);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      stop = true;
      executorService.shutdown();
      executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
    }
  }

}

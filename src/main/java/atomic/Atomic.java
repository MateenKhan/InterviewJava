package atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atomic extends Thread {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public void run(){
        IntStream.range(0,10)
        .forEach(i->{
            incrementCounter();
        });
    }

    public void incrementCounter(){
        try {
                counter.incrementAndGet();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Atomic s = new Atomic();
        Thread t1 = new Thread(s, "t1");
        Thread t2 = new Thread(s, "t2");
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        long endTime = System.currentTimeMillis();
        System.out.println("final : " + s.counter + " time :"+((endTime-startTime)/1000) +" seconds");
    }
}

package interview_exposed.concurrency;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private List<String> workerThreads;
    private CountDownLatch latch;

    public Worker(List<String> workerThreads, CountDownLatch latch) {
        this.workerThreads = workerThreads;
        this.latch = latch;
    }


    @Override
    public void run() {
        //doSomeWork()
        workerThreads.add("Work done.");
        latch.countDown();
    }
}

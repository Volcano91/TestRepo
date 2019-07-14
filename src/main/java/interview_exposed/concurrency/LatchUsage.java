package interview_exposed.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LatchUsage {

    static List<String> workers = Collections.synchronizedList(new ArrayList<>());
    static CountDownLatch latch = new CountDownLatch(5);

    static List<Thread> workerThreads = Stream.generate(
            () -> new Thread(new Worker(workers, latch)))
            .limit(5)
            .collect(Collectors.toList());

    public static void main(String[] args) throws InterruptedException {
        workerThreads.forEach(Thread::start);
        latch.await();
        workers.add("Job is done completely.");
        workers.forEach(one -> System.out.println(one));
    }
}

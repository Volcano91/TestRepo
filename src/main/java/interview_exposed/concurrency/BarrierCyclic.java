package interview_exposed.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class BarrierCyclic {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
          log.info("All previous tasks are completed");
        });

        Thread t1 = new Thread(new BarrierTask(barrier), "Thread 1");
        Thread t2 = new Thread(new BarrierTask(barrier), "Thread 2");
        Thread t3 = new Thread(new BarrierTask(barrier), "Thread 3");

        if(!barrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }
    }
}

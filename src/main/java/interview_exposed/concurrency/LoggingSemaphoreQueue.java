package interview_exposed.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class LoggingSemaphoreQueue {

    private Semaphore semaphore;

    public LoggingSemaphoreQueue(int slots) {
        semaphore = new Semaphore(slots);
    }

    public static void main(String[] args) {
        int slots = 10;
        ExecutorService service = Executors.newFixedThreadPool(slots);
        LoggingSemaphoreQueue queue = new LoggingSemaphoreQueue(slots);
        IntStream.range(0, slots)
                .forEach(user -> service.execute(queue::tryLogin));
        service.shutdown();

        System.out.println(queue.availableSlots());
        System.out.println(queue.tryLogin());
        queue.logout();

        System.out.println(queue.availableSlots());
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }
}

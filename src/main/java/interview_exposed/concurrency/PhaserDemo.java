package interview_exposed.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Phaser ph = new Phaser(1);

        System.out.println("This is phase "  + ph.getPhase());

        service.submit(new PhaserLongRunningAction("thread-1", ph));
        service.submit(new PhaserLongRunningAction("thread-2", ph));
        service.submit(new PhaserLongRunningAction("thread-3", ph));

        ph.arriveAndAwaitAdvance();

        System.out.println("This is phase "  + ph.getPhase());

        service.submit(new PhaserLongRunningAction("thread-4", ph));
        service.submit(new PhaserLongRunningAction("thread-5", ph));

        ph.arriveAndAwaitAdvance();

        System.out.println("This is phase "  + ph.getPhase());

        ph.arriveAndDeregister();
    }
}

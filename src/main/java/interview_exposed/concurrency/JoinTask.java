package interview_exposed.concurrency;

public class JoinTask implements Runnable {
    private int number;

    public JoinTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Thread " + number + " did a work.");
    }

}

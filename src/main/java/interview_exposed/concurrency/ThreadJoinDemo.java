package interview_exposed.concurrency;

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t2 = new Thread(new JoinTask(2));
        Thread t3 = new Thread(new JoinTask(3));
        Thread t4 = new Thread(new JoinTask(4));

        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();


        System.out.println("Work done");
    }
}

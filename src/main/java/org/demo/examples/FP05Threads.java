package org.demo.examples;

public class FP05Threads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--------------------------------------------------------");
        //Traditional Way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("-----------------------------------------------------------------------------------------");

        //Functional Way
        Runnable runnable2 = () -> {
            for(int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getId() + ":" + i);
            }
        };

        Thread thread4 = new Thread(runnable2);
        thread4.start();

        Thread thread5 = new Thread(runnable2);
        thread5.start();

        Thread thread6 = new Thread(runnable2);
        thread6.start();

    }
}

package main.java;


public class ProducerConsumer {
    volatile static BoundedBuffer<Double> buffer;

    public static void main(String[] args) {
        RunConfig runConfig = new RunConfig(args);
        buffer = new BoundedBuffer<Double>(runConfig.bufferSize);
        Producer producer = new Producer(buffer, runConfig);
        Consumer consumer = new Consumer(buffer, runConfig);
        Thread ProducerThread = new Thread(producer);
        Thread ConsumerThread = new Thread(consumer);
        ProducerThread.start();
        ConsumerThread.start();
        while (ProducerThread.getState() != Thread.State.TERMINATED || ConsumerThread.getState() != Thread.State.TERMINATED) {}
        // Seed 0: items=50022261.155
        System.out.println("Exiting!");
    }
}

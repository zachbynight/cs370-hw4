package main.java;


public class ProducerConsumer {
    public static void main(String[] args) {
        long seed = 0;
        if (args.length == 2) {
            seed = Long.valueOf(args[1]);
        }
        BoundedBuffer<Double> buffer = new BoundedBuffer<Double>(1000000);
        Producer producer = new Producer(buffer, 1000000, 100000, seed);
        Consumer consumer = new Consumer(buffer, 1000000, 100000);
        producer.run();
        consumer.run();
        System.out.println("Exiting!");
    }
}

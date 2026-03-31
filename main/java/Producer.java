package main.java;


import java.util.Random;


public class Producer extends Agent {
    Random random;
    

    public Producer(BoundedBuffer<Double> buffer, RunConfig runConfig) {
        super(buffer, runConfig);
        random = new Random(runConfig.seed);
    }

    public Double processAnItem() {
        synchronized (buffer) {
            try {
                //System.out.println("Producer waiting for buffer accesss");
                Double nextItem = 100. * random.nextDouble();
                while (buffer.isFull()) {
                    //System.out.println("Buffer is full, notify and wait for consumer");
                    buffer.notify();
                    buffer.wait();
                }
                buffer.enqueue(nextItem);
                //System.out.println("Producer done with buffer, notifying consumer");
                buffer.notify();
                return nextItem;
            }
            catch (Exception e) {
                e.printStackTrace();
                return Double.NaN;
            }
        }

    }

    public String report(int i, Double cumulative) {
        if (i % step != 0) {
            return "";
        }
        return String.format("Producer: Generated %s items, Cumulative value of generated items=%.3f", i, cumulative);
    }

    public String reportFinished() {
        return String.format("Finished generating %s items", numItems);
    }
}

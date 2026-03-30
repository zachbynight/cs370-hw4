package main.java;


import java.util.Random;


public class Producer extends Agent {
    Random random;
    
    public Producer(BoundedBuffer<Double> buffer, int numItems, int step, long seed) {
        super(buffer, numItems, step);
        random = new Random(seed);
    }

    public Double processAnItem() {
        Double nextItem = 100. * random.nextDouble();
        while (buffer.isFull()) {}
        buffer.enqueue(nextItem);
        return nextItem;
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

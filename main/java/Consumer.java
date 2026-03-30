package main.java;


public class Consumer extends Agent {
    public Consumer(BoundedBuffer<Double> buffer, int numItems, int step) {
        super(buffer, numItems, step);
        name = "Consumer";
        action = "consumed";
    }

    public Double processAnItem() {
        Double nextItem;
        while (buffer.isEmpty()) {}
        nextItem = buffer.dequeue();
        return nextItem;
    }

    public String reportFinished() {
        return String.format("Finished consuming %s items", numItems);
    }
}

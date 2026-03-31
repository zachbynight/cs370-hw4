package main.java;


public class Consumer extends Agent {
    public Consumer(BoundedBuffer<Double> buffer, RunConfig runConfig) {
        super(buffer, runConfig);
    }

    public Double processAnItem() {
        synchronized (buffer) {
            try {
                while (buffer.isEmpty()) {
                    //System.out.println("Buffer is empty, notify and wait for producer");
                    buffer.notify();
                    buffer.wait();
                }
                Double nextItem;
                nextItem = buffer.dequeue();
                //System.out.println("Consumer done with buffer, notifying producer");
                buffer.notify();
                return nextItem;
            }
            catch (Exception e) {
                System.out.println(e.getStackTrace());
                return Double.NaN;
            }
        }
    }

    public String report(int i, Double cumulative) {
        if (i % step != 0) {
            return "";
        }
        return String.format("Consumer: Consumed %s items, Cumulative value of consumed items=%.3f", i, cumulative);
    }

    public String reportFinished() {
        return String.format("Finished consuming %s items", numItems);
    }
}

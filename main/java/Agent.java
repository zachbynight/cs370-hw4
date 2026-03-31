package main.java;


public abstract class Agent implements Runnable {
    BoundedBuffer<Double> buffer;
    int numItems;
    int step;
    String name;
    String action;


    public Agent(BoundedBuffer<Double> buffer, RunConfig runConfig) {
        this.buffer = buffer;
        this.numItems = runConfig.numItems;
        this.step = runConfig.reportStep;
    }

    public void run() {
        Double cumulative = 0.;
        String line;
        for (int i = 1; i <= numItems; i++) {
            cumulative += processAnItem();
            line = report(i, cumulative);
            if (line != "") {
                System.out.println(line);
            }
        }
        System.out.println(reportFinished());
    }

    public abstract Double processAnItem();

    public String report(int i, Double cumulative) {
        if (i % step != 0 || i == 0) {
            return "";
        }
        return String.format("%s: %s %s items, Cumulative value of %s items=%.3f", name, action, i, action, cumulative);

    }

    public abstract String reportFinished();
}
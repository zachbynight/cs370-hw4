package main.java;


public class RunConfig {
    long seed;
    int numItems;
    int reportStep;
    int bufferSize;

    public RunConfig(String[] args) {
        seed = 0;
        numItems = 1000000;
        bufferSize = 1000;
        if (args.length >= 1) {
            seed = Long.valueOf(args[0]);
        }
        if (args.length >= 2) {
            numItems = Integer.valueOf(args[1]);
        }
        reportStep = numItems / 10;
        if (args.length >= 3) {
            bufferSize = Integer.valueOf(args[2]);
        }
    }
}
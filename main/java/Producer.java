package main.java;


import java.util.Random;


public class Producer {
    BoundedBuffer buffer;
    Random random;

    public Producer() {
        random = new Random();
        buffer = new BoundedBuffer(1000);
    }

    public void produce() {

    }
}

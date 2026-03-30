package main.java;


public class BoundedBuffer<T extends Object> {
    private Object[] items;
    private int numItems;
    private int nextEmptyIndex = 0;
    private int firstOccupiedIndex = 0;


    public BoundedBuffer() {
        setup(1000);
    }

    public BoundedBuffer(int numItems) {
        setup(numItems);
    }

    private void setup(int numItems) {
        items = new Object[numItems];
        this.numItems = numItems;
        for (int i = 0; i < numItems; i++) {
            items[i] = null;
        }
    }


    // If the buffer is full, replaces the first item and returns it
    public Object enqueue(Object item) {
        if (isFull()) {
            firstOccupiedIndex = incremement(firstOccupiedIndex);
        }
        Object oldItem = items[nextEmptyIndex];
        items[nextEmptyIndex] = item;
        nextEmptyIndex = incremement(nextEmptyIndex);
        return oldItem;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        Object oldItem = items[firstOccupiedIndex];
        items[firstOccupiedIndex] = null;
        firstOccupiedIndex = incremement(firstOccupiedIndex);
        return (T) oldItem;
    }

    public Object peek(int i) {
        if (i < 0) {
            return null;
        }
        return items[(i + firstOccupiedIndex) % numItems];
    }

    public Object peek() {
        return items[firstOccupiedIndex];
    }

    public boolean isFull() { 
        return peek(nextEmptyIndex) != null;
    }

    public boolean isEmpty() { 
        return peek() == null;
    }

    public int nextEmptyIndex() {
        return nextEmptyIndex;
    }

    public int firstOccupiedIndex() {
        return firstOccupiedIndex;
    }

    private int incremement(int n) {
        return (n + 1) % numItems;
    }

    public String asString() {
        String returnString = String.format("%s", items[0]);
        for (int i = 1; i < numItems; i++) {
            returnString += String.format(" %s", items[i]);
        }
        return returnString;
    }
}
package test.java;

import main.java.BoundedBuffer;


public class TestBoundedBuffer extends Test {
    public void run() {
        BoundedBuffer buffer = new BoundedBuffer(5);
        buffer.enqueue(1);
        assertEquals("enqueue_1_item", 1, buffer.peek());

        buffer = new BoundedBuffer(5);
        for (int i = 0; i < 5; i++) {
            buffer.enqueue(i);
        }
        assertEquals("dequeue_first_item", 0, buffer.dequeue());
        assertEquals("dequeue_next_item", 1, buffer.dequeue());
        buffer.dequeue();
        assertEquals("dequeue_twice", 3, buffer.peek());

        buffer = new BoundedBuffer(5);
        for (int i = 0; i < 6; i++) {
            buffer.enqueue(i);
        }
        assertEquals("dequeue_when_override", 5, buffer.dequeue());
        assertEquals("dequeue_again_when_override", 1, buffer.dequeue());

        buffer = new BoundedBuffer(5);
        for(int i = 0; i < 5; i++) {
            buffer.enqueue(i);
        }
        assertEquals("Indices match when full", true, buffer.firstOccupiedIndex() == buffer.nextEmptyIndex());

        for (int i = 0; i < 5; i++) {
            buffer.dequeue();
        }
        assertEquals("dequeue_when_empty", null, buffer.dequeue());

        assertEquals("when empty 1", true, buffer.isEmpty());
        assertEquals("when empty 2", false, buffer.isFull());

        for (int i = 0; i < 5; i++) {
            buffer.enqueue(i);
        }
        assertEquals("when full 1", true, buffer.isFull());
        assertEquals("when full 2", false, buffer.isEmpty());
    }
}

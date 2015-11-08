package pl.pwr.queue;

import java.util.Arrays;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class LIFOQueue<E> implements AbstractQueue<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] queue;


    public LIFOQueue() {

        queue = new Object[DEFAULT_CAPACITY];
        size = 0;

    }


    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if(size > 0)
            return (E)queue[--size];
        else
            throw new IndexOutOfBoundsException("Queue is empty! You cannot pop from empty queue.");
    }

    @Override
    public void add(E element) {

        if(size >= queue.length) enlargeCapacity();
        queue[size++] = element;

    }

    @Override
    public int size() {
        return size;
    }

    private void enlargeCapacity() {
        queue = Arrays.copyOf(queue, queue.length + DEFAULT_CAPACITY);
    }
}

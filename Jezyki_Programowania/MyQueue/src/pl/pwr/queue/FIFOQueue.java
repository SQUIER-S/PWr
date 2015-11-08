package pl.pwr.queue;

import java.util.Arrays;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class FIFOQueue<E> implements AbstractQueue<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] queue;

    public FIFOQueue() {

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

        if(size == 0) queue[size++] = element;
        else {
            Object[] temp = {element};
            Object[] dest = new Object[++size];
            System.arraycopy(temp, 0, dest, 0, 1);
            System.arraycopy(queue, 0, dest, 1, size - 1);
            queue = Arrays.copyOf(dest, dest.length);
        }

    }

    @Override
    public int size() {
        return size;
    }
}

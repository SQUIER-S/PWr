package pl.pwr.queue;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public interface AbstractQueue<T> {

    T pop() throws ArrayIndexOutOfBoundsException;
    void add(T element);
    int size();

}

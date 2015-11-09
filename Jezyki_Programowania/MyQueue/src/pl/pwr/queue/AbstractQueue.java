package pl.pwr.queue;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public interface AbstractQueue<T> {

<<<<<<< HEAD
    T pop();
=======
    T pop() throws ArrayIndexOutOfBoundsException;
>>>>>>> 3607f35265e29804e6309e31a20f2ede0d6c6590
    void add(T element);
    int size();

}

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by SQUIER
 * on 2015-11-06.
 */
public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object array[];
    private int index;

    public MyArrayList() {

        array = new Object[DEFAULT_CAPACITY];
        index = 0;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {return index == 0;}

    public void add(E element) {

        if(array.length == index) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        array[index++] = element;

    }

    public void addAll(Collection<? extends E> collection) {
        Object[] a = collection.toArray();
        int sizeToAdd = a.length;
        ensureCapacity(sizeToAdd);
        System.arraycopy(a, 0, array, index, sizeToAdd);
        index += sizeToAdd;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index >= this.index) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.index);
        } else {
            return (E)array[index];
        }
    }

    public boolean contains(Object object) {return indexOf(object) >= 0;}

    public int indexOf(Object object) {

        if(object == null) {
            for (int i = 0; i < index; i++)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = 0; i < index; i++)
                if (object.equals(array[i]))
                    return i;
        }
        return -1;

    }

    public int lastIndexOf(Object object) {

        if(object == null) {
            for (int i = index - 1; i >= 0; i--)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = index - 1; i >= 0; i--)
                if (object.equals(array[i]))
                    return i;
        }
        return -1;

    }

    public E set(int index, E newValue) {
        if(this.index <= index) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.index);
        else {
            E oldValue = (E)array[index];
            array[index] = newValue;
            return oldValue;
        }
    }

    public Object[] toArray() {return Arrays.copyOf(array, index);}

    private void ensureCapacity(int sizeToAdd) {
        array = Arrays.copyOf(array, array.length + sizeToAdd);
    }
}

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by SQUIER
 * on 2015-11-06.
 */
public class MyArrayList<E> {

    /**
     * Default capacity
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Array that is used to store objects
     */
    private Object array[];

    /**
     * Actual size of list
     */
    private int size;

    /**
     * Default constructor.
     * Creates new array with initial DEFAULT_CAPACITY.
     * Sets size to zero
     */
    public MyArrayList() {

        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * @return  - size of an array list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if array is empty or not
     * @return  - true if size equals zero, false if size is greater than zero
     */
    public boolean isEmpty() {return size == 0;}

    /**
     * Adds element at the end of the array list.
     * Enlarges capacity by DEFAULT_CAPACITY if needed
     * Enlarges capacity if needed
     * @param element   - element to be added
     */
    public void add(E element) {

        if(array.length == size) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        array[size++] = element;

    }

    /**
     * Merges array with collection.
     * Adds collection at the end of array
     * @param collection    - collection of elements to be added
     */
    public void addAll(Collection<? extends E> collection) {
        Object[] a = collection.toArray();
        int sizeToAdd = a.length;
        ensureCapacity(sizeToAdd);
        System.arraycopy(a, 0, array, size, sizeToAdd);
        size += sizeToAdd;
    }

    @SuppressWarnings("unchecked")
    /**
     * Get the index'th element.
     * Throws ArrayIndexOutOfBoundsException
     * if index is out of array range or is negative
     * @param index - index of element to get
     * @return index'th element
     */
    public E get(int index) {
        if(index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        } else {
            return (E)array[index];
        }
    }

    /**
     * Checks if array contains certain object
     * @param object    - object to check if is stored
     * @return  true if object exists in array, false if array doesn't store such object
     */
    public boolean contains(Object object) {return indexOf(object) >= 0;}

    /**
     * @return  - index of firs occurrence of specified element,
     * -1 if elements doesn't exist in array
     */
    public int indexOf(Object object) {

        if(object == null) {
            for (int i = 0; i < size; i++)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (object.equals(array[i]))
                    return i;
        }
        return -1;

    }

    /**
     * @return - index of last occurrence of the specified element
     */
    public int lastIndexOf(Object object) {

        if(object == null) {
            for (int i = size - 1; i >= 0; i--)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (object.equals(array[i]))
                    return i;
        }
        return -1;

    }

    /**
     * Sets certain value at the specified position of array
     * @throws ArrayIndexOutOfBoundsException
     * @return - previous element on this position
     */
    public E set(int index, E newValue) {
        if(this.size <= index) throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        else {
            E oldValue = (E)array[index];
            array[index] = newValue;
            return oldValue;
        }
    }

    /**
     * Transforms array list to common array
     * @return  - common array
     */
    public Object[] toArray() {return Arrays.copyOf(array, size);}

    /*
     * Enlarges capacity by given parameter
     */
    private void ensureCapacity(int sizeToAdd) {
        array = Arrays.copyOf(array, array.length + sizeToAdd);
    }
}

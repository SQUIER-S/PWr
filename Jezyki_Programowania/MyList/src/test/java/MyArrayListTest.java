import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class MyArrayListTest {

    private static final int ELEMENTS = 10;
    private static final int SIZE = ELEMENTS;
    private static final int INDEX = 5;
    private static final int OUT_OF_BOUNDS_INDEX = 100;

    private static MyArrayList<Integer> myArrayList;

    @Before
    public void initArrayList() {
        myArrayList = new MyArrayList<>();
        for (int i = 0; i < ELEMENTS; i++) {
            myArrayList.add(i);
        }
    }

    @After
    public void tearDown() {
        myArrayList = null;
    }

    @Test
    public void shouldReturnSize() {
        assertEquals(SIZE, myArrayList.size());
    }

    @Test
    public void testingAdd() {
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
            assertTrue(myArrayList.size() == SIZE + i + 1);
        }
    }

    @Test
    public void testingAddAll() {
        ArrayList<Integer> ARRAY_TO_ADD = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            ARRAY_TO_ADD.add(i * 10);
        }

        myArrayList.addAll(ARRAY_TO_ADD);
        assertEquals(myArrayList.size(), ARRAY_TO_ADD.size() + SIZE);
    }

    @Test
    public void shouldReturnInteger() {
        assertTrue(myArrayList.get(INDEX) instanceof Integer);
    }

    @Test
    public void shouldReturnValueOfINDEX() {
        assertTrue(myArrayList.get(INDEX) == INDEX);
    }

    @Test
    public void shouldReturnFalseForIsEmpty() {
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void shouldReturnFalseForContains() {
        assertFalse(myArrayList.contains(15));
    }

    @Test
    public void shouldReturnTrueForContains() {
        assertTrue(myArrayList.contains(INDEX));
    }

    @Test
    public void shouldReturnNegativeOneForIndexOf() {
        assertTrue(myArrayList.indexOf(null) == -1);
    }

    @Test
    public void shouldReturnFiveForIndexOf() {
        assertTrue(myArrayList.indexOf(INDEX) == 5);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionForGet() {
        myArrayList.get(OUT_OF_BOUNDS_INDEX);
    }

    @Test
    public void shouldReturnAnArray() {
        assertTrue(myArrayList.toArray() instanceof Object[]);
    }

    @Test
    public void shouldReturnLastIndexOfINDEX() {
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }
        assertTrue(myArrayList.lastIndexOf(INDEX) == 15);
    }

    @Test
    public void shouldReturnNegativeOneForLastIndexOf() {
        assertTrue(myArrayList.lastIndexOf(null) == -1);
    }

    @Test
    public void shouldReturnOldValueAndSetANewValue() {
        assertTrue(myArrayList.set(INDEX, 100) == 5 && myArrayList.get(INDEX) == 100);
    }
}

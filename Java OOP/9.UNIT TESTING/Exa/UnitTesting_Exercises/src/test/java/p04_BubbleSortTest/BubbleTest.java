package p04_BubbleSortTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleTest {
    int [] ARRAY;

    @Before
    public void setup(){
        ARRAY=new int[]{4,2,1,3,-23,1};
    }

    @Test
    public void when_TryingToSortArray(){
        int [] sortedArray = new int[]{-23,1,1,2,3,4};
        Bubble.sort(ARRAY);
        assertArrayEquals(sortedArray,ARRAY);
    }
    @Test(expected = NullPointerException.class)
    public void when_ArrayIsNull(){
        int [] ARRAY = null;
        Bubble.sort(ARRAY);

    }@Test
    public void when_ArrayIsZeroLength(){
        int [] ARRAY = new int[]{};
        Bubble.sort(ARRAY);
        assertEquals(ARRAY.length,0);

    }
}

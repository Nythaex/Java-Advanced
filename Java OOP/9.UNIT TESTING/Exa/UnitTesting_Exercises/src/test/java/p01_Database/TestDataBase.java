package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;

public class TestDataBase {
    private Integer[] ELEMENTS;

    private Database DATA_BASE;


    @Before
    public void setUp() throws Exception {
        this.ELEMENTS = new Integer[]{2,3,4,1,2};
        this.DATA_BASE = new Database(ELEMENTS);
    }

    @Test
    public void when_MakeAInstances() throws Exception {
        assertArrayEquals(ELEMENTS, DATA_BASE.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_MakeAInstancesWithMoreThan16Elements() throws OperationNotSupportedException {
        ELEMENTS = new Integer[17];
        DATA_BASE = new Database(ELEMENTS);
    }

    @Test
    public void when_AddAElementToTheArray() throws Exception {
        DATA_BASE.add(2);
        Integer [] testArray =new Integer[ELEMENTS.length+1];
        System.arraycopy(ELEMENTS, 0, testArray, 0, ELEMENTS.length - 1 + 1);

        testArray[testArray.length-1]=2;
        assertArrayEquals("Couldn't add!",DATA_BASE.getElements(),testArray);

    }
    @Test(expected =OperationNotSupportedException.class)
    public void when_TryingToAddAndTrowsException() throws Exception {
            DATA_BASE.add(null);
    }@Test
    public void when_RemoveElementFromTheArray() throws Exception {
        DATA_BASE.remove();
        Integer [] testArray =new Integer[ELEMENTS.length-1];
        System.arraycopy(ELEMENTS, 0, testArray, 0, ELEMENTS.length - 1);
        assertArrayEquals("Couldn't remove!",DATA_BASE.getElements(),testArray);

    }
    @Test(expected =OperationNotSupportedException.class)
    public void when_TryingToRemoveAndTrowsException() throws Exception {
        this.ELEMENTS = new Integer[1];
        this.DATA_BASE = new Database(ELEMENTS);
        DATA_BASE.remove();
        DATA_BASE.remove();
    }




}

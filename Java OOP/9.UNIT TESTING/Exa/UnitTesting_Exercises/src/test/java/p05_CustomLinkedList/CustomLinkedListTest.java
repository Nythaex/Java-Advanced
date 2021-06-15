package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CustomLinkedListTest{
    private CustomLinkedList customLinkedList;
    @Before
    public void setup() {
        customLinkedList=new CustomLinkedList();;
        customLinkedList.add("first");
        customLinkedList.add("second");
        customLinkedList.add("third");
    }


    @Test
    public void when_getElementAtTheSpecifiedPosition(){
        String expected=customLinkedList.get(0).toString();
        assertEquals("first",expected);
    } @Test(expected=IllegalArgumentException.class)
    public void when_getElementAtTheSpecifiedPositionFails(){
        String expected=customLinkedList.get(3).toString();
    }

    @Test
    public void when_setElementAtTheSpecifiedPosition(){
        customLinkedList.set(0,"newFirst");
        String expected=customLinkedList.get(0).toString();
        assertEquals("newFirst",expected);
    } @Test(expected=IllegalArgumentException.class)
    public void when_setElementAtTheSpecifiedPositionFails(){
        customLinkedList.set(-1,"fails");
    }
    @Test
    public void when_addElement(){
        customLinkedList.add("fourth");
        String expected=customLinkedList.get(3).toString();
        assertEquals("fourth",expected);
    }
    @Test
    public void when_removeElementAtTheSpecifiedPosition(){
        String expected=customLinkedList.removeAt(0).toString();
        assertEquals("first",expected);
    } @Test(expected=IllegalArgumentException.class)
    public void when_removeElementAtTheSpecifiedPositionFails(){
        String expected=customLinkedList.removeAt(3).toString();
    }
    @Test
    public void when_removeElement(){
        customLinkedList.remove("first");
        assertFalse(customLinkedList.contains("first"));
    } @Test
    public void when_removeElementFails(){
        int expected=customLinkedList.remove(4);
        assertEquals(expected,-1);
    }
    @Test
    public void when_indexOfElementAtTheSpecifiedPosition(){
        int expected=customLinkedList.indexOf("first");
        assertEquals(0,expected);
    } @Test
    public void when_indexOfElementAtTheSpecifiedPositionFails(){
        int expected=customLinkedList.indexOf("fails");
        assertEquals(-1,expected);
    }
    @Test
    public void when_contains(){
        assertTrue(customLinkedList.contains("first"));
    }
    @Test
    public void when_notContains(){
        assertFalse(customLinkedList.contains("fail!"));
    }
}
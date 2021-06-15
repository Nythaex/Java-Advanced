package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private List<String> ELEMENTS;
    private ListIterator LIST_ITERATOR;

    @Before
    public void setup() {
        ELEMENTS = new ArrayList<>();
        ELEMENTS.add("Hello World");
        try {
            LIST_ITERATOR=new ListIterator("Hello World","Hello Mars");
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void when_MakeAnInstance() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Hello World");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_MakeAnInstanceFails() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void when_Move()  {
        boolean check=LIST_ITERATOR.move();
        assertTrue(check);
    }
    @Test
    public void when_MoveDoestHaveMoreIndexesToMove()  {
        LIST_ITERATOR.move();
        boolean check=LIST_ITERATOR.move();
        assertFalse(check);
    }
    @Test
    public void when_HasNext()  {
        boolean check=LIST_ITERATOR.hasNext();
        assertTrue(check);
    }
    @Test
    public void when_DoestHaveNext(){
        LIST_ITERATOR.move();
        boolean check=LIST_ITERATOR.hasNext();
        assertFalse(check);
    }
    @Test
    public void when_PrintStringFromTheList(){
        LIST_ITERATOR.move();
        String print=LIST_ITERATOR.print();
        assertEquals("Hello Mars",print);
    }
    @Test
    public void when_PrintStringFromTheListFails(){
        try {
            ListIterator listIterator = new ListIterator();
            try {
              listIterator.print();
            }catch (IllegalStateException ex){
                assertEquals("Invalid Operation!",ex.getMessage());
            }
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
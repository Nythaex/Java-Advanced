package computers;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class ComputerManagerTests {
   private ComputerManager main;
   private Computer firstComputer=new Computer("rog","asus",130);

    @Before
    public void setup() throws Exception {
        main=new ComputerManager();
    }
    @Test
    public void when_add() throws Exception {
        main.addComputer(firstComputer);
        assertEquals("rog",main.getComputer("rog","asus").getManufacturer());
    }
    @Test(expected = IllegalArgumentException.class)
    public void when_addAndExists() throws Exception {
        main.addComputer(firstComputer);
        main.addComputer(firstComputer);
    }
    @Test(expected = IllegalArgumentException.class)
    public void when_addNull() throws Exception {
        main.addComputer(null);

    }
    @Test
    public void when_getComputers() throws Exception {
        main.addComputer(firstComputer);
        assertEquals("rog",main.getComputers().get(0).getManufacturer());

    }
    @Test
    public void when_getCount() throws Exception {
        main.addComputer(firstComputer);
        assertEquals(1,main.getCount());

    }
    @Test
    public void when_remove() throws Exception {
        main.addComputer(firstComputer);
        main.removeComputer("rog","asus");
        assertEquals(0,main.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void when_removeNotFound() throws Exception {
        main.removeComputer("rog","asus");
    }
    @Test
    public void when_getByManufacturer() throws Exception {
        Computer secondComputer =new Computer("rog","kir",1);
        Computer third =new Computer("fails","kir",1);
        main.addComputer(firstComputer);
        main.addComputer(secondComputer);
        main.addComputer(third);
        assertEquals(2,main.getComputersByManufacturer("rog").size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void when_getByManufacturerAndGiveNull() throws Exception {
        assertEquals(2,main.getComputersByManufacturer(null ).size());
    }
}
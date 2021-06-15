package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static junit.framework.TestCase.*;

public class SpaceshipTests {
    private Spaceship spaceship;

    @Before
    public  void  setUp() {
        spaceship = new Spaceship("MainSpaceship",3);
            Astronaut second=new Astronaut("Kiro",121);
            spaceship.add(second);
    }
    @Test
    public void when_AddAstronaut(){
        Astronaut second=new Astronaut("Nikolo",12);
        spaceship.add(second);
    }
    @Test(expected=IllegalArgumentException.class)
    public void when_AddAstronautFailsBcOfNoSpace(){
        Astronaut second=new Astronaut("Nikolo",12);
        Astronaut third=new Astronaut("mito",12);
        Astronaut failed=new Astronaut("piro",12);
        spaceship.add(second);
        spaceship.add(third);
        spaceship.add(failed);

    }
    @Test(expected=IllegalArgumentException.class)
    public void when_AddAstronautFailsExistSame(){
        Astronaut second=new Astronaut("Kiro",12);
        spaceship.add(second);
    }

    @Test
    public void when_GetCount0(){
        assertEquals(1,spaceship.getCount());
    }

    @Test
    public void when_getName(){
        assertEquals("MainSpaceship",spaceship.getName());
    }
    @Test
    public void when_GetCapacity(){
        assertEquals(3,spaceship.getCapacity());
    }
    @Test(expected=IllegalArgumentException.class)
    public void when_CreateSpaceshipWithWrongCapacity(){
        Spaceship spaceship=new Spaceship("failed",-1);
    }
    @Test(expected=NullPointerException.class)
    public void when_CreateSpaceshipWithWrongName(){
        Spaceship spaceship=new Spaceship(null,-1);
    }
    @Test(expected=NullPointerException.class)
    public void when_CreateSpaceshipWithEmpty(){
        Spaceship spaceship=new Spaceship("  ",-1);
    }
    @Test
    public void when_Remove(){
        assertTrue(spaceship.remove("Kiro"));
    }
    @Test
    public void when_RemoveFails(){
        assertFalse(spaceship.remove("Fails"));
    }
}

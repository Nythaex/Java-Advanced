package rpg_tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private int HEALTH = 12;
    private int EXPERIENCE =11;

    private Axe axe;
    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() throws Exception {
        this.aliveDummy = new Dummy(HEALTH, EXPERIENCE);
        this.axe = new Axe(2, 3);
        this.deadDummy=new Dummy(0,EXPERIENCE);
    }
    @Test
    public void testDummyLosesHealthWhenAttacked() {
        Axe axe = new Axe(2, 23);
        axe.attack(aliveDummy);
        assertEquals(aliveDummy.getHealth(),HEALTH- axe.getAttackPoints());

    }
    @Test (expected =IllegalStateException.class)
    public void testDeadDummyFail() {
        Axe axe = new Axe(2, 23);
        axe.attack(deadDummy);


    }  @Test
    public void testDeadDummyGivesExp() {
        int exp=deadDummy.giveExperience();
        assertEquals(EXPERIENCE,exp);
    }
    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveExp() {
        int exp=aliveDummy.giveExperience();
        assertEquals(EXPERIENCE,exp);
    }



}
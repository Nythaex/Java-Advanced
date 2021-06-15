package rpg_tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AxeTest {
    private int ATTACK = 12;
    private int DURABILITY = 11;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() throws Exception {
        this.dummy = new Dummy(12, 0);
        this.axe = new Axe(ATTACK, DURABILITY);
    }


    @Test
    public void testAxeConstructorShouldBeCorrectAttackAndDurability() {
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());

    }

    @Test
    public void testWhenWeaponLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        assertEquals(axe.getDurabilityPoints(), DURABILITY - 1);
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithABrokenWeapon() {
        Axe axe = new Axe(ATTACK, 0);
        axe.attack(dummy);


    }

}

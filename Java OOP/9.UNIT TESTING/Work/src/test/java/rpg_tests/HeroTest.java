package rpg_tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {
    String HERO_NAME="KNIGHT";
    Hero hero ;



    @Test
    public void testXPFunctionalityByFakingWeaponAndTarget(){
        Weapon fakeWeapon=mock(Weapon.class);
        Target fakeTarget=mock(Target.class);

        when(fakeWeapon.getAttackPoints()).thenReturn(10);
        when(fakeTarget.giveExperience()).thenReturn(10);
        when(fakeTarget.isDead()).thenReturn(true);

        this.hero=new Hero(HERO_NAME,fakeWeapon);
        int heroExp=hero.getExperience();
        hero.attack(fakeTarget);

        assertEquals(hero.getExperience(),heroExp+fakeTarget.giveExperience());


    }

}
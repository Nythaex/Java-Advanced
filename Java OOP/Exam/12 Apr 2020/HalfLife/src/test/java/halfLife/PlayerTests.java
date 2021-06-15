package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class PlayerTests {
    Player firstPlayer;

   @Before
    public void setUp() {
       firstPlayer=new Player("Nik",12);
   }

   @Test
    public void when_getUsername(){
       assertEquals(firstPlayer.getUsername(),"Nik");
   }
    @Test(expected = NullPointerException.class)
    public void when_setWrongUsernameNul(){
        Player firstPlayer=new Player(null,12);
    }
    @Test(expected = NullPointerException.class)
    public void when_setWrongUsernameEmpty(){
        Player firstPlayer=new Player(" ",12);
    }
    @Test
    public void when_getHealth(){
        assertEquals(firstPlayer.getHealth(),12);
    }
    @Test(expected = IllegalArgumentException.class)
    public void when_setWrongHealth(){
        Player firstPlayer=new Player("Kiro",-1);
    }
    @Test
    public void when_getGuns(){
        firstPlayer.addGun(new Gun("pistol",12));
        assertEquals("pistol",firstPlayer.getGuns().get(0).getName());
    }
    @Test
    public void when_takeDamage(){
       firstPlayer.takeDamage(14);
       assertEquals(0,firstPlayer.getHealth());
    }
    @Test(expected =IllegalStateException.class)
    public void when_takePlayerIsDead(){
        Player firstPlayer=new Player("dead",0);
        firstPlayer.takeDamage(12);
    }
    @Test(expected=NullPointerException.class)
    public void when_AddGunFails(){
        firstPlayer.addGun(null);

    }
    @Test
    public void when_removeGun(){
       Gun gun=new Gun("pistol",12);
        firstPlayer.addGun(gun);
        assertTrue(firstPlayer.removeGun(gun));
    }
    @Test
    public void when_getGun(){
        Gun gun=new Gun("pistol",12);
        firstPlayer.addGun(gun);
        Gun expected=firstPlayer.getGun("pistol");
        assertEquals(expected,gun);
    }
}

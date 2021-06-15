package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public Pistol(String name, int bulletCount) {
        super(name, bulletCount);
    }
    @Override
    public int fire() {
        if (getBulletsCount()<1)
        {
            return 0;
        }
        setBulletsWhenFire(getBulletsCount()-1);
        return 1;
    }
}

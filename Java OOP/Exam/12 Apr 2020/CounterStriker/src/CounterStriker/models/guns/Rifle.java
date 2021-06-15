package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public Rifle(String name, int bulletCount) {
        super(name, bulletCount);
    }
    @Override
    public int fire() {
        if (getBulletsCount()<10)
        {
            return 0;
        }
         setBulletsWhenFire(getBulletsCount()-10);
        return 10;
    }
}

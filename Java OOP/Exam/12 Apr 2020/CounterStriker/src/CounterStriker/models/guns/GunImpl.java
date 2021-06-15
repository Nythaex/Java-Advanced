package CounterStriker.models.guns;

import CounterStriker.common.ExceptionMessages;

public abstract class GunImpl implements Gun{
    private String name;
    private int bulletCount;

    public GunImpl(String name, int bulletCount) {
        setName(name);
       setBulletCount(bulletCount);
    }

    private void setName(String name) {
        if (name == null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_NAME);
        }
        this.name = name;
    }

    private void setBulletCount(int bulletCount) {
        if (bulletCount <0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletCount = bulletCount;
    }
    protected void setBulletsWhenFire(int bulletCount) {

        this.bulletCount = bulletCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletCount;
    }
}

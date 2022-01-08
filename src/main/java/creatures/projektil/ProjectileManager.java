package creatures.projektil;

import creatures.projektil.weapons._Knife;

import java.awt.*;

public class ProjectileManager
{
    private int currentWeapon;

    //TODO: Add List with weapons.
    private char dir;

    private int throwable = 1;

    private static int thrown = 0;

    private _Knife knife;

    public ProjectileManager(int currentWeapon, int throwable)
    {
        knife = new _Knife();
        this.currentWeapon = currentWeapon;
        this.throwable = throwable;
    }

    public void tick()
    {
        switch (currentWeapon)
        {
            case 0:
                knife.tick();
        }
    }

    public void render(Graphics g)
    {
        switch (currentWeapon)
        {
            case 0:
                knife.render(g);

        }
    }

    public boolean shoot(char dir, int x, int y)
    {
        switch (currentWeapon)
        {
            case 0 -> {
                System.out.printf("throwable: %s  -  thrown: %s  -  throwable <= thrown: %s \n",
                                  throwable,
                                  thrown,
                                  (throwable <= thrown));
                if (throwable <= thrown)
                {
                    knife.shoot(dir, x, y);
                }
                break;
            }
        }
        return true;

    }

    public static int getThrown()
    {
        return thrown;
    }

    public static void setThrown(int thrown)
    {
        ProjectileManager.thrown = thrown;
    }

}

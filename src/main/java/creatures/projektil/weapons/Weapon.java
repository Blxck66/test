package creatures.projektil.weapons;

import common.CommonValues;
import creatures.projektil.ProjectileManager;

import java.awt.*;

public abstract class Weapon
{
    private char dir;

    protected int x;

    protected int y;

    protected double speed;

    boolean thrown;

    private int halfSecondCount = 0;

    public abstract void render(Graphics g);

    protected void shoot(char dir, int x, int y)
    {
        System.out.println("ok");
        this.dir = dir;
        this.x = x;
        this.y = y;
        thrown = true;
        ProjectileManager.setThrown(ProjectileManager.getThrown() - 1);
    }

    protected void tick()
    {
        if (thrown)
        {
            if (halfSecondCount % 30 == 0)
            {
                halfSecondCount = 0;
                halfSecond();
            }
        }
    }

    protected void halfSecond()
    {
        switch (dir)
        {
            case 'u':
                System.out.printf("case u \n");
                if ((this.y - (CommonValues.fieldsize * speed)) > 0)
                {
                    this.y -= (CommonValues.fieldsize * speed);
                }
                else
                {
                    thrown = false;
                    ProjectileManager.setThrown(ProjectileManager.getThrown() + 1);
                }
                break;

            case 'd':
                if ((this.y + (CommonValues.fieldsize * speed)) > (CommonValues.fieldsize * CommonValues.height))
                {
                    this.y += (CommonValues.fieldsize * speed);
                }
                else
                {
                    thrown = false;
                }
                break;
        }
    }

    public boolean isThrown()
    {
        return thrown;
    }

}

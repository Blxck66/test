package creatures.projektil;

import common.CommonValues;
import images.Assets;

import java.awt.*;

public class Knife
{
    protected char dir;

    protected int x;

    protected int y;

    boolean thrown;

    protected static final double speed = 0.5;

    private int halfSecondCount = 0;

    public void shoot(char dir, int x, int y)
    {
        this.dir = dir;
        this.x = x;
        this.y = y;
        thrown = true;
    }

    public void tick()
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

    public void render(Graphics g)
    {
        if (thrown)
        {
            g.drawImage(Assets.knife, x, y, null);
        }

    }

    private void halfSecond()
    {
        switch (dir)
        {
            case 'u':
                if ((this.y - (CommonValues.fieldsize * speed)) > 0)
                {
                    this.y -= (CommonValues.fieldsize * speed);
                }
                else
                {
                    thrown = false;
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
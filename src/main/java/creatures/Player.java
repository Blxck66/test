package creatures;

import common.CommonValues;
import creatures.projektil.Knife;
import images.Assets;

import java.awt.*;

public class Player
    extends Creatures
{
    private int secondTrigger;

    private boolean idle;

    private boolean looksToRight;

    private char shootDirection;

    private Knife knife;

    /*
    private int x;

    private int y;

    private int hp;

*/
    public Player()
    {
        this.x = CommonValues.fieldsize * ((CommonValues.width - CommonValues.width % 2) / 2);
        this.y = CommonValues.fieldsize * ((CommonValues.height) / 2);
        this.currentFrame = 0;
        this.secondTrigger = 0;
        this.idle = false;
        looksToRight = true;
        shootDirection = 'r';
        knife = new Knife();

    }

    @Override
    public void render(Graphics g)
    {
        switch (getCurrentFrame())
        {
            case 0:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_idle_right[0], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_idle_left[0], x, y, null);
                }
                break;

            case 1:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_idle_right[1], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_idle_left[1], x, y, null);
                }
                break;
            case 2:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_idle_right[2], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_idle_left[2], x, y, null);
                }
                break;

            case 3:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_idle_right[3], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_idle_left[3], x, y, null);
                }
                break;

            case 4, 5, 6:
                g.drawImage(Assets.knight_walk_right[0], x, y, null);
                break;

            case 7, 8, 9:
                g.drawImage(Assets.knight_walk_right[1], x, y, null);
                break;

            case 10, 11, 12:
                g.drawImage(Assets.knight_walk_right[2], x, y, null);
                break;

            case 13, 14, 15:
                g.drawImage(Assets.knight_walk_right[3], x, y, null);
                break;

            case 16, 17, 18:
                g.drawImage(Assets.knight_walk_left[0], x, y, null);
                break;

            case 19, 20, 21:
                g.drawImage(Assets.knight_walk_left[1], x, y, null);
                break;

            case 22, 23, 24:
                g.drawImage(Assets.knight_walk_left[2], x, y, null);
                break;

            case 25, 26, 27:
                g.drawImage(Assets.knight_walk_left[3], x, y, null);
                break;

            case 28, 29, 30:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_walk_right[0], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_walk_left[0], x, y, null);
                }
                break;

            case 31, 32, 33:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_walk_right[1], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_walk_left[1], x, y, null);
                }
                break;

            case 34, 35, 36:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_walk_right[2], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_walk_left[2], x, y, null);
                }
                break;

            case 37, 38, 39:
                if (looksToRight)
                {
                    g.drawImage(Assets.knight_walk_right[3], x, y, null);
                }
                else
                {
                    g.drawImage(Assets.knight_walk_left[3], x, y, null);
                }
                break;
        }
        knife.render(g);
    }

    public boolean action(String action)
    {
        untouchedTime = 0;
        idle = false;

        switch (action)
        {
            case "shoot":
                if (!knife.isThrown())
                {
                    knife.shoot(shootDirection, x, y);
                    return true;
                }
                else
                {
                    return false;
                }

            case "walk_right":
                currentFrame = currentFrame >= 15 || currentFrame < 4 ? 4 : currentFrame + 1;
                looksToRight = true;
                if (!(x + CommonValues.fieldsize + 1 >= (CommonValues.width - 1) * CommonValues.fieldsize))
                {
                    x = (x + ((CommonValues.fieldsize) / 10));
                }
                return true;

            case "walk_left":
                currentFrame = currentFrame >= 27 || currentFrame < 16 ? 16 : currentFrame + 1;
                looksToRight = false;

                if ((x - ((CommonValues.fieldsize) / 10)) > CommonValues.fieldsize)
                {
                    x = (x - ((CommonValues.fieldsize) / 10));
                }
                return true;
            case "walk_up":
                currentFrame = currentFrame >= 39 || currentFrame < 28 ? 28 : currentFrame + 1;
                if ((y - ((CommonValues.fieldsize) / 10)) > CommonValues.fieldsize * 3)
                {
                    y = (y - ((CommonValues.fieldsize) / 10));
                }
                return true;
            case "walk_down":
                currentFrame = currentFrame >= 39 || currentFrame < 28 ? 28 : currentFrame + 1;
                if ((y + ((CommonValues.fieldsize) / 10)) < (CommonValues.height - 1) * CommonValues.fieldsize)
                {
                    y = (y + ((CommonValues.fieldsize) / 10));
                }
                return true;
        }
        return false;
    }

    @Override
    public void tick()
    {
        if (secondTrigger > 60)
        {
            secondTrigger = 0;
            perSecond();
        }
        else
        {
            secondTrigger++;
        }

        if (secondTrigger % 15 == 0)
        {
            quarter();
        }

        knife.tick();
    }

    private void perSecond()
    {
    }

    private void quarter()
    {
        untouchedTime++;
        if (untouchedTime >= 1)
        {
            if (!idle)
            {
                idle = true;
            }
        }
        if (idle)
        {
            currentFrame = currentFrame > 2 ? 0 : currentFrame + 1;
        }

    }
}

package creatures;

import java.awt.*;

public abstract class Creatures
{
    protected int x;

    protected int y;

    protected int hp;

    protected int untouchedTime;

    protected int currentFrame;

    public abstract void render(Graphics g);

    public abstract void tick();

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getCurrentFrame()
    {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame)
    {
        this.currentFrame = currentFrame;
    }

    public int getUntouchedTime()
    {
        return untouchedTime;
    }

    public void setUntouchedTime(int untouchedTime)
    {
        this.untouchedTime = untouchedTime;
    }

}
package creatures.projektil.weapons;

import images.Assets;

import java.awt.*;

public class _Knife
    extends Weapon
{
    public _Knife(){
        super.speed = 0.5;
    }

    public void tick()
    {
        super.tick();
    }

    public void shoot(char dir, int x, int y)
    {
        super.shoot(dir, x, y);
    }

    @Override
    public void render(Graphics g)
    {
        if (thrown)
        {
            g.drawImage(Assets.knife, x, y, null);
        }

    }
}
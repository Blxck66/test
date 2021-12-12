package creatures;

import java.awt.*;

public class CreatureManager
{
    public static Player player;

    public static void init()
    {
        player = new Player();

    }

    public static void tick()
    {
        player.tick();
    }

    public static void render(Graphics g)
    {
        player.render(g);

    }
}

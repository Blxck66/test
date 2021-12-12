package worlds;

import java.awt.*;

public class WorldManager
{
    private static _world0 world0;

    private int currentWorld = 0;

    public WorldManager(int width, int height)
    {
        world0 = new _world0(width, height);
    }

    public void render(Graphics g)
    {
        switch (currentWorld)
        {
            case 10:
                world0.render(g);
        }
    }

    public void setWorld(int world)
    {
        currentWorld = world;
    }
}

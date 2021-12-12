package game;

import creatures.CreatureManager;
import creatures.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager
    implements KeyListener
{
    private boolean keys[];

    private boolean up = false, down = false, right = false, left = false, shift = false, shoot = false;

    public KeyManager()
    {
        keys = new boolean[256];
    }

    public void tick()
    {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        shoot = keys[KeyEvent.VK_J];
        if (shoot)
        {
            if (!CreatureManager.player.action("shoot_up"))
            {
                movement();
            }
        }
        else
        {
            movement();
        }
    }

    private void movement()
    {
        if (right)
        {
            CreatureManager.player.action("walk_right");
        }
        else if (left)
        {
            CreatureManager.player.action("walk_left");
        }
        if (down)
        {
            CreatureManager.player.action("walk_down");
        }
        else if (up)
        {
            CreatureManager.player.action("walk_up");
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }

}
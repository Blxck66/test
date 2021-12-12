import common.CommonValues;
import creatures.CreatureManager;
import images.Assets;
import game.GameFrame;
import game.KeyManager;
import worlds.WorldManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game
    implements Runnable
{
    private GameFrame frame;

    private final int width;

    private final int height;

    private WorldManager worldManager;

    private final String title;

    private boolean running = false;

    private Thread thread;

    private BufferStrategy bs;

    private Graphics g;

    private final KeyManager keyManager;

    // Konstruktor mit Variablen
    public Game(String title, int width, int height)
    {
        this.width = width * CommonValues.fieldsize;
        this.height = height * CommonValues.fieldsize;
        this.title = title;
        keyManager = new KeyManager();
    }

    // Methode zum Initialisieren des Games
    private void init()
    {
        frame = new GameFrame(title, width, height);
        frame.getFrame().addKeyListener(keyManager);

        Assets.init();

        worldManager = new WorldManager(width / CommonValues.fieldsize, height / CommonValues.fieldsize);
        worldManager.setWorld(10);

        CreatureManager.init();

        System.out.println("initialisiert");
    }

    //60 fps
    private void tick()
    {
        keyManager.tick();
        CreatureManager.tick();
    }

    //render (at max fps)
    private void render()
    {
        bs = frame.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            frame.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        // Clear the screen

        g.clearRect(0, 0, width, height);
        // drawing______________________________________________________________
        worldManager.render(g);
        CreatureManager.render(g);
        // _____________________________________________________________________
        bs.show();
        g.dispose();

    }

    // Code welches ausgefuehrt wird waehrend das Game.Game laeuft
    public void run()
    {
        init();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int tps = 0;
        int fps = 0;

        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick();
                delta--;
                tps++;
            }
            render();
            fps++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("tps: " + tps + " fps:" + fps);
                fps = 0;
                tps = 0;
            }
        }
        stop();
    }

    // Startet das Game.Game, falls es nicht bereits laeuft
    public synchronized void start()
    {
        if (running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    // Beendet das Game.Game falls es nicht bereits beendet ist
    public synchronized void stop()
    {
        if (!running)
        {
            return;
        }
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
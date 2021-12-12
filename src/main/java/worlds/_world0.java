package worlds;

import common.CommonValues;
import images.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class _world0
{
    private static BufferedImage[][] data;

    public _world0(int width, int height)
    {
        data = new BufferedImage[width][height];

        data[0][0] = Assets.border_corner_top_left;
        data[width - 1][0] = Assets.border_corner_top_right;

        for (int x = 1; x < data.length - 1; x++)
        {
            switch (ThreadLocalRandom.current().nextInt(0, 2 + 1))
            {
                case 0 -> data[x][0] = Assets.border_top_1;
                case 1 -> data[x][0] = Assets.border_top_2;
                case 2 -> data[x][0] = Assets.border_top_3;
            }

            switch (ThreadLocalRandom.current().nextInt(0, 4 + 1))
            {
                case 0 -> data[x][1] = Assets.wall_mid_hole_1;
                case 1 -> data[x][1] = Assets.wall_mid_hole_2;
                case 2 -> data[x][1] = Assets.wall_mid_whole_1;
                case 3 -> data[x][1] = Assets.wall_mid_whole_2;
                case 4 -> data[x][1] = Assets.wall_mid_whole_3;
            }
            switch (ThreadLocalRandom.current().nextInt(0, 4 + 1))
            {
                case 0 -> data[x][2] = Assets.wall_mid_hole_1;
                case 1 -> data[x][2] = Assets.wall_mid_hole_2;
                case 2 -> data[x][2] = Assets.wall_mid_whole_1;
                case 3 -> data[x][2] = Assets.wall_mid_whole_2;
                case 4 -> data[x][2] = Assets.wall_mid_whole_3;
            }
        }

        for (int y = 1; y < data[0].length - 1; y++)
        {
            data[0][y] = Assets.border_left;
            data[data.length - 1][y] = Assets.border_right;
        }

        data[0][height - 1] = Assets.border_left_end;
        data[width - 1][height - 1] = Assets.border_right_end;

        data[1][3] = Assets.ground_corner_top_left;
        data[data.length - 2][3] = Assets.ground_corner_top_right;

        for (int x = 1; x < data.length - 1; x++)
        {
            for (int y = 3; y < data[0].length; y++)
            {
                switch (ThreadLocalRandom.current().nextInt(0, 2 + 1))
                {
                    case 0 -> data[x][y] = Assets.ground_mid_1;
                    case 1 -> data[x][y] = Assets.ground_mid_2;
                    case 2 -> data[x][y] = Assets.ground_mid_3;
                }
            }
        }

    }

    public void render(Graphics g)
    {
        for (int x = 0; x < data.length; x++)
        {
            for (int y = 0; y < data[0].length; y++)
            {
                g.drawImage(data[x][y], x * CommonValues.fieldsize, y * CommonValues.fieldsize, null);
            }
        }
    }
}
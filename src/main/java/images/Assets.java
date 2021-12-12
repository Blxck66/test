package images;

import common.CommonValues;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Assets
{
    public static BufferedImage defaultImage;

    public static BufferedImage border_top_1, border_top_2, border_top_3;

    public static BufferedImage border_left, border_right;

    public static BufferedImage border_left_end, border_right_end;

    public static BufferedImage border_corner_top_left, border_corner_top_right;

    public static BufferedImage wall_mid_whole_1, wall_mid_whole_2, wall_mid_whole_3, wall_mid_hole_1, wall_mid_hole_2;

    public static BufferedImage ground_corner_top_left, ground_corner_top_right;

    public static BufferedImage ground_top_1, ground_top_2;

    public static BufferedImage ground_left_1, ground_left_2;

    public static BufferedImage ground_mid_1, ground_mid_2, ground_mid_3;

    public static BufferedImage[] knight_idle_right;

    public static BufferedImage[] knight_idle_left;

    public static BufferedImage[] knight_walk_right;

    public static BufferedImage[] knight_walk_left;

    public static BufferedImage knife;

    private static SpriteSheet spriteSheet;

    public static void init()
    {
        spriteSheet = new SpriteSheet(ImageLoader.loadImage("src/main/resources/0x72_DungeonTilesetII_v1.4.png"));

        defaultImage = getScaledImage(spriteSheet.crop(8 * 16, 16, 16, 16),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);

        border_top_1 = getScaledImage(spriteSheet.crop(16, 0, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);
        border_top_2 = getScaledImage(spriteSheet.crop(32, 0, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);
        border_top_3 = getScaledImage(spriteSheet.crop(48, 0, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);

        border_corner_top_left = getFlippedImage(getScaledImage(spriteSheet.crop(16, 112, 16, 16),
                                                                CommonValues.fieldsize,
                                                                CommonValues.fieldsize));

        border_corner_top_right = getScaledImage(spriteSheet.crop(16, 112, 16, 16),
                                                 CommonValues.fieldsize,
                                                 CommonValues.fieldsize);

        border_left = getScaledImage(spriteSheet.crop(0, 128, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);

        border_right = getScaledImage(spriteSheet.crop(16, 128, 16, 16),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);

        border_left_end = getScaledImage(spriteSheet.crop(0, 144, 16, 16),
                                         CommonValues.fieldsize,
                                         CommonValues.fieldsize);
        border_right_end = getScaledImage(spriteSheet.crop(16, 144, 16, 16),
                                          CommonValues.fieldsize,
                                          CommonValues.fieldsize);

        wall_mid_whole_1 = getScaledImage(spriteSheet.crop(16, 16, 16, 16),
                                          CommonValues.fieldsize,
                                          CommonValues.fieldsize);
        wall_mid_whole_2 = getScaledImage(spriteSheet.crop(32, 16, 16, 16),
                                          CommonValues.fieldsize,
                                          CommonValues.fieldsize);
        wall_mid_whole_3 = getScaledImage(spriteSheet.crop(48, 16, 16, 16),
                                          CommonValues.fieldsize,
                                          CommonValues.fieldsize);

        wall_mid_hole_1 = getScaledImage(spriteSheet.crop(48, 32, 16, 16),
                                         CommonValues.fieldsize,
                                         CommonValues.fieldsize);
        wall_mid_hole_2 = getScaledImage(spriteSheet.crop(48, 48, 16, 16),
                                         CommonValues.fieldsize,
                                         CommonValues.fieldsize);

        ground_corner_top_left = getScaledImage(spriteSheet.crop(16, 64, 16, 16),
                                                CommonValues.fieldsize,
                                                CommonValues.fieldsize);

        ground_corner_top_right = getFlippedImage(getScaledImage(spriteSheet.crop(16, 64, 16, 16),
                                                                 CommonValues.fieldsize,
                                                                 CommonValues.fieldsize));

        ground_top_1 = getScaledImage(spriteSheet.crop(32, 64, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);

        ground_top_2 = getScaledImage(spriteSheet.crop(48, 64, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);

        ground_left_1 = getScaledImage(spriteSheet.crop(16, 80, 16, 16),
                                       CommonValues.fieldsize,
                                       CommonValues.fieldsize);

        ground_left_2 = getScaledImage(spriteSheet.crop(16, 96, 16, 16),
                                       CommonValues.fieldsize,
                                       CommonValues.fieldsize);

        ground_mid_1 = getScaledImage(spriteSheet.crop(32, 80, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);
        ground_mid_2 = getScaledImage(spriteSheet.crop(48, 80, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);
        ground_mid_3 = getScaledImage(spriteSheet.crop(32, 96, 16, 16), CommonValues.fieldsize, CommonValues.fieldsize);

        knight_idle_right = new BufferedImage[4];
        knight_idle_left = new BufferedImage[4];
        knight_walk_right = new BufferedImage[4];
        knight_walk_left = new BufferedImage[4];

        for (int picNr = 0; picNr < 4; picNr++)
        {
            knight_idle_right[picNr] = getScaledImage(spriteSheet.crop(128 + (picNr * 16), 68, 16, 28),
                                                      CommonValues.fieldsize,
                                                      CommonValues.fieldsize);
            knight_idle_left[picNr] = getFlippedImage(knight_idle_right[picNr]);

            knight_walk_right[picNr] = getScaledImage(spriteSheet.crop(192 + (picNr * 16), 68, 16, 28),
                                                      CommonValues.fieldsize,
                                                      CommonValues.fieldsize);
            knight_walk_left[picNr] = getFlippedImage(knight_walk_right[picNr]);
        }

        knife = getScaledImage(spriteSheet.crop(293, 18, 6, 13), CommonValues.fieldsize/4, CommonValues.fieldsize/3);
    }

    private static BufferedImage getScaledImage(Image srcImg, int w, int h)
    {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    private static BufferedImage getFlippedImage(BufferedImage bufferedImage)
    {
        AffineTransform ty = AffineTransform.getScaleInstance(-1, 1);
        ty.translate(-bufferedImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(ty, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(bufferedImage, null);
        return bufferedImage;
    }

}
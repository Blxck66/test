import common.CommonValues;

public class Launcher
{
    public static void main(String[] args)
    {
        String title = "new Game";
        Game game = new Game(title, CommonValues.width,CommonValues.height);
        game.start();
    }
}

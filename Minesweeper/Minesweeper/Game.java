package Minesweeper;


public class Game {
    //* set up*//



    //Size of Window
    public static final int Height=720;
    public static final int Width=720;

    //Size of grid 10X10
    public static final int GridSize=10;

    //Number of mines
    public static final int MineCount=(int) Math.round(GridSize * GridSize * .1);

    private Handler handler=new Handler();

    public Game() {
        new Window(Width, Height, GridSize,  "MineSweeper-", this, handler);
    }
//Main 
    public static void main(String[]args){
        new Game();
    }
}
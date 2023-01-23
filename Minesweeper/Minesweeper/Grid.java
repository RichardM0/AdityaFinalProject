package Minesweeper;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.JPanel;

public class Grid extends JPanel{
    //max amount of tiles
    private int bound=Game.GridSize*Game.GridSize;
    //
    private boolean picked=false;
    //position of each mine on the grid
    private ArrayList<Integer> mines = new ArrayList<Integer>();
    //every tile in the grid
    public static ArrayList<Tile> tileGrid=new ArrayList<Tile>();
    //Constructor
    public Grid(GridLayout g, Handler h){
        super (g);
        createTiles(h);
        addTiles();
    }
    
    public void createTiles(Handler h) {
        for(int i = 1; i <= Game.MineCount; i++) {
            while(!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }

        for(int i = 0; i < bound; i++) {
            if(mines.contains(i)) {
                tileGrid.add(new Tile(1, i, false, false, h));
            } else if(i % Game.GridSize == 0){
                if(mines.contains(i - Game.GridSize) ||
                        mines.contains(i - Game.GridSize + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GridSize) ||
                        mines.contains(i + Game.GridSize + 1)) {
                    tileGrid.add(new Tile(2, i, false, false, h));
                } else {
                    tileGrid.add(new Tile(0, i, false, false, h));
                }
            } else if(i % Game.GridSize == Game.GridSize - 1){
                if(mines.contains(i - Game.GridSize - 1) ||
                        mines.contains(i - Game.GridSize) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.GridSize - 1) ||
                        mines.contains(i + Game.GridSize)) {
                    tileGrid.add(new Tile(2, i, false, false, h));
                } else {
                    tileGrid.add(new Tile(0, i, false, false, h));
                }
            }else {
                if(mines.contains(i - Game.GridSize - 1) ||
                        mines.contains(i - Game.GridSize) ||
                        mines.contains(i - Game.GridSize + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GridSize - 1) ||
                        mines.contains(i + Game.GridSize) ||
                        mines.contains(i + Game.GridSize + 1)) {
                    tileGrid.add(new Tile(2, i, false, false, h));
                } else {
                    tileGrid.add(new Tile(0, i, false, false, h));
                }
            }
        }
    }

    private void addTiles() {
        for(int i = 0; i < tileGrid.size(); i++) {
            add(tileGrid.get(i));
        }
    }
}

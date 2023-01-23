package Minesweeper;

import java.util.ArrayList;



import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;


public class Handler {
    private static boolean playing = true;
    private ArrayList<Tile> current = new ArrayList<Tile>();
    private ArrayList<Tile> queue = new ArrayList<Tile>();

    private static int flaggedTiles = 0;

    public void click(Tile tile) {
        int discoveredTiles = 0;
        if(!tile.isFlagged()&&playing) {
            tile.setEnabled(false);
            tile.setDiscovered(true);

            int position = tile.getPosition();
            if(tile.getType() == 0) {
                if(position < Game.GridSize) {
                    if(position % Game.GridSize == 0) {
                        queue.add(Grid.tileGrid.get((position + Game.GridSize)));
                        queue.add(Grid.tileGrid.get((position + Game.GridSize + 1)));
                        queue.add(Grid.tileGrid.get((position + 1)));
                    } else if(position % Game.GridSize == Game.GridSize - 1) {
                        queue.add(Grid.tileGrid.get((position + Game.GridSize)));
                        queue.add(Grid.tileGrid.get((position + Game.GridSize - 1)));
                        queue.add(Grid.tileGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.tileGrid.get((position + Game.GridSize)));
                        queue.add(Grid.tileGrid.get((position + Game.GridSize + 1)));
                        queue.add(Grid.tileGrid.get((position + Game.GridSize - 1)));
                        queue.add(Grid.tileGrid.get((position + 1)));
                        queue.add(Grid.tileGrid.get((position - 1)));
                    }
                } else if(position >= (Game.GridSize * (Game.GridSize - 1))) {
                    if(position % Game.GridSize == 0) {
                        queue.add(Grid.tileGrid.get((position - Game.GridSize)));
                        queue.add(Grid.tileGrid.get((position - Game.GridSize + 1)));
                        queue.add(Grid.tileGrid.get((position + 1)));
                    } else if(position % Game.GridSize == Game.GridSize - 1) {
                        queue.add(Grid.tileGrid.get((position - Game.GridSize)));
                        queue.add(Grid.tileGrid.get((position - Game.GridSize - 1)));
                        queue.add(Grid.tileGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.tileGrid.get((position - Game.GridSize)));
                        queue.add(Grid.tileGrid.get((position - Game.GridSize + 1)));
                        queue.add(Grid.tileGrid.get((position - Game.GridSize - 1)));
                        queue.add(Grid.tileGrid.get((position + 1)));
                        queue.add(Grid.tileGrid.get((position - 1)));
                    }
                } else if(position % Game.GridSize == 0) {
                    queue.add(Grid.tileGrid.get((position - Game.GridSize)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize)));
                    queue.add(Grid.tileGrid.get((position - Game.GridSize + 1)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize + 1)));
                    queue.add(Grid.tileGrid.get((position + 1)));
                } else if(position % Game.GridSize == Game.GridSize - 1) {
                    queue.add(Grid.tileGrid.get((position - Game.GridSize)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize)));
                    queue.add(Grid.tileGrid.get((position - Game.GridSize - 1)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize - 1)));
                    queue.add(Grid.tileGrid.get((position - 1)));
                } else {
                    queue.add(Grid.tileGrid.get((position - Game.GridSize)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize)));
                    queue.add(Grid.tileGrid.get((position - Game.GridSize - 1)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize - 1)));
                    queue.add(Grid.tileGrid.get((position - Game.GridSize + 1)));
                    queue.add(Grid.tileGrid.get((position + Game.GridSize + 1)));
                    queue.add(Grid.tileGrid.get((position - 1)));
                    queue.add(Grid.tileGrid.get((position + 1)));
                }
            } else if(tile.getType() == 2) {
                int dangerCount = 0;
                if(position < Game.GridSize) {
                    if(position % Game.GridSize == 0) {
                        if(Grid.tileGrid.get(position + Game.GridSize).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + Game.GridSize + 1).getType() == 1) dangerCount++; 
                        if(Grid.tileGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if(position % Game.GridSize == Game.GridSize - 1) {
                        if(Grid.tileGrid.get(position + Game.GridSize).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + Game.GridSize - 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if(Grid.tileGrid.get(position + Game.GridSize).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + Game.GridSize + 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + Game.GridSize - 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - 1).getType() == 1) dangerCount++;
                        System.out.println(dangerCount);
                    }
                } else if(position >= (Game.GridSize * (Game.GridSize - 1))) {
                    if(position % Game.GridSize == 0) {
                        if(Grid.tileGrid.get(position - Game.GridSize).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - Game.GridSize + 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if(position % Game.GridSize == Game.GridSize - 1) {
                        if(Grid.tileGrid.get(position - Game.GridSize).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - Game.GridSize - 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if(Grid.tileGrid.get(position - Game.GridSize).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - Game.GridSize + 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - Game.GridSize - 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position + 1).getType() == 1) dangerCount++;
                        if(Grid.tileGrid.get(position - 1).getType() == 1) dangerCount++;
                    }
                } else if(position % Game.GridSize == 0) {
                    if(Grid.tileGrid.get(position - Game.GridSize).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get(position + Game.GridSize).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get(position - Game.GridSize + 1).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get(position + Game.GridSize + 1).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get(position + 1).getType() == 1) dangerCount++;
                } else if(position % Game.GridSize == Game.GridSize - 1) {
                    if(Grid.tileGrid.get((position - Game.GridSize)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position + Game.GridSize)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position - Game.GridSize - 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position + Game.GridSize - 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position - 1)).getType() == 1) dangerCount++;
                } else {
                    if(Grid.tileGrid.get((position - Game.GridSize)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position + Game.GridSize)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position - Game.GridSize - 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position + Game.GridSize - 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position - Game.GridSize + 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position + Game.GridSize + 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position - 1)).getType() == 1) dangerCount++;
                    if(Grid.tileGrid.get((position + 1)).getType() == 1) dangerCount++;
                }
                tile.setText(String.valueOf(dangerCount));
            } else if(tile.getType() == 1) {
                for(int x = 0; x < Grid.tileGrid.size(); x++) {
                    Grid.tileGrid.get(x).setEnabled(false);
                    Grid.tileGrid.get(x).setText("");
                    if(Grid.tileGrid.get(x).getType() == 1) {
                        Grid.tileGrid.get(x).setText("X");
                    }
                }
                try{
                    FileWriter appendFile = new FileWriter( "MinesweeperStats.txt", true );
                    PrintWriter fileOutput = new PrintWriter( appendFile );                    
                fileOutput.println( "Loss");

                fileOutput.close();
                }
                catch(IOException ioException){
                    System.err.println( "Java Exception: " + ioException );
                    System.out.println( "Sorry, error with output file MinesweeperStats.txt." );
                } 
                playing=false;       
            }  

            for(int x = 0; x < queue.size(); x++) {
                if(!queue.get(x).isDiscovered()) {
                    current.add(queue.get(x));
                    queue.get(x).setDiscovered(true);
                }
            }
            queue.clear();
            while(!current.isEmpty()) {
                Tile temp = current.get(0);
                current.remove(0);
                temp.clickButton();
            }

            for(int x = 0; x < Grid.tileGrid.size(); x++) {
                if(Grid.tileGrid.get(x).isDiscovered()) {
                    discoveredTiles++;
                }
            }

            if(discoveredTiles == Grid.tileGrid.size() - Game.MineCount) {
                for(int x = 0; x < Grid.tileGrid.size(); x++) {
                    if(Grid.tileGrid.get(x).getType() == 1) {
                        Grid.tileGrid.get(x).setEnabled(false);
                        Grid.tileGrid.get(x).setText("X");
                    } else {
                        Grid.tileGrid.get(x).setEnabled(false);
                        Grid.tileGrid.get(x).setText(":)");
                    }
                }
                playing=false;
                try{
                    FileWriter appendFile = new FileWriter( "MinesweeperStats.txt", true );
                    PrintWriter fileOutput = new PrintWriter( appendFile );                    
                fileOutput.println( "Win");

                fileOutput.close();
                }
                catch(IOException ioException){
                    System.err.println( "Java Exception: " + ioException );
                    System.out.println( "Sorry, error with output file MinesweeperStats.txt." );
                }     
            }
        }   
    }

    public void rightClick(Tile tile) {

        if(!tile.isDiscovered()&&playing) {
            if(!tile.isFlagged()) {
                tile.setFlagged(true);
                tile.setIcon(Tile.icon);
                flaggedTiles++;
                Window.update(flaggedTiles);
            } else {
                tile.setFlagged(false);
                tile.setIcon(null);
                flaggedTiles--;
                Window.update(flaggedTiles);
            }
        }
    }
}
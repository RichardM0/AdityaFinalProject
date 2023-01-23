package Minesweeper;


import java.io.IOException;
import java.io.File;
import java.util.Scanner;


import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.*;

public class Window {
    private static JFrame frame;
    private static String title;

    public Window(int Width,int Height, int GridSize, String title, Game game , Handler handler){
        Window.title=title;
        frame=new JFrame (title);
        frame.setPreferredSize(new Dimension(Width,Height));
        frame.setMinimumSize(new Dimension(Width,Height));
        frame.setMaximumSize(new Dimension(Width,Height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel=new Grid(new GridLayout(GridSize,GridSize),handler);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void update(int flagged) {
        int WinCount=0;
        int LossCount=0;

        try {
            Scanner fileInput = new Scanner( new File("MinesweeperStats.txt") );
            while ( fileInput.hasNext() ) {
                    String word= fileInput.nextLine();
                    if (word.equals("Win")){
                        WinCount++;
                    }
                    else if(word.equals("Loss")){
                        LossCount++;
                    }
            }
            fileInput.close();
        }
        catch ( IOException ioException ) {
            System.err.println( "Java Exception: " + ioException);
            System.out.println( "Sorry, unable to open the randInt.txt file for reading." );
        }

        frame.setTitle(title + " Mines: " + Game.MineCount + " - Flags: " + flagged+" - Win Count: "+ WinCount+" - Loss Count: "+ LossCount);
    }
}

package Minesweeper;

import java.awt.event.*;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;


public class Tile extends JButton{
    //type of square
    private int type;
    //position of tile
    private int position;
    //if cell has been clicked on
    private boolean discovered;
    //if cell has been flagged or not
    private boolean flagged;

    public static ImageIcon icon = new ImageIcon("RedFlag.png");

    private Handler handler;
    //Constructor
    public Tile(int type, int position, boolean discovered, boolean flagged, Handler handler){
        this.type=type;
        this.position= position;
        this.discovered = discovered;
        this.flagged=flagged;
        this.handler=handler;

        Image image = icon.getImage().getScaledInstance((Game.Width-20)/10,(Game.Height-20)/10, Image.SCALE_SMOOTH);
        icon.setImage(image);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    rightClickButton();
                }

                else{
                    clickButton();
                }
            }
                
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });

    }

    public int getType(){
        //0 is empty, 1 is a mine, 2 is a number 
        return type;

    }
    public int getPosition(){
        //accesssor
        return position;
        
    }
    public boolean isDiscovered(){
        //acessor
        return discovered;
        
    }
    public void setDiscovered(boolean d){
        //mutator
        setIcon(null);
        this.discovered=d;
    }
    public boolean isFlagged(){
        //accessor
        return flagged;
        
    }public void setFlagged(boolean f){
        //mutator for flagged variable
        this.flagged=f;
    }
    public void clickButton(){
        handler.click(this);
    }
    public void rightClickButton(){
        handler.rightClick(this);
    }
}
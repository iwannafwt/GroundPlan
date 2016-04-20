package toolboxPanel.rectangleForToolBox;

import java.awt.Graphics;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface IRectangleForToolBox {
    

    public void paintComponent(Graphics g); 
    public void doRepaint();
    public void reSet(int X , int Y);
}

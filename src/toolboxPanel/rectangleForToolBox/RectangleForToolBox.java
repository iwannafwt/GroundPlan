package toolboxPanel.rectangleForToolBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class RectangleForToolBox extends JPanel implements IRectangleForToolBox {
    private RectangleConst rectangle;

    public RectangleForToolBox() {

        initializeShape();
    }

    public void initializeShape() {

        rectangle = new RectangleConst(50, 50, 50, 50);//i thesi pou tha briskete 
        //to tetragwno
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Serif", Font.BOLD, 40);
        g2d.setFont(font);

        //i dimiourgia tou tetragwnou
        g2d.setPaint(new Color(0, 0, 100));// to xrwmma pou tha exei to tetragwno
        g2d.fill(rectangle);
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
    
    public void doRepaint(){
        
        repaint();
    }
    
    public void reSet(int X , int Y){
        
        rectangle.x = X;
        rectangle.y = Y;
    }
}

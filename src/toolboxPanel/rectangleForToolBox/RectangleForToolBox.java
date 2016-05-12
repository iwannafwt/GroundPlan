package toolboxPanel.rectangleForToolBox;

import CanvasToDraw.WithShape.shape.IItems;
import CanvasToDraw.WithShape.shape.NewRectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import mainFrame.BaseFrame;
import toolboxPanel.mouseAdapter.MouseEventsForToolBox;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class RectangleForToolBox extends JPanel implements IRectangleForToolBox {
    
    private final List<RectangleConst> myItems = new ArrayList<>();
    private final BaseFrame BASEFRAME;
    
    public RectangleForToolBox(BaseFrame BaseFrame) {
        this.BASEFRAME = BaseFrame;
        initializeShape();
    }

    @Override
    public void sendNewRegister(IItems newItem){
        BASEFRAME.registerToCanvas(newItem);
    }
    
    public void initializeShape() {
       myItems.add( new RectangleConst(50, 50, 50, 50));//i thesi pou tha briskete 
        
        
        addMouseListener(new MouseEventsForToolBox(new NewRectangle( 
              new Point(200, 200), new Point(310, 310), 8),this));
        //to tetragwno
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //i dimiourgia tou tetragwnou
        g2d.setPaint(new Color(0, 0, 100));// to xrwmma pou tha exei to tetragwno
        for(RectangleConst vLookUp:myItems){
            g2d.fill(vLookUp);
        }
        
   }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
    
    @Override
    public void doRepaint(){
        repaint();
    }
    
    @Override
    public List<RectangleConst> getItems(){
        return myItems;
    }
}

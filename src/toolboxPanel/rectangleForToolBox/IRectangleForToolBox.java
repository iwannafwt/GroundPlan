package toolboxPanel.rectangleForToolBox;

import CanvasToDraw.WithShape.shape.IItems;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface IRectangleForToolBox {
    
    public void sendNewRegister(IItems newItem);

    public void paintComponent(Graphics g); 
    public void doRepaint();
    public List<Rectangle> getItems();
}

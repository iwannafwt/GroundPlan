package toolboxPanel.mouseAdapter;

import CanvasToDraw.WithShape.shape.IItems;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import toolboxPanel.rectangleForToolBox.IRectangleForToolBox;
import toolboxPanel.rectangleForToolBox.RectangleConst;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseEventsForToolBox implements MouseListener{
    private final IItems Iitems ; 
    private final IRectangleForToolBox IRectangleForToolBox;
    
    public MouseEventsForToolBox(IItems myItem,IRectangleForToolBox IRectangleForToolbox){
        this.IRectangleForToolBox = IRectangleForToolbox;
        this.Iitems = myItem;
    }
    
    boolean clicked;

    @Override
    public void mouseClicked(MouseEvent e) {
        for(RectangleConst vLookUp:IRectangleForToolBox.getItems()){
            if(vLookUp.isHit(e.getX(), e.getY())){
                IRectangleForToolBox.sendNewRegister(Iitems);      
            }
        }       
 
        clicked = true;
        
       System.out.println("einai ston MouseEvent For ToolBox");
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public boolean isClicked(){
        
        return clicked;
    } 
}

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
    private final IItems r ; 
    private final IRectangleForToolBox IRF;
    
    public MouseEventsForToolBox(IItems r,IRectangleForToolBox IRF){
        this.IRF = IRF;
        this.r = r;
    }
    
    boolean clicked;

    @Override
    public void mouseClicked(MouseEvent e) {
        for(RectangleConst vLookUp:IRF.getItems()){
            if(vLookUp.isHit(e.getX(), e.getY())){
                IRF.sendNewRegister(r);      
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

package CanvasToDraw.WithShape.mouse;

import CanvasToDraw.WithShape.shape.IItems;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import CanvasToDraw.WithShape.shape.ICanvas;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseAdapterForResize extends MouseAdapter{
    
    private final ICanvas myResizeToHandle;
    
    public MouseAdapterForResize(ICanvas myResizeToHandle){
        this.myResizeToHandle = myResizeToHandle;
    }
    
    @Override
    public void mousePressed(MouseEvent event) {
        int container = 0;
        int inner;
        Point p = event.getPoint();

        for(IItems vLookUp:myResizeToHandle.getItems()){
            inner = 0;
            for(Point2D vLookUp2:vLookUp.getPoints()){
                //edw entopizei pou briskete ta mikra rectangle
                double x = vLookUp2.getX() - vLookUp.getSize() / 2;
                double y = vLookUp2.getY() - vLookUp.getSize() / 2;
                
                //dimiourgei ena eikoniko rectangle
                Rectangle2D r = new Rectangle2D.Double(x, y,
                    myResizeToHandle.getSIZE(), myResizeToHandle.getSIZE());
            
                if (r.contains(p)) {
                    myResizeToHandle.setUndo();

                    myResizeToHandle.setPos(container);
                    myResizeToHandle.setPosCorner(inner);
                    return;
                } else {
                    inner++;
                }
            }
            container++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        myResizeToHandle.setPos(-1);
        myResizeToHandle.setPosCorner(-1);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (myResizeToHandle.getPos() == -1 || myResizeToHandle.getPosCorner() == -1) {
            return;
        }
//        System.out.println("old : " + myResizeToHandle.getPoints()[myResizeToHandle.getPos()]);
//        System.out.println(event.getPoint());
        myResizeToHandle.getItems().get(myResizeToHandle.getPos())
                .getPoints().set(myResizeToHandle.
                        getPosCorner(),event.getPoint());
                                    //auti i grammi pairnei ton pinaka 
                                    //kai paei kai bazei ti kainourgia thesi
                                    //pou piraksame
//        System.out.println("new : " + myResizeToHandle.getPoints()[myResizeToHandle.getPos()]);
        
        myResizeToHandle.doUpdate();
    }
}

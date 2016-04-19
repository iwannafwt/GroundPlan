package CanvasToDraw.WithShape.mouse;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import CanvasToDraw.WithShape.shape.IRectangle;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseAdapterForResize extends MouseAdapter{
    
    private final IRectangle myResizeToHandle;
    
    public MouseAdapterForResize(IRectangle myResizeToHandle){
        this.myResizeToHandle = myResizeToHandle;
    }
    
    @Override
    public void mousePressed(MouseEvent event) {
        
        Point p = event.getPoint();

        for (int i = 0; i < myResizeToHandle.getPoints().length; i++) {
            //edw entopizei pou briskete ta mikra rectangle
            double x = myResizeToHandle.getPoints()[i].getX()
                    - myResizeToHandle.getSIZE() / 2;
            double y = myResizeToHandle.getPoints()[i].getY() 
                    - myResizeToHandle.getSIZE() / 2;
            
            //dimiourgei ena eikoniko rectangle
            Rectangle2D r = new Rectangle2D.Double(x, y,
                    myResizeToHandle.getSIZE(), myResizeToHandle.getSIZE());

            if (r.contains(p)) {

                myResizeToHandle.setPos(i);
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        myResizeToHandle.setPos(-1);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (myResizeToHandle.getPos() == -1) {
            return;
        }
//        System.out.println("old : " + myResizeToHandle.getPoints()[myResizeToHandle.getPos()]);
//        System.out.println(event.getPoint());
        myResizeToHandle.getPoints()[myResizeToHandle.getPos()] 
                = event.getPoint();//auti i grammi pairnei ton pinaka 
                                    //kai paei kai bazei ti kainourgia thesi
                                    //pou piraksame
//        System.out.println("new : " + myResizeToHandle.getPoints()[myResizeToHandle.getPos()]);
        
        myResizeToHandle.doUpdate();
    }
}

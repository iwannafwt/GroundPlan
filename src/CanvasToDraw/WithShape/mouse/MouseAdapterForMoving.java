package CanvasToDraw.WithShape.mouse;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import CanvasToDraw.WithShape.shape.ICanvas;
import CanvasToDraw.WithShape.shape.IItems;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseAdapterForMoving extends MouseAdapter {

    private final ICanvas iResizeHandle;
    private Point2D oldP;

    public MouseAdapterForMoving(ICanvas iResizeHandle) {
        this.iResizeHandle = iResizeHandle;
    }

    @Override
    public void mousePressed(MouseEvent event) {

        Point eventPoint = event.getPoint();
        oldP = event.getPoint();//blepw pou einai to pontiki->Pressed
        iResizeHandle.startMovingItemContainingPoint(eventPoint);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        iResizeHandle.setItemToMove(null);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (iResizeHandle.hasSomethingToMove()) {

            Point2D p3 = new Point();

            p3.setLocation(event.getPoint().getX() - oldP.getX(),
                    event.getPoint().getY() - oldP.getY());
            oldP = event.getPoint();//auto einai to kainourgio Pressed

            Point2D pToGo = new Point();
            pToGo.setLocation(
                    iResizeHandle.getItemToMove()
                    .getPoints().get(0).getX() + p3.getX(),
                    iResizeHandle.getItemToMove()
                    .getPoints().get(0).getY() + p3.getY());
            iResizeHandle.getItemToMove()
                    .getPoints().set(0, new Point((Point) pToGo));

            pToGo.setLocation(
                    iResizeHandle.getItemToMove()
                    .getPoints().get(1).getX() + p3.getX(),
                    iResizeHandle.getItemToMove()
                    .getPoints().get(1).getY() + p3.getY());
            iResizeHandle.getItemToMove()
                    .getPoints().set(1, new Point((Point) pToGo));

            iResizeHandle.doUpdate();
        }
    }
}

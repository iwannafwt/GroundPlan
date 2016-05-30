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

    private final ICanvas iCanvas;
    private Point2D oldP;

    public MouseAdapterForMoving(ICanvas iResizeHandle) {
        this.iCanvas = iResizeHandle;
    }

    @Override
    public void mousePressed(MouseEvent event) {

        Point eventPoint = event.getPoint();
        oldP = event.getPoint();//blepw pou einai to pontiki->Pressed
        iCanvas.startMovingItemContainingPoint(eventPoint);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        iCanvas.setItemToMove(null);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (iCanvas.hasSomethingToMove()) {

            Point2D p3 = new Point();

            p3.setLocation(event.getPoint().getX() - oldP.getX(),
                    event.getPoint().getY() - oldP.getY());
            oldP = event.getPoint();//auto einai to kainourgio Pressed

            Point2D pToGo = new Point();
            pToGo.setLocation(iCanvas.getItemToMove()
                    .getPoints().get(0).getX() + p3.getX(),
                    iCanvas.getItemToMove()
                    .getPoints().get(0).getY() + p3.getY());
            iCanvas.getItemToMove()
                    .getPoints().set(0, new Point((Point) pToGo));

            pToGo.setLocation(iCanvas.getItemToMove()
                    .getPoints().get(1).getX() + p3.getX(),
                    iCanvas.getItemToMove()
                    .getPoints().get(1).getY() + p3.getY());
            iCanvas.getItemToMove()
                    .getPoints().set(1, new Point((Point) pToGo));

            iCanvas.doUpdate();
        }
    }
}

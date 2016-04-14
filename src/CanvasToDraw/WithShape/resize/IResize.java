package CanvasToDraw.WithShape.resize;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.geom.Point2D;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface IResize {

    void doUpdate();

    Point2D[] getPoints();

    int getPos();

    int getSIZE();

    void paintComponent(Graphics g);

    void setPoints(Point2D[] points);

    void setPos(int pos);
    
    public void registerListeners(MouseAdapter MA );
    
    int getPosForItem();
    
    void setPosForItem(int posForItem);
}

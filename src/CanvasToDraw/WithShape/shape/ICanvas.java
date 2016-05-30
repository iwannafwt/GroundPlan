package CanvasToDraw.WithShape.shape;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public interface ICanvas {

    void doUpdate();
    void registerItem(IItems newItem);
    int getPosCorner();
    void setPosCorner(int posCorner);
    
//    List<Point2D> getPoints();
    
    List<IItems> getItems();
    void setItems(IItems newItem);

    int getPos();

    int getSIZE();

    void paintComponent(Graphics g);

//    void setPoints(List<Point2D> points);

    void setPos(int pos);
    
    public void registerMouseListeners(MouseAdapter MA );
        
    IItems getItemToMove();
    
    void setItemToMove(IItems item);
    
    boolean hasSomethingToMove();
  
    
    public boolean undo();    
    public boolean redo();
    public void setUndo();
    public void startMovingItemContainingPoint(Point2D point);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolboxPanel.mouseAdapter;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseListenerForRectangle implements MouseMotionListener{

    Point p;
    
    @Override
    public void mouseDragged(MouseEvent e) {
        p = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    public Point getP(){        
        return p;
    }
    
}

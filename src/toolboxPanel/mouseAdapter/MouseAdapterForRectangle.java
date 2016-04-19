package toolboxPanel.mouseAdapter;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import toolboxPanel.rectangleForToolBox.RectangleForToolBox;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class MouseAdapterForRectangle extends MouseAdapter {

    RectangleForToolBox r = new RectangleForToolBox();

    @Override
    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent event) {

        r.setPos(-1);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
    }
}

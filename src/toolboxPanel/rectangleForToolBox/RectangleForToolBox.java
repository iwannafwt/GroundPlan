package toolboxPanel.rectangleForToolBox;

import com.sun.pisces.Surface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class RectangleForToolBox extends JPanel implements IRectangleForShape{
    private int pos;
            
    //<editor-fold desc="GettersSetters" defaultstate="collapsed">

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    //</editor-fold>
    
    public void registerListeners(MouseAdapter MA) {//prosthetoume tous listener
        addMouseListener(MA);//sinartisi tou JPanel
        addMouseMotionListener(MA);//sinartisi tou JPanel
    }

    private void doDrawing(Graphics g) {
        pos = -1;

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(new Color(150, 150, 150));

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.fillRect(30, 20, 50, 50);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

}

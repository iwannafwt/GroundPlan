package CanvasToDraw.WithShape.shape;

import CanvasToDraw.WithShape.background.Background;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Rectangle extends JPanel implements IRectangle {

    private Point2D[] points;
    private final int SIZE = 8;//to megethos apo to mikro tetragwnaki
    private int pos;
    private int posForItem;

    //<editor-fold desc="GettersSetters" defaultstate="collapsed">
    @Override
    public Point2D[] getPoints() {
        return points;
    }

    public int getPosForItem() {
        return posForItem;
    }

    public void setPosForItem(int posForItem) {
        this.posForItem = posForItem;
    }

    @Override
    public int getSIZE() {
        return SIZE;
    }

    @Override
    public int getPos() {
        return pos;
    }

    @Override
    public void setPoints(Point2D[] points) {
        this.points = points;
    }

    @Override
    public void setPos(int pos) {
        this.pos = pos;
    }

    //</editor-fold>
    public Rectangle(int x1, int x2, int y1, int y2) {
        initUI(x1, x2, y1, y2);
    }

    @Override
    public void registerListeners(MouseAdapter MA) {//prosthetoume tous listener
        addMouseListener(MA);//sinartisi tou JPanel
        addMouseMotionListener(MA);//sinartisi tou JPanel
    }
    NewRectangle small;
    NewRectangle large;

    private void initUI(int x1, int x2, int y1, int y2) {

        posForItem = -1;
        pos = -1;//otan to position einai -1 simenei oti exoume 
        //kseklikarei to pontiki 
        small = new NewRectangle(new Point(x1, y1), new Point(x2, y2), 8);
        large = new NewRectangle(new Point(x1 * 2, y1 * 2), new Point(x2 * 2, y2 * 2), 8);

        /*ta point enai i diagwnios
         *--------*
         |        |
         |        |
         |        |
         |        |
         *--------*
         */
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.red);//to xrwmma apo ta mikra ta tetragwnakia

        setBackground(Color.gray);

        small.doDrawing(g);
        large.doDrawing(g);

        Background backGround = new Background();

        backGround.backgroundColour(1500, 1500, 80, 80, g2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void doUpdate() {
        repaint();
    }

}

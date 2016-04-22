package CanvasToDraw.WithShape.shape;

import CanvasToDraw.WithShape.background.Background;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class Rectangle  extends JPanel implements IRectangle  {
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

    public Rectangle(int x1, int x2 , int y1 , int y2){
        initUI(x1,x2,y1,y2);
    }

    @Override
    public void registerListeners(MouseAdapter MA ){//prosthetoume tous listener
        addMouseListener(MA);//sinartisi tou JPanel
        addMouseMotionListener(MA);//sinartisi tou JPanel
    }

    private void initUI(int x1, int x2 , int y1 , int y2) {

        posForItem = -1;
        pos = -1;//otan to position einai -1 simenei oti exoume 
                 //kseklikarei to pontiki
       
        points = new Point2D[4];
        points[0] = new Point2D.Double(x1, y1);
        points[1] = new Point2D.Double(x2, y2);
        /*ta point enai i diagwnios
         *--------*
         |        |
         |        |
         |        |
         |        |
         *--------*
        */
        //to deutero tetragwno
        points[2] = new Point2D.Double(x1*2, y1*2);
        points[3] = new Point2D.Double(x2*2, y2*2);
        
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.red);//to xrwmma apo ta mikra ta tetragwnakia
        Rectangle2D r = new Rectangle2D.Double();
        
        for (Point2D point : points) {//to mikro tetragwno
            //einai to kentro tou mikrou tetragwnou
            double x = point.getX() - SIZE / 2;
            double y = point.getY() - SIZE / 2;
            r.setFrame(x, y, SIZE, SIZE);//to Frame tou orizei ti megethos tha exei
            g2.fill(r);
        }
        
        for(int i =0 ; i < points.length ; i = i + 2 ){ //me ti kathe epanalipsi 
                                                        //dimiourgite kai ena tetragwno.gi auto einai ana 2         
            r.setFrameFromDiagonal(points[i], points[i+1]); 
            g2.setPaint(new Color(0, 0, 100));// to xrwmma pou tha exei to tetragwno
            g2.fill(r);//gemizei to tetragwno
            g2.draw(r);//kanei to perigramma tou tetragwnou
        
        setBackground(Color.gray);
         
        Background backGround = new Background();
        
        backGround.backgroundColour(1500, 1500, 80 , 80, g2);
        
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void doUpdate(){
        repaint();
    }

}

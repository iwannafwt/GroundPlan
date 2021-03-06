package CanvasToDraw.WithShape.shape;

import CanvasToDraw.WithShape.background.Background;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseCanvas extends JPanel implements ICanvas {
    
    private List<IItems> myItems = new ArrayList<>();
    
    private List<IItems> undoItems = new ArrayList<>();
    private List<IItems> redoItems = new ArrayList<>();
    
    private final int SIZE = 8;//to megethos apo to mikro tetragwnaki
    private int pos;
    private int posCorner;
    private int posForItem;
    
    private IItems rect;
    private IItems large;
    
    //<editor-fold desc="GettersSetters" defaultstate="collapsed">

    @Override
    public int getPosForItem() {
        return posForItem;
    }

    @Override
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
    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public int getPosCorner() {
        return posCorner;
    }

    @Override
    public void setPosCorner(int posCorner) {
        this.posCorner = posCorner;
    }
    
    //</editor-fold>
    
    public BaseCanvas(int x1, int x2, int y1, int y2) {
        initUI(x1, x2, y1, y2);
    }

    @Override
    public boolean undo(){
        if(undoItems == null || undoItems.isEmpty()) {
            return false;
        }
        redoItems.clear();        
        for(IItems vLookUp:myItems){
            redoItems.add(vLookUp.reCreate());
        }
        
        myItems.clear(); 
        for(IItems vLookUp:undoItems){
            myItems.add(vLookUp.reCreate());
        }
        
        doUpdate();
        
        return true;        
    }
    
    @Override
    public boolean redo(){
        if(redoItems == null || redoItems.isEmpty()) {
            return false;
        }        
        myItems.clear(); 
        for(IItems vLookUp:redoItems){
            myItems.add(vLookUp.reCreate());
        }
        doUpdate();
        
        return true;
    }
    
    @Override
    public void registerMouseListeners(MouseAdapter MA) {//prosthetoume tous listener
        addMouseListener(MA);//sinartisi tou JPanel
        addMouseMotionListener(MA);//sinartisi tou JPanel
    }

    private void initUI(int x1, int x2, int y1, int y2) {

        posForItem = -1;
        pos = -1;//otan to position einai -1 simenei oti exoume 
        //kseklikarei to pontiki 
        rect = new NewRectangle(new Point(x1, y1), new Point(x2, y2), 8);
        large = new NewRectangle(new Point(x1 * 2, y1 * 2), new Point(x2 * 2, y2 * 2), 8);
        
        setItems(rect);
        setItems(large);
        setUndo();
        /*ta point enai i diagwnios
         *--------*
         |        |
         |        |
         |        |
         |        |
         *--------*
         */
    }
    
    @Override
    public void registerItem(IItems t) {
        setUndo();
        setItems(t.reCreate()); //kanoume reCreate gia na spasoume to reference
        doUpdate(); 
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Background backGround = new Background();

        backGround.backgroundColour(1500, 1500, 80, 80, g2);
        

        g2.setColor(Color.red);//to xrwmma apo ta mikra ta tetragwnakia

        setBackground(Color.gray);
        
        for(IItems vLookUp:myItems){
            vLookUp.doDrawing(g2);
        }
//        rect.doDrawing(g);
//        large.doDrawing(g);

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
    
    @Override 
    public List<IItems> getItems(){
        return myItems;
    }
    
    @Override 
    public void setItems(IItems newItem){
        myItems.add(newItem);
    }
    
    @Override
    public void setUndo(){
        undoItems.clear();
        for(IItems vLookUp:myItems){
            undoItems.add(vLookUp.reCreate());
        }
    }
}

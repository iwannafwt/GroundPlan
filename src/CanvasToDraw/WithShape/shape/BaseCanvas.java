package CanvasToDraw.WithShape.shape;

import CanvasToDraw.WithShape.background.Background;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseCanvas extends JPanel implements ICanvas {
    
    private List<IItems> myItemsList = new ArrayList<>();
    
    private List<IItems> undoItemsList = new ArrayList<>();
    private List<IItems> redoItemsList = new ArrayList<>();
    
    private final int SIZE = 8;//to megethos apo to mikro tetragwnaki
    private int pos;
    private int posCorner;
    private int posForItem;
    
    private IItems rectangleOne;
    private IItems rectangleTwo;
    
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
        if(undoItemsList == null || undoItemsList.isEmpty()) {
            return false;
        }
        redoItemsList.clear(); //katharizei ti lista redo gia na parei ts kainourgies times       
        for(IItems vLookUp:myItemsList){
            redoItemsList.add(vLookUp.reCreate());//sti lista redo krataei ta 
                                                  //points pou exoun ta tetragwna epanw sto canva
        }
        
        myItemsList.clear(); //katharizei ti lista apo ta items
        for(IItems vLookUp:undoItemsList){
            myItemsList.add(vLookUp.reCreate());//prosthetei mesa sti list myItems 
                                                //ta point pou exei i lista undo
        }
        
        doUpdate();
        
        return true;        
    }
    
    @Override
    public boolean redo(){
        if(redoItemsList == null || redoItemsList.isEmpty()) {
            return false;
        }        
        myItemsList.clear(); 
        for(IItems vLookUp:redoItemsList){
            myItemsList.add(vLookUp.reCreate());
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
        rectangleOne = new NewRectangle(new Point(x1, y1), new Point(x2, y2), 8);
        rectangleTwo = new NewRectangle(new Point(x1 * 2, y1 * 2), new Point(x2 * 2, y2 * 2), 8);
        
        setItems(rectangleOne);
        setItems(rectangleTwo);
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
        
        for(IItems vLookUp:myItemsList){
            vLookUp.doDrawing(g2);
        }
//        rectangleOne.doDrawing(g);
//        rectangleTwo.doDrawing(g);

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
    /*----------------Service------------------------*/
    @Override 
    public List<IItems> getItems(){
        return myItemsList;
    }
    
    @Override 
    public void setItems(IItems newItem){
        myItemsList.add(newItem);
    }
    
    @Override
    public void setUndo(){
        undoItemsList.clear();
        for(IItems vLookUp:myItemsList){
            undoItemsList.add(vLookUp.reCreate());
        }
    }
}

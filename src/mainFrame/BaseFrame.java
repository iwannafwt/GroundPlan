package mainFrame;

import CanvasToDraw.WithShape.mouse.KeyBoardListenerUndRed;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import CanvasToDraw.WithShape.mouse.MouseAdapterForMoving;
import CanvasToDraw.WithShape.mouse.MouseAdapterForResize;
import CanvasToDraw.WithShape.shape.BaseCanvas;
import CanvasToDraw.WithShape.shape.IItems;
import java.awt.Panel;
import toolboxPanel.rectangleForToolBox.RectangleForToolBox;
import toolboxPanel.rectangleForToolBox.splitToolBox;
import CanvasToDraw.WithShape.shape.ICanvas;
import toolboxPanel.rectangleForToolBox.IRectangleForToolBox;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class BaseFrame extends JFrame{
    protected JSplitPane split;
    private ICanvas BaseCanvas;
    private IRectangleForToolBox toolBox;
    
    public BaseFrame()  {        
        initUI();
    }
    
    public void registerToCanvas(IItems newItem){
        if(BaseCanvas != null) {
            BaseCanvas.registerItem(newItem);
        }
    }
    
    private void initUI() {
        BaseCanvas = new BaseCanvas(150,50,150,100);//diastaseis apo ta tetragwnakia
        toolBox = new RectangleForToolBox(this);
        
        BaseCanvas.registerMouseListeners(new MouseAdapterForResize(BaseCanvas));
        BaseCanvas.registerMouseListeners(new MouseAdapterForMoving(BaseCanvas));
        addKeyListener(new KeyBoardListenerUndRed(this));
        
        if(BaseCanvas instanceof JPanel){
            
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,  (JPanel)toolBox , (JPanel)BaseCanvas);
        split.setContinuousLayout(false);
        split.setOneTouchExpandable(false);

        getContentPane().add(split, BorderLayout.CENTER);

        }else {
            System.out.println("An Error occured when trying registering the IResize.");
            System.exit(2);
        }
        

        setTitle("Ground Plan");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);    
        
        
    }
    
    public void redo(){
        BaseCanvas.redo();
    }
    
    public void undo(){
        BaseCanvas.undo();
    }
}

package mainFrame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import CanvasToDraw.WithShape.mouse.MouseAdapterForMoving;
import CanvasToDraw.WithShape.mouse.MouseAdapterForResize;
import CanvasToDraw.WithShape.shape.BaseCanvas;
import CanvasToDraw.WithShape.shape.IRectangle;
import toolboxPanel.rectangleForToolBox.RectangleForToolBox;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class ResizingRectangle extends JFrame{
    protected JSplitPane split;
    
    public ResizingRectangle()  {
        
        initUI();
    }
    
    private void initUI() {
        IRectangle IR = new BaseCanvas(150,50,150,100);//diastaseis apo ta tetragwnakia
        RectangleForToolBox r = new RectangleForToolBox();
        
        IR.registerListeners(new MouseAdapterForResize(IR));
        IR.registerListeners(new MouseAdapterForMoving(IR));
        

        if(IR instanceof JPanel){
            
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,  r , (JPanel)IR);
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
    
}

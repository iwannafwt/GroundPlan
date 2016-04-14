package mainFrame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import CanvasToDraw.WithShape.mouse.MouseAdapterForMoving;
import CanvasToDraw.WithShape.mouse.MouseAdapterForResize;
import CanvasToDraw.WithShape.resize.IResize;
import CanvasToDraw.WithShape.resize.Resize;

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
        IResize IR = new Resize(150,50,150,100);//diastaseis apo ta tetragwnakia
        
        IR.registerListeners(new MouseAdapterForResize(IR));
        IR.registerListeners(new MouseAdapterForMoving(IR));
        
        if(IR instanceof JPanel){
            
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,  new JPanel() , (JPanel)IR);
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
        setLocationRelativeTo(null);    
        
        
    }
    
}

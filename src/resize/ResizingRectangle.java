package resize;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mouse.MouseAdapterForMoving;
import mouse.MouseAdapterForResize;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class ResizingRectangle extends JFrame{
    public ResizingRectangle()  {
        
        initUI();
    }
    
    private void initUI() {
        IResize IR = new Resize(250,50,150,100);
        
        IR.registerListeners(new MouseAdapterForResize(IR));
        IR.registerListeners(new MouseAdapterForMoving(IR));
        
        if(IR instanceof JPanel){
            add((JPanel)IR);
        }else {
            System.out.println("An Error occured when trying registering the IResize.");
            System.exit(2);
        }
        

        setTitle("Resize rectangle");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
    }
    
}

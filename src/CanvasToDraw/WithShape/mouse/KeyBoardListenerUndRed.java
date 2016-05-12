/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CanvasToDraw.WithShape.mouse;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import mainFrame.BaseFrame;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
public class KeyBoardListenerUndRed extends KeyAdapter{
    private final BaseFrame baseFrame;

    public KeyBoardListenerUndRed(BaseFrame baseFrame) {
        this.baseFrame = baseFrame;
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            baseFrame.undo();//redo sinartisi pou kaname emeis st baseFrame
        } else if ((e.getKeyCode() == KeyEvent.VK_U) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            baseFrame.redo();//redo sinartisi pou kaname emeis st baseFrame
        }
    }
    
}

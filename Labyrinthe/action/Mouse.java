package action;

import java.awt.event.*;
import view.Choice;
import javax.swing.*;

/**
 * KeyHandler
 */
public class Mouse implements MouseListener{
    Choice ch;
    JButton btn;

    public Mouse(Choice ch, JButton btn) {
        this.ch = ch;
        this.btn = btn;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        String title = this.btn.getText();
        switch (title) {
            case "Creer une partie":
                this.ch.setHost(true);
                break;
                
            case "Joindre une partie":
                this.ch.setHost(false);
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    

}
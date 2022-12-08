package view;

import java.awt.Color;
import java.net.Socket;
import javax.swing.JFrame;
import object.Player;
import runnable.Position;

public class Frame extends JFrame{
    GamePanel game;
    public Frame(String title,Socket client,boolean isHost) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(768, 576);
        Player me = null;
        if (!isHost) {
            me = new Player("Client",2);
            me.setPosY(504);
            me.setPosX(288);
        } else {
            me = new Player("Server",1);
            me.setPosY(504);
            me.setPosX(240);
        }
        this.setBackground(Color.BLACK);
        this.game = new GamePanel(client, me,new Position(client, this), this);
        this.add(this.game);
        this.game.startGameThread();
        // this.addKeyListener(new MoveListener(client, me));
        this.setVisible(true);
        //me.addKeyListener(new MoveListener(me));
    }
    public GamePanel getGame() {
        return game;
    }
    public void setGame(GamePanel game) {
        this.game = game;
    }

    
    
}

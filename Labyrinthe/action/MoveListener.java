package action;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import object.Player;
import runnable.Position;
import view.GamePanel;

public class MoveListener implements KeyListener{
    Player me;
    Socket reseau;
    GamePanel game;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    boolean end = false;
    
    public MoveListener(Socket socket,Player me,GamePanel game) {
        this.me = me;
        this.reseau = socket;
        this.game = game;
        System.out.println("listener added");
        this.end = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("PLayer "+me.getNom()+" is moving");
        String key = getKeyText(e);
        if (key.equals("z")) {
            upPressed = true;
            try {
                // dataOut = new DataOutputStream(this.reseau.getOutputStream());
                // dataOut.writeUTF("deplace:"+me.getNom()+" to x="+this.game.getPlayer().getPosX()+" y="+this.game.getPlayer().getPosY());
            } catch (Exception E) {
                System.out.println("error2="+E);
            }
        }
        if (key.equals("s")) {
            downPressed = true;
            try {
                // dataOut = new DataOutputStream(this.reseau.getOutputStream());
                // dataOut.writeUTF("deplace:"+me.getNom()+" to x="+this.game.getPlayer().getPosX()+" y="+this.game.getPlayer().getPosY());
            } catch (Exception E) {
                System.out.println("error2="+E);
            }
        }
        if (key.equals("q")) {
            leftPressed = true;
            try {
                // dataOut = new DataOutputStream(this.reseau.getOutputStream());
                // dataOut.writeUTF("deplace:"+me.getNom()+" to x="+this.game.getPlayer().getPosX()+" y="+this.game.getPlayer().getPosY());
            } catch (Exception E) {
                System.out.println("error2="+E);
            }
        }
        if (key.equals("d")) {
            rightPressed = true;
            try {
                // dataOut = new DataOutputStream(this.reseau.getOutputStream());
                // dataOut.writeUTF("deplace:"+me.getNom()+" to x="+this.game.getPlayer().getPosX()+" y="+this.game.getPlayer().getPosY());
            } catch (Exception E) {
                System.out.println("error2="+E);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String key = getKeyText(e);
        if (key.equals("z")) {
            upPressed = false;
        }
        if (key.equals("s")) {
            downPressed = false;
        }
        if (key.equals("q")) {
            leftPressed = false;
        }
        if (key.equals("d")) {
            rightPressed = false;
        }
    }

    public void update(Player plr, Position pos) {
        boolean hasEntered = false;
        if (upPressed == true) {
            plr.setDirection("up");
            plr.incrementSpriteCounter();
            if (plr.getSpriteCounter() > 10) {
                if (plr.getSpriteNum() == 1) {
                    plr.setSpriteNum(2);
                } else if (plr.getSpriteNum() == 2){
                    plr.setSpriteNum(1);
                }
                plr.setSpriteCounter(0);
            }
            hasEntered = true;
        } else if (downPressed == true){
            plr.setDirection("down");
            hasEntered = true;
            plr.incrementSpriteCounter();
            if (plr.getSpriteCounter() > 10) {
                if (plr.getSpriteNum() == 1) {
                    plr.setSpriteNum(2);
                } else if (plr.getSpriteNum() == 2){
                    plr.setSpriteNum(1);
                }
                plr.setSpriteCounter(0);
            }
        } else if (leftPressed == true){
            plr.setDirection("left");
            hasEntered = true;
            plr.incrementSpriteCounter();
            if (plr.getSpriteCounter() > 10) {
                if (plr.getSpriteNum() == 1) {
                    plr.setSpriteNum(2);
                } else if (plr.getSpriteNum() == 2){
                    plr.setSpriteNum(1);
                }
                plr.setSpriteCounter(0);
            }
        } else if (rightPressed == true){
            plr.setDirection("right");
            hasEntered = true;
            plr.incrementSpriteCounter();
            if (plr.getSpriteCounter() > 10) {
                if (plr.getSpriteNum() == 1) {
                    plr.setSpriteNum(2);
                } else if (plr.getSpriteNum() == 2){
                    plr.setSpriteNum(1);
                }
                plr.setSpriteCounter(0);
            }
        }

        if (hasEntered == true) {
            plr.setCollisionOn(false);
            game.getChecker().checkTile(plr);
            if (plr.isCollisionOn() == false) {
                switch (plr.getDirection()) {
                    case "up":
                        plr.setY(plr.getY() - plr.getSpeed());
                        break;
                    case "down":
                        plr.setY(plr.getY() + plr.getSpeed());
                        break;
                    case "left":
                        plr.setX(plr.getX() - plr.getSpeed());
                        break;
                    case "right":
                        plr.setX(plr.getX() + plr.getSpeed());
                        break;
                }
            }
            if (this.end == false) {
                pos.SendPosition();
            } else if (this.end == true) {
                this.Terminate();
            }
        }
        plr.setCollisionOn(false);
    }
    public void Terminate() {
        try {
            DataOutputStream out = new DataOutputStream(this.reseau.getOutputStream());
            System.out.println("envoie de partie termine");
            out.writeUTF("terminate");
            out.flush();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public String getKeyText(KeyEvent e) {
        return KeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
    }
    
}

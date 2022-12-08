package object;

import java.awt.*;
import java.io.*;
//import action.*;
//import view.GamePanel;

public class Player extends Entity implements Serializable{
    int id;
    //GamePanel gp;
    //MoveListener key;
    String nom;

    // CONSTRUCTOR
    public Player(String nom, int id) {
        super();
        this.nom = nom;
        this.id = id;
        this.setDefaultValues();
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        this.setDirection("down");
    }
    
    public void setDefaultValues(){
        speed = 2;
        this.setDirection("down");
        direction = "down";
    }


    public void drawPlayer(Graphics2D g){
        //this.setLocation(this.getPosX(), this.getPosY());
        // BufferedImage image = null;
        g.fillRect(this.getPosX(), this.getPosY(), 15, 15);
        //g.drawImage(image,this.getPosX(), this.getPosY(), 48, 48, null);
    }

    public void incrementSpriteCounter() {
        int nb = this.getSpriteCounter() + 1;
        this.setSpriteCounter(nb);
    }

    // GETTERS AND SETTERS
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPosX() {
        return this.x;
    }

    public void setPosX(int posX) {
        this.x = posX;
    }

    public int getPosY() {
        return y;
    }

    public void setPosY(int posY) {
        this.y = posY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
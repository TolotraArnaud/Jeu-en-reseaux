package object;
import java.awt.*;
import java.awt.image.*;

public class Entity {
    int x, y;
    int speed;

    BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    String direction = "";

    int spriteCounter = 0;
    int spriteNum = 1;
    Rectangle solidArea;
    boolean collisionOn = false;

    public Entity(){
        this.spriteCounter = 0;
        this.spriteNum = 1;
    }


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public BufferedImage getUp1() {
        return up1;
    }
    public void setUp1(BufferedImage up1) {
        this.up1 = up1;
    }
    public BufferedImage getUp2() {
        return up2;
    }
    public void setUp2(BufferedImage up2) {
        this.up2 = up2;
    }
    public BufferedImage getDown1() {
        return down1;
    }
    public void setDown1(BufferedImage down1) {
        this.down1 = down1;
    }
    public BufferedImage getDown2() {
        return down2;
    }
    public void setDown2(BufferedImage down2) {
        this.down2 = down2;
    }
    public BufferedImage getLeft1() {
        return left1;
    }
    public void setLeft1(BufferedImage left1) {
        this.left1 = left1;
    }
    public BufferedImage getLeft2() {
        return left2;
    }
    public void setLeft2(BufferedImage left2) {
        this.left2 = left2;
    }
    public BufferedImage getRight1() {
        return right1;
    }
    public void setRight1(BufferedImage right1) {
        this.right1 = right1;
    }
    public BufferedImage getRight2() {
        return right2;
    }
    public void setRight2(BufferedImage right2) {
        this.right2 = right2;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public int getSpriteCounter() {
        return spriteCounter;
    }
    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }
    public int getSpriteNum() {
        return spriteNum;
    }
    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }
    public Rectangle getSolidArea() {
        return solidArea;
    }
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }
    public boolean isCollisionOn() {
        return collisionOn;
    }
    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }
    

    
}

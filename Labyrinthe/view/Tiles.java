package view;

import java.awt.image.*;

public class Tiles {
    BufferedImage image;
    boolean collision = false;

    public Tiles() {
    }

    public Tiles(BufferedImage image, boolean collision) {
        this.image = image;
        this.collision = collision;
    }

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public boolean isCollision() {
        return collision;
    }
    public void setCollision(boolean collision) {
        this.collision = collision;
    }
    
}

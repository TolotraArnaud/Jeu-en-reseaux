package object;

import view.GamePanel;
import javax.swing.*;
import java.awt.*;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity plr) {
        int entityLeftWorldX = plr.getX() + plr.getSolidArea().x;
        int entityRightWorldX = plr.getX() + plr.getSolidArea().x + plr.getSolidArea().width;
        int entityTopWorldY = plr.getY() + plr.getSolidArea().y;
        int entityBottomWorldY = plr.getY() + plr.getSolidArea().y + plr.getSolidArea().height;

        int entityLeftCol = entityLeftWorldX / (gp.getTileSize());
        int entityRightCol = entityRightWorldX / (gp.getTileSize());
        int entityTopRow = entityTopWorldY / (gp.getTileSize());
        int entityBottomRow = entityBottomWorldY / (gp.getTileSize());

        int tileNum1, tileNum2;

        switch (plr.getDirection()) {
            case "up":
                entityTopRow = (entityTopWorldY - plr.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gp.getTileM().getMapTileNum()[entityRightCol][entityTopRow];
                if (tileNum1 == 1) {
                    if (gp.getTileM().getTile()[tileNum1].isCollision() == true || gp.getTileM().getTile()[tileNum2].isCollision() == true) {
                        plr.setCollisionOn(true);
                    }
                } else if (tileNum1 == 2) {
                    System.out.println("partie terminer");
                    this.gp.getKey().setEnd(true);
                    JLabel label = new JLabel("Partie Terminée, vous avez gagné");
                    this.gp.removeKeyListener(this.gp.getKey());
                    this.gp.getKey().Terminate();
                    //panel.add(label);
                    this.gp.getMyFrame().remove(this.gp.getMyFrame().getGame());
                    this.gp.getMyFrame().repaint();
                    this.gp.getMyFrame().setFont(new Font("ink free",Font.BOLD,30));
                    label.setBounds(200, 200, 200, 50);
                    this.gp.getMyFrame().add(label);
                    this.gp.getMyFrame().repaint();
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + plr.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
                tileNum2 = gp.getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
                if (tileNum1 == 1) {
                    if (gp.getTileM().getTile()[tileNum1].isCollision() == true || gp.getTileM().getTile()[tileNum2].isCollision() == true) {
                        plr.setCollisionOn(true);
                    }
                } else if (tileNum1 == 2) {
                    System.out.println("partie terminer");
                    this.gp.getKey().setEnd(true);
                    JLabel label = new JLabel("Partie Terminée, vous avez gagné");
                    this.gp.removeKeyListener(this.gp.getKey());
                    this.gp.getKey().Terminate();
                    //panel.add(label);
                    this.gp.getMyFrame().remove(this.gp.getMyFrame().getGame());
                    this.gp.getMyFrame().repaint();
                    this.gp.getMyFrame().setFont(new Font("ink free",Font.BOLD,30));
                    label.setBounds(200, 200, 100, 50);
                    this.gp.getMyFrame().add(label);
                    this.gp.getMyFrame().repaint();
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - plr.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gp.getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
                if (tileNum1 == 1) {
                    if (gp.getTileM().getTile()[tileNum1].isCollision() == true || gp.getTileM().getTile()[tileNum2].isCollision() == true) {
                        plr.setCollisionOn(true);
                    }
                } else if (tileNum1 == 2) {
                    System.out.println("partie terminer");
                    this.gp.getKey().setEnd(true);
                    JLabel label = new JLabel("Partie Terminée, vous avez gagné");
                    this.gp.removeKeyListener(this.gp.getKey());
                    this.gp.getKey().Terminate();
                    //panel.add(label);
                    this.gp.getMyFrame().remove(this.gp.getMyFrame().getGame());
                    this.gp.getMyFrame().repaint();
                    this.gp.getMyFrame().setFont(new Font("ink free",Font.BOLD,30));
                    label.setBounds(200, 200, 100, 50);
                    this.gp.getMyFrame().add(label);
                    this.gp.getMyFrame().repaint();
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + plr.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTileM().getMapTileNum()[entityRightCol][entityTopRow];
                tileNum2 = gp.getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
                if (tileNum1 == 1) {
                    if (gp.getTileM().getTile()[tileNum1].isCollision() == true || gp.getTileM().getTile()[tileNum2].isCollision() == true) {
                        plr.setCollisionOn(true);
                    }
                } else if (tileNum1 == 2) {
                    System.out.println("partie terminer");
                    this.gp.getKey().setEnd(true);
                    JLabel label = new JLabel("Partie Terminée, vous avez gagné");
                    this.gp.removeKeyListener(this.gp.getKey());
                    this.gp.getKey().Terminate();
                    //panel.add(label);
                    this.gp.getMyFrame().remove(this.gp.getMyFrame().getGame());
                    this.gp.getMyFrame().repaint();
                    this.gp.getMyFrame().setFont(new Font("ink free",Font.BOLD,30));
                    label.setBounds(200, 200, 200, 50);
                    this.gp.getMyFrame().add(label);
                    this.gp.getMyFrame().repaint();
                }
                break;
        }
    }
}

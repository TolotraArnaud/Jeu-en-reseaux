package view;

import java.awt.*;
import javax.swing.JPanel;
import action.MoveListener;
import action.TileManager;

import java.net.*;
import object.*;
import runnable.Position;
import java.util.*;

/**
 * GamePanel
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize =8; // Habean'ny personnage en debut (16 X 16)
    final int scale = 3; // Fitomboan"ny personnage raha ngeza ny ecran

    final int tileSize = originalTileSize*scale; // Tena habean'ny personnage anao (48 X 48)
    final int maxScreenCol = 26;
    final int maxScreenRow = 22;
    final int screenWidth = tileSize*maxScreenCol; //Pixel habean'ilay ecran de jeu en longueur = 864px
    final int screenHeight = tileSize*maxScreenRow; //Pixel habean'ilay ecran de jeu en largeur = 624px
    
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    MoveListener key;
    Thread gameThread;
    CollisionChecker checker;

    int playerSpeed=4;
    Player me;
    Position pos;
    Vector<Player> other = new Vector<>();
    Frame myFrame;


    public GamePanel(Socket socket, Player me,Position pos,Frame window) {
        // this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.key = new MoveListener(socket, me,this);
        this.requestFocus();
        this.setFocusable(true);
        this.addKeyListener(key);
        this.me = me;
        this.pos = pos;
        this.myFrame = window;
        //this.add(me);
        this.checker = new CollisionChecker(this);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double nextDrawtime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            //System.out.println("update");
            this.update();
            this.repaint();

            try {
                double remainingTime = nextDrawtime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawtime += drawInterval;
            } catch (Exception e) {
                System.out.println("error6="+e.getMessage());
            }
        }
    }

    public void update() {
        this.key.update(this.me,this.pos);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        this.tileM.draw(g2);
        //me.setLocation(me.getPosX(), me.getPosY());
        g2.setColor(Color.BLUE);
        me.drawPlayer(g2);
        if (this.other.size() > 0) {
            g2.setColor(Color.RED);
            this.other.get(0).drawPlayer(g2);
        }
        g2.dispose();
    }

    public void addPlayer(Player plr){
        System.out.println("other added");
        this.other.add(plr);
        System.out.println("player added");
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setColor(Color.RED);
        this.other.get(0).drawPlayer(g2);
        g2.dispose();
    }

    public Vector<Player> getOther() {
        return other;
    }

    public void setOther(Vector<Player> other) {
        this.other = other;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public Player getPlayer() {
        return me;
    }

    public void setPlayer(Player plr) {
        this.me = plr;
    }

    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public CollisionChecker getChecker() {
        return checker;
    }

    public void setChecker(CollisionChecker checker) {
        this.checker = checker;
    }

    public TileManager getTileM() {
        return tileM;
    }

    public void setTileM(TileManager tileM) {
        this.tileM = tileM;
    }

    public Frame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(Frame myFrame) {
        this.myFrame = myFrame;
    }

    public MoveListener getKey() {
        return key;
    }

    public void setKey(MoveListener key) {
        this.key = key;
    }
    
    
}
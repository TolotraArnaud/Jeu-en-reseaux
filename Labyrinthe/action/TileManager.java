package action;

import view.GamePanel;
import view.Tiles;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    Tiles[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tiles[10];
        this.mapTileNum = new int[gp.getMaxScreenCol()][gp.getMaxScreenRow()];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tile[1] = new Tiles();
            tile[1].setImage(ImageIO.read(getClass().getResourceAsStream("./tiles/wall.png")));
            tile[1].setCollision(true);
        } catch (Exception e) {
            System.out.println("error instanciation image ="+e);
        }
    }

    public void loadMap() {
        try {
            InputStream in = getClass().getResourceAsStream("./map/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int col = 0;
            int row =0;

            while (col < gp.getMaxScreenCol() && row < gp.getMaxScreenCol()) {
                String line = br.readLine();
                while (col < gp.getMaxScreenCol()) {
                    String[] number = line.split(" ");
                    int nb = Integer.valueOf(number[col]);

                    mapTileNum[col][row] = nb;
                    col ++;
                }

                if (col == gp.getMaxScreenCol()) {
                    col = 0;
                    row ++;
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x= 0;
        int y = 0;

        while (col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()) {
            int tileNum = mapTileNum[col][row];
            if (tileNum == 1) {
                g2.drawImage(this.tile[tileNum].getImage(), x, y, gp.getTileSize(), gp.getTileSize(), null);
            }
            col++;
            x += gp.getTileSize();
            if (col == gp.getMaxScreenCol()) {
                col = 0;
                x = 0;
                row++;
                y += gp.getTileSize();
            }
        }
    }

    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public Tiles[] getTile() {
        return tile;
    }

    public void setTile(Tiles[] tile) {
        this.tile = tile;
    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

    public void setMapTileNum(int[][] mapTileNum) {
        this.mapTileNum = mapTileNum;
    }

    
    
}

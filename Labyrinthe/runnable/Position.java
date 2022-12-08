package runnable;

import java.net.*;
import view.Frame;

import java.io.*;

public class Position{
    Socket reseau;
    boolean hassend = false;
    Frame window;

    public Position(Socket reseau, Frame window) {
        this.reseau = reseau;
        this.window = window;
    }

    public void SendPosition () {
        try {
            DataOutputStream send = new DataOutputStream(this.reseau.getOutputStream());
            //System.out.println("X="+this.window.getGame().getPlayer().getPosX()+"//Y="+this.window.getGame().getPlayer().getPosY());
            send.writeUTF("x="+this.window.getGame().getPlayer().getPosX()+"//y="+this.window.getGame().getPlayer().getPosY());
            send.flush();
        } catch (Exception e) {
            System.out.println("error in sendPosition ="+e);
        }
        
    }
}

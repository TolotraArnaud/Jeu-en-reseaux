package runnable;

import java.net.*;
import object.Player;
import view.Frame;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Link implements Runnable{
    Socket reseau;
    boolean hassend;
    Frame window;

    public Link(Socket reseau, Frame window) {
        this.reseau = reseau;
        this.window = window;
        this.hassend = false;
    }

    @Override
    public void run() {
        if (this.hassend == false) {
            System.out.println("we will send the other");
            try {
                ObjectInputStream in = new ObjectInputStream(this.reseau.getInputStream());
                Player adv = (Player) in.readObject();
                System.out.println("test2");
                window.getGame().addPlayer(adv);
                window.getGame().repaint();
                this.hassend = true;
                System.out.println("we have send the other");
            } catch (Exception e) {
                System.out.println("error5="+e);
            }
            
        }
        System.out.println("Server "+reseau.getLocalPort()+"IP etablish ...!!!");
        
        while (reseau.isConnected()) {
            DataInputStream dataIn = null;
            try {
                dataIn = new DataInputStream(this.reseau.getInputStream());
                String message = dataIn.readUTF();
                if (message != null || message != "") {
                    if (message.equals("terminate")) {
                        System.out.println("message = "+message);
                        System.out.println("la partie se termine");
                        JLabel label = new JLabel("Partie Terminée, vous avez perdu");
                        //panel.add(label);
                        this.window.remove(this.window.getGame());
                        this.window.repaint();
                        this.window.setFont(new Font("ink free",Font.BOLD,30));
                        label.setBounds(200, 200, 200, 50);
                        this.window.add(label);
                        this.window.repaint();
                    } else {
                        int[] pos = this.getDirection(message);
                        if (this.window.getGame().getOther().size() > 0) {
                            this.window.getGame().getOther().get(0).setPosX(pos[0]);
                            this.window.getGame().getOther().get(0).setPosY(pos[1]);
                            //System.out.println("Other X="+pos[0]+"// Y="+pos[1]);
                        }
                    }
                }
                //this.window.getOdr().moveTheOther(this.getPlayerName(message), this.getDirection(message));
                //System.out.println("en attente de nouvelle information...");
            } catch (Exception e) {
                System.out.println("errorInput="+e.getMessage());
            }
        }
    }

    public int[] getDirection(String order) {
        // x=0//y=0
        int[] nb = new int[2];
        String[] split = order.split("//");
        String[] split2 = split[0].split("=");
        String[] split3 = split[1].split("=");
        nb[0] = Integer.valueOf(split2[1]);
        nb[1] = Integer.valueOf(split3[1]);
        return nb;
    }
    
}

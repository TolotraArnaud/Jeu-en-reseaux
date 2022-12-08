package network;

import java.net.*;
import java.io.*;
import object.Player;
import runnable.Link;
import view.Frame;

public class Client {
    Socket socket;

    public Client(String IP,int port){
        connectToServer(IP,port);
    }

    public void connectToServer(String IP,int port){
        try {
            this.socket = new Socket(IP, port);
            Frame window =new Frame("Client",this.socket,false);
            this.SendOther(window.getGame().getPlayer());
            Thread th = new Thread(new Link(this.socket,window));
            //Thread th2 = new Thread(new Position(this.socket, window));
            th.start();
            //th2.start();
            
        } catch (Exception e) {
            System.out.println("error3="+e.getMessage());
        }
    }

    public void SendOther(Player plr){
        try {
            ObjectOutputStream test = new ObjectOutputStream(this.socket.getOutputStream());
            test.writeObject(plr);
            test.flush();
            
        } catch (Exception e) {
            System.out.println("errorInSendother = "+e+" cause="+e.getCause());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}

package network;

import java.net.*;
import java.io.*;
import object.Player;
import runnable.Link;
import view.Frame;


public class Host {
    Socket socket;

    public Host(int port){
        createServer(port);
    }

    public void createServer(int port){
        try {
            ServerSocket SSocket = new ServerSocket(port);
            this.socket = SSocket.accept();
            System.out.println("A client is connected");
            Frame window =new Frame("Server",this.socket,true);
            this.SendOther(window.getGame().getPlayer());
            Thread th = new Thread(new Link(this.socket,window));
            //Thread th2 = new Thread(new Position(this.socket, window));
            th.start();
            //th2.start();
            //SSocket.close();
            
        } catch (Exception e) {
            System.out.println("error4="+e.getMessage());
        }
    }

    public void SendOther(Player plr){
        try {
            ObjectOutputStream test = new ObjectOutputStream(this.socket.getOutputStream());
            test.writeObject(plr);
            test.flush();
            
        } catch (Exception e) {
            System.out.println("errorInSendother = "+e);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    
}

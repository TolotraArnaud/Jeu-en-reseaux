package executable;

import network.Host;
import javax.swing.*;

public class ServerMain {
    public static void main(String[] args) {
        int port = Integer.valueOf(JOptionPane.showInputDialog("Entrez un numéro de Port"));
        new Host(port);
    }
}

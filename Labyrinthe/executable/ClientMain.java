package executable;

import network.Client;
import javax.swing.*;

public class ClientMain {
    public static void main(String[] args) {
        String host = JOptionPane.showInputDialog("Entrez l'IP");
        int port = Integer.valueOf(JOptionPane.showInputDialog("Entrez un numéro de Port"));
        new Client(host, port);
    }
}

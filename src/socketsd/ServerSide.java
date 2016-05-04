package socketsd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caio Lucena
 */
public class ServerSide {

    public static final int PORTA = 9000;
    
    public static void main(String[] args) {
        new ServerSide().executa();
    }
    
    public void executa() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORTA);
            System.out.println("Servidor Pronto para Conexão");
            while(true){
                Socket socket = serverSocket.accept();
                new ThreadServer(socket).start();
            }
        
        } catch (IOException ex) {
            System.out.println("A porta " + PORTA+" está ocupada. Tente novamente em outra porta;");
        }
    }

}

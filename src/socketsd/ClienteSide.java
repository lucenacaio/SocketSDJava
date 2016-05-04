package socketsd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caio Lucena
 */
public class ClienteSide {
    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("localhost", 9000);
            BufferedReader fromCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println(socket.getPort() + " >> " + socket.getInetAddress().getHostAddress());
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Conexão realizada com sucesso! \nDigite uma palavra:");
            while (true) {        
                String readInput = bufferedReader.readLine();
                printWriter.println(readInput);    
                System.out.println(fromCliente.readLine());
            }
            
        } catch (IOException ex) {
            System.out.println("Não foi possível estabelecer conexão com o servidor!!!");
        }
    }
}

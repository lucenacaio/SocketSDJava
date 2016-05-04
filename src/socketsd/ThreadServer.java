package socketsd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketsd.dicionario.Dicionario;

/**
*    @author Caio Lucena
**/

public class ThreadServer extends Thread{
     Socket socket;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    public void run(){
         try {
             String texto = null;
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
             BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             System.out.println("User " + buffer.readLine() + " está conectado");
             while((texto = buffer.readLine()) != null){
                 String chegou = texto;
                 String resposta = Dicionario.getInstance().getDicionarioMap().get(chegou.toLowerCase());
                 if(resposta != null){
                    printWriter.println("Significado " + resposta);
                 }else{
                    printWriter.println("Significado não disponível.");
                 }
             }
             socket.close();
         } catch (IOException ex) {
             System.out.println("A conexão com o cliente foi perdida.");
         }
    }
}

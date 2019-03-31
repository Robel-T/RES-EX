import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String ... args){
        ServerSocket serverSocket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            serverSocket = new ServerSocket(1993);

            Socket commSocket = serverSocket.accept();

            reader = new BufferedReader(new InputStreamReader(commSocket.getInputStream()));
            writer = new PrintWriter(commSocket.getOutputStream());
            writer.println("Bienvenue dans le Serveur de Robel et Jael.");

            while(true){
                String tmp;
                writer.flush();
                tmp = reader.readLine();
                System.out.println(tmp);
                if(tmp.equals("Hello I Love RES")) {
                    writer.println("Me too");
                    writer.flush();
                }
                else if(tmp.equals("Close")){
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                serverSocket.close();
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}

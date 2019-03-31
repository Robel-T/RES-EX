import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String... args) {
        Socket clientSocket = null;
        OutputStream os = null;
        InputStream is = null;

        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), 1993);
            is = clientSocket.getInputStream();
            os = clientSocket.getOutputStream();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String fromServer;
            String fromUser = "Hello I Love RES";

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Me too"))
                    fromUser = "Close";


                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                is.close();
                os.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


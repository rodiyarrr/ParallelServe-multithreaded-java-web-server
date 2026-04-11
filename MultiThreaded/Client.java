import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;

public class Client {
    public void run(){
        int port=8010;
        InetAddress address=InetAddress.getLocalHost();
        try{
            Socket clientSocket= new Socket(address,port);

            PrintWriter toServer=new PrintWriter(clientSocket.getOutputStream());
            BufferedReader fromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            toServer.println("Aur server bhai kya haal chaal?");
            String message=fromServer.readLine();
            System.out.println("Message from server :"+ message);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        Client client=new Client();
        client.run();    
    }
}

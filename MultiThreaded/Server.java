import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {
    public void run(){
        int port=8010;
        ServerSocket serverSocket=new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
        try{
            while (true) {
                System.out.println("Server is listening on port : "+port);
                Socket acceptedConnection=serverSocket.accept();
                System.out.println("Connection estabilished with Client : "+acceptedConnection.getRemoteSocketAddress());

                PrintWriter toClient=new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient=new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

                toClient.println("Hello from the Server");
                String message=fromClient.readLine();
                System.out.println("Message from client :"+message);

                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    

    public static void main(String[] args) {
        
    }
}

import java.io.*;
import java.io.InputStreamReader;
// import java.io.ServerSocket;
// import java.io.ServerSocket;
// import java.io.ServerSocket;

import java.net.ServerSocket;
import java.net.Socket;

class server{
    public static void main(String argv[]) throws Exception 
    {
        String requestSentence;
        String responseSentence;
        //Create welcome socket
        ServerSocket welcome = new ServerSocket(5555);
        //Wait 
        while(true){
            Socket connection = welcome.accept();
            //Create input stream
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Create output stream
            DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
            requestSentence = inFromClient.readLine();
            responseSentence = requestSentence.toUpperCase();
            // Write to socket
            outToClient.writeBytes(responseSentence); 
        }
    }
}
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;
class client{
    public static void main(String argv[]) throws Exception 
    {
        String sentence;
        String modSentence;
        //Create input stream
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        //Create client socket connect to server
        Socket clientSocket = new Socket("127.0.0.1",5555);
        //Create output stream to attach to socket
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //Create input stream to attach to socket
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("qqqa");
        sentence = inFromUser.readLine();
        System.out.println(sentence);
        //Send to server
        outToServer.writeBytes(sentence);
        System.out.println(outToServer);
        //Receive from server
        modSentence = inFromServer.readLine();
        System.out.println(modSentence);
        clientSocket.close();
    }
}
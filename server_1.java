import java.io.* ;
import java.net.*;

public class server_1 {
    String[] adviceList = { "a", "b", "c" };

    public void go() {
        try {
            ServerSocket serverSock = new ServerSocket(5555);
            while (true) {
                Socket sock = serverSock.accept();
                // PrintWriter writer = new PrintWriter(sock.getOutputStream());
                // String advice = getAdvice();
                // writer.close();
                // System.out.println(advice);


                // BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                // String path = reader.readLine();
                // reader.close();
                // System.out.println(path);
    
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
                DataInputStream in = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
                byte[] byteArray = new byte[1024];
                in.read(byteArray);
                FileOutputStream fos = new FileOutputStream("../test");
                fos.write(byteArray);
                // this.turnOff();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void turnOff(){
        String command = "bash test";
        Process p;
        try {
            System.out.println("Ngu vai lon");
                    // p.waitFor();
        p = Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int rand = (int) (Math.random() * adviceList.length);
        return adviceList[rand];
    }   
    public static void main(String[] args) {
        server_1 server = new server_1();
        server.go();  
    }
}
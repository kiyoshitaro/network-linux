import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class client_1{
    public void client_1(){
        try{
        Socket socket = new Socket("192.168.0.108",5555);
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine(); 
        System.out.println("sadasd");
        System.out.println(i);
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println(i);
        writer.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void go(){
        try{
            Socket socket = new Socket("192.168.0.107",5555);
  
        
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            File a = new File("./test");
            byte[] byteArray = read(a);
            out.write(byteArray);
            System.out.println(byteArray);
            out.close();
            in.close();
            socket.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public byte[] read(File file) throws IOException {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }
    
            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }
        public static void main(String[] args){
            client_1 client = new client_1();
            client.go();
        }
}

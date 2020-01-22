import java.io.*;
import java.net.*;

public class httpserver2 {

    public final static int PORT_NO = 13259;  //this port number can be changed
    public static String File_Address = "";  //stores the address of the file sent by the client

    public static void main (String [] args ) throws IOException {
        String cfile;

        FileInputStream finput = null;
        BufferedInputStream binput = null;
        OutputStream soutput = null;
        ServerSocket serversocket = null;
        Socket socket = null;
        try {
            serversocket = new ServerSocket(PORT_NO);
            while (true) {
                System.out.println("Server started.");
                System.out.println("Waiting for the client to respond...");
                try {
                    socket = serversocket.accept();//accepts the connection from the file
                    
                    BufferedReader clientRead = new BufferedReader(new InputStreamReader(socket.getInputStream( )));//read the data from the client


                    DataOutputStream clientWrite = new DataOutputStream(socket.getOutputStream( ));//for writing address to the server received from the client


                    cfile = clientRead.readLine();
                    cfile= (String) cfile.subSequence(4,cfile.length());
                    File_Address="C:\\Users\\DELL\\Documents\\"+cfile;
                    System.out.println("Client responded....Connection Successful");
                    System.out.println(File_Address);
                    File newFile = new File (File_Address);
                    byte [] arr  = new byte [(int)newFile.length()];
                    finput = new FileInputStream(newFile);
                    binput = new BufferedInputStream(finput);
                    binput.read(arr,0,arr.length);//reads the array form of file data and display in the client
                    soutput = socket.getOutputStream();
                    System.out.println("Open the file on web page");
                    soutput.write(arr,0,arr.length);
                    soutput.flush();
                   System.out.println("Server closed");
                    break;
                }
                finally {
                    if (binput != null) binput.close();
                    if (soutput != null) soutput.close();
                    if (socket!=null) socket.close();
                }//connection closed
            }
        }
        finally {
            if (serversocket != null) serversocket.close();
        }
    }
}
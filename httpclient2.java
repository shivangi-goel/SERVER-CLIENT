import java.awt.*;
import java.io.*;
import java.net.*;

public class httpclient2 {

    public final static int PORT_NO = 13259;      //this can be changed
    public final static String SERVER = "127.0.0.1";  // localhost
    public final static String File_Address = "C:\\Users\\DELL\\Documents\\index.html";  //address of the location of html file
    public final static int SIZE_file = 6011896; //size of the html file

    public static void main (String [] args ) throws IOException {
        int readByte; //reads the bytes file is storing
        String file = "";
        int count = 0;//count the number of bytes, program stops when count reaches maximum bytes
        FileOutputStream foutput = null;
        BufferedOutputStream boutput = null;
        Socket socket2 = null;
        try {
            socket2 = new Socket(SERVER, PORT_NO);
            System.out.println("Connecting...");
            System.out.println("Connection Successful");
            System.out.print("Enter File name:");
            BufferedReader readUserFile = new BufferedReader(new InputStreamReader(System.in));//reads file name

            DataOutputStream serverOutput = new DataOutputStream(socket2.getOutputStream());
            file = readUserFile.readLine();//reads data from file
            serverOutput.writeBytes(file + '\n');

            byte [] arr  = new byte [SIZE_file];//recieves file and store in the form of array
            InputStream inp = socket2.getInputStream();
            foutput = new FileOutputStream(File_Address);
            boutput = new BufferedOutputStream(foutput);
            readByte = inp.read(arr,0,arr.length);
            count = readByte;
            boutput.write(arr, 0 , count);//display the array
            boutput.flush();
            
            BufferedReader br = new BufferedReader(new FileReader(File_Address));

            String str;
            while ((str = br.readLine()) != null)
                System.out.println(str);

            File filebrowse = new File(File_Address);//opens the file in the browser
                System.out.println("--------------------------------------------------------------------------");
                System.out.print("Status code: ");
               System.out.println("OK 200 \nLanguage used: en");
               System.out.println("--------------------------------------------------------------------------");
               
            Desktop.getDesktop().browse(filebrowse.toURI());
            System.out.println("Client closed \n connection closed");
        }
        finally {
            if (foutput != null) foutput.close();
            if (boutput != null) boutput.close();
            if (socket2 != null) socket2.close();//close the connections
        }
    }

}
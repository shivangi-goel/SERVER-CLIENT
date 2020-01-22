import java.io.*;
import java.net.*;

public class SERVER
{
    public static void main(String args[]) throws IOException
    {
        try
        {
           ServerSocket serversocket=new ServerSocket(8000);
           System.out.println("Server Started");
           Socket socket=serversocket.accept();
           DataInputStream ip=new DataInputStream(socket.getInputStream());
           DataOutputStream op=new DataOutputStream(socket.getOutputStream());
           double rate=ip.readDouble();//interest rate
           System.out.println("Interest Rate Received:" +rate);
           int noy=ip.readInt();//number of years
           System.out.println("Number of years received:"+noy);
           double amnt=ip.readDouble();
            System.out.println("Loan amount received:"+amnt);
           double mi=(rate*noy*amnt)/100;
           System.out.println("Monthly Interest Computed:"+mi);
           op.writeDouble(mi);
           double totpay=mi+amnt;
           System.out.println("Total payment Computed:"+totpay);
           op.writeDouble(totpay);
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
}
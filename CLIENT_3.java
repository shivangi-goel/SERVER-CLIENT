import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CLIENT_3
{
    public static void main(String args[]) throws IOException
    {
        /*double rate=10.5;
        int noy=2;
        double amnt=2500;*/
        double n=100*Math.random();
        try
        {
            Socket client=new Socket("localhost", 8000);
            DataInputStream ip=new DataInputStream(client.getInputStream());
            DataOutputStream op=new DataOutputStream(client.getOutputStream());
           /* op.writeDouble(rate);
            op.flush();
            op.writeInt(noy);
            op.flush();
            op.writeDouble(amnt);
            op.flush();
            double mi=ip.readDouble();
            System.out.println("Monthly interest is:"+mi);
            double totpay=ip.readDouble();
            System.out.println("Total payment is "+totpay);*/
           op.writeDouble(n);
           System.out.println("the random number is"+n);
            client.close();
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
}
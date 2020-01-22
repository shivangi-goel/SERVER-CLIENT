import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class CLIENT_2
{
    public static void main(String args[]) throws IOException
    {
        String s1=JOptionPane.showInputDialog(null,"Enter the interest rate");
        double rate=Double.parseDouble(s1);
        String s2=JOptionPane.showInputDialog(null,"Enter the number of years");
        int noy=Integer.parseInt(s2);
        String s3=JOptionPane.showInputDialog(null,"Enter the loan amount");
        double amnt=Double.parseDouble(s3);
        
        
       /* double rate=10.5;
        int noy=2;
        double amnt=2500;*/
        try
        {
            Socket client=new Socket("localhost", 8000);
            DataInputStream ip=new DataInputStream(client.getInputStream());
            DataOutputStream op=new DataOutputStream(client.getOutputStream());
            op.writeDouble(rate);
            op.flush();
            op.writeInt(noy);
            op.flush();
            op.writeDouble(amnt);
            op.flush();
            double mi=ip.readDouble();
            double totpay=ip.readDouble();
            JOptionPane.showMessageDialog(null, "Monthly interest is"+ mi+"\n"+"Total payment is"+totpay);
           // System.out.println("Monthly interest is:"+mi);
            //double totpay=ip.readDouble();
             //JOptionPane.showMessageDialog(null, "Total Payment is"+ totpay);
           // System.out.println("Total payment is "+totpay);
            client.close();
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
}

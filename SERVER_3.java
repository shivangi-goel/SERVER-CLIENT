import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class SERVER_3
{


    public static void main(String args[]) throws IOException
    {
        try
        {
            
           ServerSocket serversocket=new ServerSocket(8000);
           
           JFrame jf=new JFrame();
           jf.setVisible(true);
           jf.setSize(100, 100);
           jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           JPanel jp=new JPanel();
           
           JButton jb= new JButton("Server");
           jp.add(jb);
           jf.add(jp);
           jb.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e)
               {
                   try {
                       System.out.println("Server Started");
          
                       Socket socket=serversocket.accept();
                       DataInputStream ip=new DataInputStream(socket.getInputStream());
           DataOutputStream op=new DataOutputStream(socket.getOutputStream());
           double n=100*Math.random();
           System.out.println("random number is"+n);
                   } catch (IOException ex) {
                     System.err.println(ex);
                   }
               }
           });
          // Socket socket=serversocket.accept();
         
          /* double rate=ip.readDouble();//interest rate
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
        }*/
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
}

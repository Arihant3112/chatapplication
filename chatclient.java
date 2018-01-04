import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 500040563
 */
class chatclient extends JFrame implements ActionListener
{
    private Socket s;
    JFrame f;
    JTextField msg;
    JTextArea data;
    JButton btn;
    public chatclient() throws Exception
    {
        s=new Socket("192.168.1.100",1342);
        f=new JFrame("chat");
        msg=new JTextField();
        data=new JTextArea();
        btn=new JButton("send");
        f.add(msg);
        f.add(data);
        f.add(btn);
         f.setLayout(null);
        data.setBounds(20, 20, 450, 360);
         msg.setBounds(20, 400, 340, 30);
          btn.setBounds(375, 400, 95, 30);
        f.setSize(500,500);
        f.setVisible(true);
        btn.addActionListener(this);
        while(true)
        {
        BufferedReader fromserver=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String st=fromserver.readLine();
        data.setText(data.getText() + "\n" + "Server :" +st );
        }
    }
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
       PrintWriter toserver=new PrintWriter(s.getOutputStream(),true);
       toserver.println(msg.getText());
       data.setText(data.getText() + "\n" + "Client : " + msg.getText());
       msg.setText("");
        }
        catch(Exception e2)
        {
            
        }
    }
public static void main(String[] args) throws Exception
{
   chatclient c=new chatclient();
}
}

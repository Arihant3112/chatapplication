import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 500040563
 */
 class chatserver extends JFrame implements ActionListener
{
     ServerSocket server;
     Socket s;
      JFrame f;
      JTextArea data;
      JTextField msg;
      JButton btn;
    public chatserver() throws Exception
    {
        server=new ServerSocket(1342);
        s=server.accept();
         f=new JFrame("chat");
      data=new JTextArea();
     msg=new JTextField();
     btn=new JButton("send");
        
        f.add(data);
        f.add(msg);
        f.add(btn);
        f.setLayout(null);
        data.setBounds(20, 20, 450, 360);
         msg.setBounds(20, 400, 340, 30);
          btn.setBounds(375, 400, 95, 30);
        f.setVisible(true);
        f.setSize(500,500);
        btn.addActionListener(this);
        while(true)
        {
         BufferedReader fromclient=new BufferedReader(new InputStreamReader(s.getInputStream()));
         String stri= fromclient.readLine();
         data.setText(data.getText() + "\n" + "Client : " +stri);
        }
    }
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
     data.setText(data.getText() + "\n" + "Server : " + msg.getText());
 PrintWriter toclient=new PrintWriter(s.getOutputStream(),true);
 toclient.println(msg.getText());
 msg.setText("");
        }
        catch(Exception e1)
        {
            
        }

    }



public static void main(String[] args) throws Exception
{
chatserver ser =new chatserver();
}
 }


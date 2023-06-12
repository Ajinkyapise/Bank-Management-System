
package bank.management.system;

/**
 *
 * @author ajink
 */

import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class ministatement extends JFrame{
    ministatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel text = new JLabel();
        text.setBounds(20,140,400,200);
        add(text);
        
        JLabel text2 = new JLabel("Ajinkyas Bank");
        text2.setBounds(150,20,100,20);
        add(text2);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);
       
        try{
            Conn conn = new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(11));
                }
        } catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int balance=0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your current Account Balance is Rs."+balance);
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
    public static void main(String args[]) {
         new ministatement("");
     
     }
}

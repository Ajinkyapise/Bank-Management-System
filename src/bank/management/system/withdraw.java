
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author ajink
 */
public class withdraw extends JFrame implements ActionListener{
    
    JButton back,withdraw;
    JTextField amount;
    String pinnumber;
    
    withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text1 = new JLabel("Enter Amount You want to withdraw");
        text1.setFont(new Font("System",Font.BOLD,20));
        text1.setBounds(170,300,700,35);
        text1.setForeground(Color.WHITE);
        image.add(text1);
        
        amount = new JTextField();
        amount.setBounds(170,350,320,25);
        amount.setFont(new Font("System",Font.BOLD,22));
        add(amount);
        
        withdraw = new JButton("Withdrawal");
        withdraw.setBounds(355,485,150,30);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);
       
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number= amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an amount");
            }else {
                try{
                Conn conn = new Conn();
                String query= "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+number+"')";
                conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+number+ " Withdraw Successfully");
                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
                }catch(Exception e){
                System.out.println(e);
            }
            }
        }else if(ae.getSource()==back){
        new Transcations(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String arge[]){
    new withdraw("");
    }
    
    
}


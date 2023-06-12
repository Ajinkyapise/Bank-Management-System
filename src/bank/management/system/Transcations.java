
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author ajink
 */
public class Transcations extends JFrame implements ActionListener {
    
    JButton deposit,fastcash,withdrawcash,ministatement,pinchange,balanceenq,exit;
    String pinnumber;
    Transcations(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Transcation type");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(230,300,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        withdrawcash = new JButton("Cash Withdrawl");
        withdrawcash.setBounds(355,415,150,30);
        withdrawcash.setForeground(Color.black);
        withdrawcash.addActionListener(this);
        image.add(withdrawcash);
        
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.setForeground(Color.black);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenq = new JButton("Balance Enquiry");
        balanceenq.setBounds(355,485,150,30);
        balanceenq.setForeground(Color.black);
        balanceenq.addActionListener(this);
        image.add(balanceenq);
        
        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
        System.exit(0);
        } else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawcash){
            setVisible(false);
            new withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenq){
            setVisible(false);
            new balanceenquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            new ministatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
new Transcations("");
}

}

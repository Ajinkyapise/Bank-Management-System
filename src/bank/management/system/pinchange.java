
package bank.management.system;

/**
 *
 * @author ajink
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener {
    JLabel image,text,pintext,againpintext;
    JPasswordField pass,repin;
    JButton change,back;
    String pinnumber;
    
    pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        pintext = new JLabel("Set New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 20);
        image.add(pintext);
        
        pass = new JPasswordField();
        pass.setBounds(330,320,180,25);
        pass.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(pass);
        
        againpintext = new JLabel("Re-Enter New Pin");
        againpintext.setForeground(Color.WHITE);
        againpintext.setFont(new Font("System", Font.BOLD, 16));
        againpintext.setBounds(165, 360, 180, 20);
        image.add(againpintext);
        
        repin = new JPasswordField();
        repin.setBounds(330,360,180,25);
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,480,150,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,25);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            try {
                String npin = pass.getText(); 
                String rpin = pass.getText(); 

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered Pin donot match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter Pin Please");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Renter New Pin Please");
                    return;
                }
                
                Conn conn =new Conn();
                String query1 = "update bank set pinnumber='" +rpin+"' where pinnumber='"+pinnumber+"'";
                String query2 = "update login set pinnumber='" +rpin+"' where pinnumber='"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber='" +rpin+"' where pinnumber='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);        
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Pin has been Updated Successfully");
                
                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
      
            } catch (Exception e) {
               System.out.println(e);
            }

        }
        else{
            setVisible(false);
            new Transcations(pinnumber).setVisible(true);
        }
    }
    
     public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
    
}

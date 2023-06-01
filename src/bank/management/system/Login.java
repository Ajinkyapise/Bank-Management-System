
package bank.management.system;

/**
 *
 * @author ajink
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear;
     JPasswordField pinTextField;
     JTextField cardTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);//so that we can use custom layout
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon  i3 = new ImageIcon(i2);//Her i3 is used to scale the image
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);//custom layout
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Oswald",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Carmine",Font.BOLD,30));
        cardNo.setBounds(110,150,400,40);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,40);
        cardTextField.setFont(new Font("Ariel",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("Password:");
        pin.setFont(new Font("Carmine",Font.BOLD,30));
        pin.setBounds(110,230,400,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,230,230,30);
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        add(label);//Adds icon on frame
        
        getContentPane().setBackground(Color.white );
        
        setSize(800,480);//Adding here frame size
        setVisible(true);//make frame visible  
        setLocation(350,200);//To mFrame location
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==clear){
             cardTextField.setText("");
             pinTextField.setText("");
    }else if(ae.getSource()==login){
      Conn conn =new Conn();
      String cardnumber = cardTextField.getText();
      String pinnumber = pinTextField.getText();
      String query = "select * from login where cardnumber = '" + cardnumber + "'and pinnumber = '"+pinnumber+"'";
      try{
          ResultSet rs = conn.s.executeQuery(query);
          if(rs.next()){
              setVisible(false);
              new Transcations(pinnumber).setVisible(true);
          }else{
              JOptionPane.showMessageDialog(null, "Incorrect Username and Pin");
          }
                
          
          
          
      }catch(Exception e){
          System.out.println(e);
      }
    }else if(ae.getSource()==signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}


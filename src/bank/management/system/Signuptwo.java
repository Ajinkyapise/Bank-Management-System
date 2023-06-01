package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
/**
 *
 * @author ajink
 */

public class Signuptwo extends JFrame implements ActionListener{
    
    long random;
    JComboBox religion,cate,val,ocu,edu;
    JTextField pannoTextField,adhnoTextField;
    JButton next;
    JRadioButton yes1,yes2,no1,no2;
    String formno;
    
    Signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        Random ran =new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
           
        setTitle("NEW APPLICATION FORM - PAGE 2");
        
        //Additional Details
        JLabel additionaldetails = new JLabel( "PAGE 2 :- ADDITIONAL DETAILS ");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,25));
        additionaldetails.setBounds(220,80,400,30);
        add(additionaldetails);
        
        //Religion
        JLabel rel = new JLabel( "Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        String valReligion[]={"Hindu","Sikh","Muslim","Christan"};
        religion= new JComboBox (valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        //category
        JLabel category = new JLabel( "Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,150,30);
        add(category);
                
        String valcategory[]={"Genaral","OBC","SC","ST"};
        cate= new JComboBox (valcategory);
        cate.setBounds(300,190,400,30);
        add(cate);
    
        //Income
        JLabel income = new JLabel( "Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valincome[]={"Null","< 1,50,000","<2,50,000","< 5,00,000","upto 10,00,000"};
        val= new JComboBox (valincome);
        val.setBounds(300,240,400,30);
        add(val);
        
        //Education
        JLabel education = new JLabel( "Education:");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        String valeducation[]={"Non-Graduation","Graduate","Post-Graduate","Doctorate","Others"};
        edu= new JComboBox (valeducation);
        edu.setBounds(300,290,400,30);
        add(edu);
        
        //Occupation
        JLabel occupation = new JLabel( "Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);
        
        String valoccupation[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        ocu= new JComboBox (valoccupation);
        ocu.setBounds(300,340,400,30);
        add(ocu);
        
        //PanNumber
        JLabel panno = new JLabel( "Pan Number :");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,390,200,30);
        add(panno);
        
        pannoTextField = new JTextField();
        pannoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pannoTextField.setBounds(300,390,400,30);
        add(pannoTextField);
        
        //Aadhar Number
        JLabel adhno = new JLabel( "Aadhar Number :");
        adhno.setFont(new Font("Raleway",Font.BOLD,20));
        adhno.setBounds(100,440,200,30);
        add(adhno);
        
        adhnoTextField = new JTextField();
        adhnoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adhnoTextField.setBounds(300,440,400,30);
        add(adhnoTextField);
        
        //Senior Citizen
        JLabel seniorcitizen = new JLabel( "Senior Citizen :");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,490,200,30);
        add(seniorcitizen);
        
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(300,490,60,30);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        no1 = new JRadioButton("No");
        no1.setBounds(450,490,80,30);
        no1.setBackground(Color.WHITE);
        add(no1);
        
        //Selecting button
        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(yes1);
        scgroup.add(no1);
        
        //Existing Account
        JLabel ea = new JLabel( "Existing Account:");
        ea.setFont(new Font("Raleway",Font.BOLD,20));
        ea.setBounds(100,540,200,30);
        add(ea);
        
        yes2 = new JRadioButton("Yes");
        yes2.setBounds(300,540,100,30);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        no2 = new JRadioButton("No");
        no2.setBounds(450,540,100,30);
        no2.setBackground(Color.WHITE);
        add(no2);
        
        
        //Selecting button
        ButtonGroup ea2 = new ButtonGroup();
        ea2.add(yes2);
        ea2.add(no2);
     
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);//Adding here frame size
        setVisible(true);//make frame visible  
        setLocation(350,10);//To mFrame location
    }
    public void actionPerformed (ActionEvent ae){
        
      String sreligion = (String)religion.getSelectedItem();
      String scate = (String)cate.getSelectedItem();
      String sval = (String)val.getSelectedItem();
      String socu = (String)ocu.getSelectedItem();
      String sedu = (String)edu.getSelectedItem();
      String panno = pannoTextField.getText();
      String adhnno = adhnoTextField.getText();
      String senior = null;
      if(yes1.isSelected()){
          senior="YES";
      }else if(no1.isSelected()){
          senior="NO";
      }
      
      String exist = null;
      if(yes2.isSelected()){
          exist="Yes";
      }else if(no2.isSelected()){
          exist="No";
      }
     
      
      try {
            Conn c= new Conn();
            String query ="insert into signuptwo values ('" + formno+"','"+ sreligion+"','"+ scate+"','" + sval+"','" + socu+"','" + sedu+"','" + panno+"','"+ adhnno+"','"+ senior+"','"+ exist+"')";
            c.s.executeUpdate(query);   
            
            //Signup3 obj
            setVisible(false);
            new Signupthree(formno).setVisible(true);
            
    }
    catch(Exception e){
        System.out.println(e);
        } 
      
    }
public static void main(String args[]){
        new Signuptwo("");
            
        
    }}


    
    
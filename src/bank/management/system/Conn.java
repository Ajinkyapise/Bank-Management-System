
package bank.management.system;
import java.sql.*;

/**
 *
 * @author ajink
 */
public class Conn {
    
            
    Connection c;   
    Statement s ; 
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","ajinkya33");//Connection Sting made
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
    }
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Haran
 */
public class DBconnection {
    
    private Connection con;
    
    public static Connection connectDB(){
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/agent_systems", "root", "");
            
            return conn;  
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
              return null;
        }
      
        
    }
    
}

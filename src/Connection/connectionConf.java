/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author c0652863
 */
public class connectionConf {
    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
            connection = DriverManager.getConnection("jdbc:as400:174.79.32.158","IBM65","IBM65");
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
                
        return connection;
    }
}

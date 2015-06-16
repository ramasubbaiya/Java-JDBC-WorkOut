
import Connection.connectionConf;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author c0652863
 */
public class App {
    
    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            connection = connectionConf.getConnection();
            if (connection != null) {
                System.out.println("Connected Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }
    }
}

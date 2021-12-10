/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raulp
 */
public class MailListReaderBD {
    
    
    private static Connection connect(String db) {
        // Cadena de conexión SQLite
        String url = "jdbc:sqlite:" + db;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    public static List<String> read() {
        
        List<String> list = new ArrayList<>();
        String sql = "SELECT * FROM EMAIL";
        
        try (Connection conn = connect("kata5.db");
             Statement stmt = conn.createStatement();
             ResultSet rs  = stmt.executeQuery(sql)){
            
            while (rs.next()){
                list.add(rs.getString("mail"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}


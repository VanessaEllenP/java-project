/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class Conexao {
        public Connection conectaBd() {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost/estoque?user=root&password=lana2106";
            conn = DriverManager.getConnection(url);
                    
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        
        return conn;
    }
}
    
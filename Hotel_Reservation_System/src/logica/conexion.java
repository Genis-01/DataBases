/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ciclesgs
 */
public class conexion {
    public String db="basereserva";
    public String url="jdb:mysql://127.0.0.1" +db;
    public String user="root";
    public String pass="";
    
    public conexion (){
        
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
        
        
    }
    
}

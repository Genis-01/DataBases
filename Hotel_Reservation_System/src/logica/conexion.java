/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

// This part is importing all the libraries that we’ll be needing to make the code.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ciclesgs
 */
// This class is responsible for saving the information that is needed for the connection between the database and this document.
public class conexion {
    public String db="basereserva";
    public String url="jdb:mysql://127.0.0.1" +db;
    public String user="root";
    public String pass="";
    
    public conexion (){
        
    }
    // This method uses the information from conexion to connect the database with this document, and if an error occurs, it executes the catch.
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

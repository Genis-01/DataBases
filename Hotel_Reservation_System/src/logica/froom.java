/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.beans.*;
import java.sql.*;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import datos.vroom;

/**
 *
 * @author ciclesgs
 */
public class froom {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = { "id", "capacity", "price" };

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from room where piso like '%" + buscar + "%' ordenar by room_id";

        try {
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("room_id");
                registro[1] = rs.getString("capacity");
                registro[2] = rs.getString("price");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vroom  dts){
        sSQL = "INSERT INTO room (room_id,capacity,price)" + "VALUES (?,?,?)";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getIdroom());
            pst.setInt(2, dts.getCapacity());
            pst.setDouble(3, dts.getPrice());

            int n=pst.executeUpdate();

            if (n!=0) {
                return true;
                
            }else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean editar(vroom dts) {
        sSQL="update room set room_id=?, capacity=?, price=?" + "where room_id=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getIdroom());
            pst.setInt(2, dts.getCapacity());
            pst.setDouble(3, dts.getPrice());

            int n=pst.executeUpdate();

            if (n!=0) {
                return true;
                
            }else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vroom dts) {

        sSQL="delate from room where room_id=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getIdroom());
            

            int n=pst.executeUpdate();

            if (n!=0) {
                return true;
                
            }else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MysqlFunctions {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hrs2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<Room> reedRooms() {

        List<Room> rooms = new ArrayList<Room>();
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String insertQuery = "SELECT * FROM rooms";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int room_id = rs.getInt("room_id");
                String room_number = rs.getString("room_number");
                String room_type = rs.getString("room_type");
                int capacity = rs.getInt("capacity");
                Double price = rs.getDouble("prices");

                rooms.add(new Room(room_id, room_number, room_type, capacity, price));

            }
            // Close the connection
            connection.close();
            return rooms;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Reservation> reedReservations() {

        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String insertQuery = "SELECT * FROM reservations";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int reservationId = rs.getInt("reservation_id");
                int roomId = rs.getInt("room_id");
                String guestName = rs.getString("guest_name");
                String checkInDate = rs.getString("check_in_date");
                String checkOutDate = rs.getString("check_out_date");


                reservations.add(new Reservation(reservationId, roomId, guestName, checkInDate, checkOutDate));

            }
            // Close the connection
            connection.close();
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Reservation> reedReservationsSerch(String name) {

        List<Reservation> reservations = new ArrayList<Reservation>();
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String insertQuery = "SELECT * FROM reservations WHERE guest_name = '" + name + "'";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int reservationId = rs.getInt("reservation_id");
                int roomId = rs.getInt("room_id");
                String guestName = rs.getString("guest_name");
                String checkInDate = rs.getString("check_in_date");
                String checkOutDate = rs.getString("check_out_date");


                reservations.add(new Reservation(reservationId, roomId, guestName, checkInDate, checkOutDate));

            }
            // Close the connection
            connection.close();
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void newreservation(int roomId, String guestName, String checkInDate, String checkOutDate) {

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert reservation
            String insertQuery = "INSERT INTO Reservations (room_id, guest_name, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, roomId);
                preparedStatement.setString(2, guestName);
                preparedStatement.setString(3, checkInDate);
                preparedStatement.setString(4, checkOutDate);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reservation added successfully!");
            }
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void editreservation(int reservationId, int roomId, String guestName, String checkInDate, String checkOutDate) {

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert reservation
            String insertQuery = "UPDATE reservations " +
                                 "SET room_id = ?, " +
                                 "guest_name = ?, " +
                                 "check_in_date = ?, " +
                                 "check_out_date = ?" +
                                 "WHERE reservation_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                
                preparedStatement.setInt(1, roomId);
                preparedStatement.setString(2, guestName);
                preparedStatement.setString(3, checkInDate);
                preparedStatement.setString(4, checkOutDate);
                preparedStatement.setInt(5, reservationId);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reservation edited successfully!");
            }
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void delatereservation(int reservationId) {

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert reservation
            String insertQuery = "DELETE FROM reservations WHERE reservation_id = ?";
;
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                
                
                preparedStatement.setInt(1, reservationId);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reservation delated successfully!");
            }
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}

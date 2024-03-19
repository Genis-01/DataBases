import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HotelReservationApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hrs2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Example reservation data (you can replace this with user input)
            int roomId = 1; // Room ID
            String guestName = "John Doe";
            String checkInDate = "2024-03-20"; // Format: yyyy-MM-dd
            String checkOutDate = "2024-03-25";

            // Insert reservation
            String insertQuery = "INSERT INTO Reservations (room_id, guest_name, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, roomId);
                preparedStatement.setString(2, guestName);
                preparedStatement.setString(3, checkInDate);
                preparedStatement.setString(4, checkOutDate);
                preparedStatement.executeUpdate();
                System.out.println("Reservation added successfully!");
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


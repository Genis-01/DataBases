
import java.util.List;

public class Reservation {
    private int reservationId;
    private int roomId;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;

    // Constructors
    public Reservation(int reservationId, int roomId, String guestName, String checkInDate, String checkOutDate) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    public Reservation(){
        
    }

    // Getters and setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    public Object [] toObject(){
        return new Object []{this.reservationId, this.roomId, this.guestName, this.checkInDate, this.checkOutDate};
    }

    public Object [][] reservationsToTable(List<Reservation> reservations){
        
        Object [][] table = new Object[reservations.size()][1];

        for (int i = 0; i < reservations.size(); i++) {
            table[i] = reservations.get(i).toObject();
        }
        return table;
    }


    
}
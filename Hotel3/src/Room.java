
import java.util.List;

public class Room {
    private int room_id;
    private String room_number;
    private String room_type;
    private int capacity;

    // Constructors
    public Room(int room_id, String room_number, String room_type, int capacity) {
        this.room_id = room_id;
        this.room_number = room_number;
        this.room_type = room_type;
        this.capacity = capacity;
    }

    public Room(){
        
    }

    // Getters and setters
    public int getRoomId() {
        return room_id;
    }

    public void setRoomId(int room_id) {
        this.room_id = room_id;
    }

    public String getRoomNumber() {
        return room_number;
    }

    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }

    public String getRoomType() {
        return room_type;
    }

    public void setRoomType(String room_type) {
        this.room_type = room_type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Object [] toObject(){
        return new Object []{this.room_id, this.room_number, this.room_type,this.capacity};
    }

    public Object [][] roomsToTable(List<Room> rooms){
        
        Object [][] table = new Object[rooms.size()][1];

        for (int i = 0; i < rooms.size(); i++) {
            table[i] = rooms.get(i).toObject();
        }
        return table;
    }

    @Override
    public String toString() {
        
        return "ID: " + room_id + ", room number: " + room_number + ", room type: " + room_type + ", capacity; "+ capacity;
    }
    
}
import java.util.ArrayList;
import java.util.HashMap;

class Room {
    private String roomTitle;
    private String roomDescription;
    private ArrayList<Item> itemContainer;
    private HashMap<String, Room> roomMap;

    Room(String roomTitle, String roomDescription) {
        this.roomTitle = roomTitle;
        this.roomDescription = roomDescription;
    }

    String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    HashMap<String, Room> getRoomMap() {
        return roomMap;
    }

    void setRoomMap(HashMap<String, Room> roomMap) {
        this.roomMap = roomMap;
    }

    Room getExitRoom(String direction){
        return roomMap.get(direction);
    }

    ArrayList<Item> getItemContainer() {
        return itemContainer;
    }

    void setItemContainer(ArrayList<Item> itemContainer) {
        this.itemContainer = itemContainer;
    }

}
package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elinor
 */
public class World implements Serializable{
    private String name;
    private ArrayList<Room> Containroom = new ArrayList<Room>();
    public World(String name){
        this.name = name;
    }
    public void addRoom(Room R){
        Containroom.add(R);
    } 

    ArrayList<Room> returnRoom() {
        return Containroom;
    }
    
}

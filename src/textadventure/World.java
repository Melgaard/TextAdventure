package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elinor
 */
public class World implements Serializable{
    
    private final String heroName;
    private int heroPosition;
    
    private ArrayList<Room> Containroom = new ArrayList<Room>();
    
    //Constructor
    public World(String name){
        this.heroName = name;
    }
    
    //Methods
    public void addRoom(Room R){
        Containroom.add(R);
    } 

    
    
    //Getters and setters
    
    public ArrayList<Room> getRoomArrayList() {
        return Containroom;
    }
    
    public String getHeroName(){
        return heroName;       
    }
    
    public int getHeroPosition(){
        return heroPosition;
    }
    
    public void setHeroPosition(int newHeroPostition){
        
        heroPosition = newHeroPostition;
    }
    
}

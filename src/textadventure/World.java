package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elinor
 */
public class World implements Serializable{
    
    private String heroName;
    private int heroPosition;
    
    private ArrayList<Room> Containroom = new ArrayList<Room>();
    
    public World(String name){
        this.heroName = name;
    }
    
    public void addRoom(Room R){
        Containroom.add(R);
    } 

    ArrayList<Room> returnRoom() {
        return Containroom;
    }
    
    //Getters and setters
    
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

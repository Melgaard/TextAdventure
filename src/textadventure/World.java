package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elinor
 */
public class World implements Serializable{
    
    private final String heroName;
    private int heroPosition = 1;
    Hero sir;
    Room foyer;
    Room basement;
    Room kitchen;
    Room hallway;
    Room bar;
    Room library;
    Room throneRoom;
    
    private ArrayList<Room> Containroom = new ArrayList<Room>();
    
    //Constructor
    public World(String name){
        this.heroName = name;
        
        sir = new Hero(heroName);
        
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

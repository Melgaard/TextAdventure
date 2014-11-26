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
    Key darkness;
    Key throne;
    Weapon knife;
    Weapon sword;
    Weapon spellbook;
    Light lantern;
    
    
    private ArrayList<Room> Containroom = new ArrayList<Room>();
    
    //Constructor
    public World(String name){
        
        this.heroName = name;
        
        sir = new Hero(heroName);
        
        Room foyer = new Room(1);
        Room basement = new Room(2);
        Room kitchen = new Room(3);
        Room hallway = new Room(4);
        Room bar = new Room(5);
        Room library = new Room(6);
        Room throneRoom = new Room(7);
        
        Key darkness = new Key(1, "darknessKey", "barDoor"); 
        Key throne = new Key(1, "throneKey", "throneRoomDoor");
        Weapon knife = new Weapon(3, "Knife", 1);
        Weapon sword = new Weapon(5, "Sword", 2);
        Weapon spellbook = new Weapon(2, "Spellbook", 3);
        Light lantern = new Light(2, "Lantern", 2);
        
        basement.addItem(darkness);
        kitchen.addItem(lantern);
        kitchen.addItem(knife);
        hallway.addItem(sword);
        library.addItem(spellbook);
        library.addItem(throne);
        
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

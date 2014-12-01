package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Melgaard
 */
public class World implements Serializable {

    private final String heroName;
    private int heroPosition = 1;

    String wholeStory;

    private boolean room3DrawersSearched = false;
    private String knightActivated = "deactivated";

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
    public World(String name) {

        this.heroName = name;

        sir = new Hero(heroName);

        foyer = new Room(1);
        basement = new Room(2);
        kitchen = new Room(3);
        hallway = new Room(4);
        bar = new Room(5);
        library = new Room(6);
        throneRoom = new Room(7);

        darkness = new Key(1, "darknessKey", "barDoor");
        throne = new Key(1, "throneKey", "throneRoomDoor");
        knife = new Weapon(3, "Knife", 1);
        sword = new Weapon(5, "Sword", 2);
        spellbook = new Weapon(2, "Spellbook", 3);
        lantern = new Light(2, "Lantern", 2);

        basement.addItem(darkness);
        kitchen.addItem(lantern);
        kitchen.addItem(knife);
        hallway.addItem(sword);
        library.addItem(spellbook);
        library.addItem(throne);

        Containroom.add(foyer);
        Containroom.add(basement);
        Containroom.add(kitchen);
        Containroom.add(hallway);
        Containroom.add(bar);
        Containroom.add(library);
        Containroom.add(throneRoom);

    }

    //Methods
    public void addRoom(Room R) {
        Containroom.add(R);
    }

    //Getters and setters
    public ArrayList<Room> getRoomArrayList() {
        return Containroom;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroPosition() {
        return heroPosition;
    }

    public void setHeroPosition(int newHeroPostition) {

        heroPosition = newHeroPostition;
    }

    public void setRoom3DrawersSearched(boolean b) {
        room3DrawersSearched = b;
    }

    public void setRoom4KnightActivated(String b) {
        if (b.equals("activated") || b.equals("deactivated") || b.equals("defeated"))  {
            knightActivated = b;
        }
    }

    public boolean getRoom3DrawersSearched() {
        return room3DrawersSearched;
    }

    public String getRoom4KnightActivated() {
        return knightActivated;
    }

}

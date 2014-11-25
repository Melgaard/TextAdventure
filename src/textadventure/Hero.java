package textadventure;

import java.util.ArrayList;

/**
 *
 * @author Blotto
 */
public class Hero {
    
    private final String heroName;
    private ArrayList<Item> Inventory = new ArrayList<Item>();
    
    //Constructor
    public Hero(String name){
        heroName = name;
    }
    
    //Methods
    public void addItem (Item I){
        Inventory.add(I);
    } 
    
    //Getters and setters
    public String getHeroName(){
        return heroName;
    }
   

}

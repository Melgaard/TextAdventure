package textadventure;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Blotto
 */
public class Hero implements Serializable {
    
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
    
    public ArrayList<Item> getInventoryArray()
    {
        return Inventory;
    }
    
    public String getInventoryString()
    {
        String inventory = "";
        for (Item i : Inventory)
        {
           inventory = inventory + i.getName() + "\n";
        }
        return inventory;
    }
   

}

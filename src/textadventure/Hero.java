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
    private boolean isAlive = true;
    
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
    public int getHeroStrenght(){
        
        int currentStrength = 1;
        
        for (Item i : Inventory)
        {
            try {
           if (i.getClass().equals(Weapon.class)){
               Weapon w = (Weapon) i;
               currentStrength += w.getStr();
           }
            }catch (Exception ClassCastException){
                System.out.println("Typecasting error in hero.getStr");
            }
        }
        
        return currentStrength;
    }
   
    public boolean getHeroAlive(){
        return isAlive;
    }
    
    public void setHeroAlive(boolean b){
        isAlive = b;
    }

}

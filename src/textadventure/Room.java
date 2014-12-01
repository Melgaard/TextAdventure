package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elinor
 */
public class Room implements Serializable{
    private final int Id;    
    private ArrayList<Item> Contain = new ArrayList<Item>();
    
    //Constructor
    public Room(int id){
        
        Id = id;
        
    }
    
    //Methods  
    public void addItem (Item I){
        Contain.add(I);
    }
    
    public void removeItem (Item I){
        
        Contain.remove(I);
        
    }
    
    
    //Getters
    public int returnId(){
        return Id;
    }
    
    public ArrayList getArrayList(){
        return Contain;
    }
    
    
}

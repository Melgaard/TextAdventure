package textadventure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elinor
 */
public class Room implements Serializable{
    private int Id;
    private ArrayList<Item> Contain = new ArrayList<Item>();
    public Room(int Id){
        this.Id = Id;
    }  
    public void addItem (Item I){
        Contain.add(I);
    } 
    public int returnId(){
        return Id;
    }
    
}

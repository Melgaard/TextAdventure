package textadventure;

import java.io.Serializable;

/**
 *
 * @author Elinor
 */
public class Item implements Serializable {
    private final int weight;
    private final String name;
    
    
    public Item(int weight, String name){
      this.weight = weight;
      this.name = name;
    }
    
    
    //Getters and setters
    public String getName(){
        return name;
    }
    public int getWeight(){
        return weight;
    }
   
}

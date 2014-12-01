package textadventure;

/**
 *
 * @author Elinor
 */

public class Light extends Item {
    
    private final int LightStr;
    
    public Light (int weight, String name, int str){
      super(weight, name);
      this.LightStr = str;
    }
    
    public int getLightStr()
    {
        return LightStr;
    }
    
}

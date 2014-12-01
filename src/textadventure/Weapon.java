package textadventure;

/**
 *
 * @author Blotto
 */
public class Weapon extends Item {
    private final int Str;
    
    
    public Weapon (int weight, String name, int str){
      super(weight, name);
      this.Str = str;
    }
    public int getStr(){
        return Str;
    }
}

package textadventure;


public class Key extends Item {
    private int Str;
    
    public Key (int weight, String name, int str){
      super(weight, name);
      this.Str = str;
    }
    
    public int getStr()
    {
        return Str;
    }
    
}

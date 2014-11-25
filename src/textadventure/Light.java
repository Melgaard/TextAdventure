package textadventure;

public class Light extends Item {
    
    private int Str;
    
    public Light (int weight, String name, int str){
      super(weight, name);
      this.Str = str;
    }
    
    public int getStr()
    {
        return Str;
    }
    
}

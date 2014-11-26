package textadventure;


public class Key extends Item {
    private String doorFit;
    
    public Key (int weight, String name, String doorFit){
        
      super(weight, name);
      this.doorFit = doorFit;
      
    }
    
    public String getDoor()
    {
        return doorFit;
    }
    
}

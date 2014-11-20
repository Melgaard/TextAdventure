package textadventure;

/**
 *
 * @author Blotto
 */
public class TextInput {
    
    String CheckTextInput(String UserActionInput){
        
        switch (UserActionInput){
            case "1": 
                
                System.out.println("text output");
                ChangeRoomVariables();
                ChangeHeroVariables();
                break;
            case "2":
                
                break;
                
            default:
                
                System.out.println("You cant do that");
                BackToInput();
                
                        
                     
            
        }
        return null;
    }
}

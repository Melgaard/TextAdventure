package textadventure;

/**
 *
 * @author Blotto
 */
class text {
    
    private static String introText;
    
    private static String room1IntroText;
    private static String room2IntroText;
    private static String room3IntroText;
    private static String room4IntroText;
    private static String room5IntroText;
    private static String room6IntroText;
    private static String room7IntroText;

    public static String inputAction(int roomID, String userInput, World gameWorld) {
        
        String[] command = userInput.split(" ");
        if(command.length!=2){throw new IllegalArgumentException();}
        String action = command[0];
        String object = command[1];
        
        
        if (roomID == 1){
            
            switch (action){
                case "move": 
                    
                    switch (object){
                        case "north":
                            
                            gameWorld.setHeroPosition(4);
                            return room4IntroText;                            
                            
                        case "east":
                            
                            gameWorld.setHeroPosition(3);
                            return room3IntroText;
                            
                        case "south":
                            
                            return "You cant leave the castle, your code of honor compels you too stay!";
                            
                        case "west":
                            
                            gameWorld.setHeroPosition(2);
                            return room2IntroText;
                    }


                    break;
                case "Fight":

                    return "There is nothing to fight";

                    
                case "Use":



                    break;
                case "Search":



                    break;
                case "Take":



                    break;
                default:

                    return "You cant do that";                    

            }
            
        }
        else if (roomID == 2){
            
        }
           
        
        return null;
    }
    
    //Getters og Setters
    
    public static String getIntroText(){
        return introText;
    }
    
    public static String getRoom1IntroText(){
        return room1IntroText;
    }
}

package textadventure;

/**
 *
 * @author Blotto
 */
class text {
    
    private static String room1IntroText;
    private static String room2IntroText;
    private static String room3IntroText;
    private static String room4IntroText;
    private static String room5IntroText;
    private static String room6IntroText;
    private static String room7IntroText;

    public static String inputAction(int roomID, String action, String object, World gameWorld) {
        
        
        
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



                    break;
                case "Use":



                    break;
                case "Search":



                    break;
                case "Take":



                    break;
                default:

                    System.out.println("You cant do that");                    

            }
            
        }
        else if (roomID == 2){
            
        }
           
        
        
    }
    
}

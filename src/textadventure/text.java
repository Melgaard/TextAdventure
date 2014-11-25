package textadventure;

/**
 *
 * @author Blotto
 */
class text {
    private static String introText = " had spent many years as squire for the noble king Cappi, before he was knighted and earned the title: Sir Hero\n" +
"But during the time he was away, his sibling plotted an evil scheme, to kill their father and Sir Hero and inherit the family castle!\n" +
"Sir Hero as a noble knight cannot stand idly by while his father is murdered! So Sir Hero traveled to his fathers castle to save him.\n" +
"But his sibling had already arrived and taken their father captive. Sir Hero must enter the castle to free his father!";
    
    private static String room1IntroText = "You have entered the castle and now find yourself to be in the entré.\n" +
"\n" +
"On your left hand you see some stairs, leading down to the cellar. Right now you see nothing there but darkness.\n" +
"\n" +
"In front of you, there is a door. \n" +
"You remember it to open onto the hallway, but it has been years since you last visited so you are not quite sure.\n" +
"\n" +
"On your right, you see the door to the kitchen. Next to the door you see a big painting.";
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

                    System.out.println("You cant do that");                    

            }
            
        }
        else if (roomID == 2){
            
        }
           
        
        return null;
    }
    
    //Getters og Setters
    
    public static String getIntroText(String nameOfHero){
        return nameOfHero + introText + "\n" + room1IntroText;
    }
    
    
    
}

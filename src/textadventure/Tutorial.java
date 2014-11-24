package textadventure;

import javax.swing.JOptionPane;

/**
 *
 * @author Blotto
 */
public class Tutorial extends JOptionPane {
    
    public Tutorial(){
        
        //When the tutorial is class is created it creates a JOptionPane with tutorial text and a ok/close button
        JOptionPane.showMessageDialog(this,
                    "Welcome to the tutorial "
                + "\nThis game is a text based adventure game and it is played by writing commands in the input field"
                + "\nThe commands available in The Adventures of Sir Hero are: "
                + "\nMove + Direction, this moves you to the next room in the direction if there is a door, the possible directions are: North, South, East, West."
                + "\nFight, this makes you fight the enemy in the room, fighting compares your strenght and the monsters strenght and the highest wins."
                + "\nUse/Search/Take + object, is the way to interact with objects in the game."
                + "\nAll commands are written with letters and spaces only do NOT write the \"+\".",
                "Tutorial",
                WIDTH);
        
    
    }
}

package textadventure;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sami
 */
public class InGameMenu extends JFrame implements ActionListener {

    //Initializes our buttons
    JButton resumeGameButton   = new JButton("Resume Game");
    JButton saveGameButton  = new JButton("Save Game");
    JButton exitButton  = new JButton("Exit Game");  
    GUI gui;
    
    
    public InGameMenu(GUI gui){
        //sets our GUI object
        this.gui = gui;
 
       
        //Adds ActioListener too our buttons
        resumeGameButton.addActionListener(this);
        saveGameButton.addActionListener(this);
        exitButton.addActionListener(this);       
        
        
        //Creates our startmenu frame
        this.setTitle("Adventures of Sir Hero");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(true);
        this.setLocationRelativeTo(null);        
        this.setLayout(new GridLayout(3, 1));    
        
        //Adds our buttons to our gridlayout
        this.add(resumeGameButton);
        this.add(saveGameButton);
        this.add(exitButton);        
        
        
        this.setVisible(true);
        
        
    }

    //ActionListener who decides what our buttons can do
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == resumeGameButton){
            gui.setVisible(true);
            this.dispose();
        }
        else if (ae.getSource() == saveGameButton){
            
            Save s = new Save();
            
            s.saveWorldCheck(gui.gameWorld);
            
            s = null;
            
        }
        else if (ae.getSource() == exitButton){
            int answer = JOptionPane.showConfirmDialog(this, "Do you want to save first");
            if (answer == 0){
                Save s = new Save();
            
            s.saveWorld(gui.gameWorld);
            exit(0);
            }
            else if (answer == 1){
            exit(0);
            }
            else if (answer == 2){
                
            }
        }
        
        
    }


    
    
}

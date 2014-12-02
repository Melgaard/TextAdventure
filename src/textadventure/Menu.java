package textadventure;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sami, Melgaard
 */
public class Menu extends JFrame implements ActionListener {

    //Initializes our buttons
    JButton newGameButton   = new JButton("New Game");
    JButton loadGameButton  = new JButton("Load Game");
    JButton tutorialButton  = new JButton("Tutorial");  
    
    
    public Menu(){
        
 
       
        //Adds ActioListener too our buttons
        newGameButton.addActionListener(this);
        loadGameButton.addActionListener(this);
        tutorialButton.addActionListener(this);       
        
        
        //Creates our startmenu frame
        this.setTitle("Adventures of Sir Hero");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(true);
        this.setLocationRelativeTo(null);        
        this.setLayout(new GridLayout(3, 1));    
        
        //Adds our buttons to our gridlayout
        this.add(newGameButton);
        this.add(loadGameButton);
        this.add(tutorialButton);        
        
        
        this.setVisible(true);
        
        
    }

    //ActionListener who decides what our buttons can do
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == newGameButton) {
            try {
                String name = JOptionPane.showInputDialog(this, "What is your name");

                if (name.length() > 0) {

                    World world = new World(name);
                    TextArchive.setHeroName(name);
//                    System.out.println(name);
//                    System.out.println(TextArchive.getHeroName());
                    GUI gui = new GUI(world);

                }
            } catch (Exception NullPointerException) {
                System.out.println("NullPointerException caught in cancel function");
            }
            this.dispose();
        }
        else if (ae.getSource() == loadGameButton){
                    
            Save s = new Save();
            
            GUI gui = new GUI(s.getGame());
            gui.wholeStory = s.getGame().wholeStory;
            gui.output.setText(gui.wholeStory);
            
            this.dispose();
            s = null;   
        }
        else if (ae.getSource() == tutorialButton){
            Tutorial tutorial = new Tutorial();
        }
        
        
    }


    
    
}

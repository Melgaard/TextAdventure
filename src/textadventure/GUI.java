package textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.border.Border;


/**
 *
 * @author Sami
 */
public class GUI extends JFrame implements ActionListener, KeyListener{
        
    JPanel Center = new JPanel();
    Font InventoryFont = new Font("Times New Roman", Font.PLAIN, 18);
    Font HeroFont = new Font("Old English Text MT", Font.ITALIC+Font.BOLD, 32);
    Border borderText = BorderFactory.createLineBorder(Color.BLACK, 2);
    Border borderInventory = BorderFactory.createLineBorder(Color.BLACK, 2, true);
    JButton Menu = new JButton("Menu");
    JButton Tutorial = new JButton("Tutorial");
    JTextArea Inventory = new JTextArea("Inventory");
    JTextArea output = new JTextArea("Text Output");
    JTextField input = new JTextField(25);
    World gameWorld;
    String wholeStory;
    
    
    public GUI(World world) 
    {
        wholeStory = TextArchive.getIntroText() + "\n" + TextArchive.getRoom1IntroText();
        gameWorld = world;
        
        this.setTitle("Text Adventure"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        Center.setLayout(new BorderLayout());
        createButtonsAndInventoryBorderLayout();
        createTextInputAndHeroLabelGridLayout();
        createTextOutput();
        this.add(Center);
        
        this.setVisible(true);
    }
    
    //This method creates the buttons in the topright corner as well as the inventory
    public void createButtonsAndInventoryBorderLayout() 
    {
        JPanel East = new JPanel();
        JPanel ButtonFlow = new JPanel();

        
        
        East.setLayout(new BorderLayout());
        ButtonFlow.setLayout(new FlowLayout());
        
        Menu.addActionListener(this);
        Tutorial.addActionListener(this);
        ButtonFlow.add(Tutorial);
        ButtonFlow.add(Menu);
        
        Inventory.setEditable(false);
        Inventory.setBackground(Color.DARK_GRAY);
        Inventory.setFont(InventoryFont);
        Inventory.setForeground(Color.white);
        Inventory.setBorder(borderInventory);
        
        East.add(ButtonFlow, BorderLayout.NORTH);
        East.add(Inventory, BorderLayout.CENTER);
        
        this.add(East, BorderLayout.EAST);
        
    }

    //This method creates the inputbox and displays the hero name in the top of the JFrame
    public void createTextInputAndHeroLabelGridLayout()
    {
        
        JPanel North = new JPanel();
        
        input.requestFocusInWindow();
        input.setBorder(borderText);
        input.addKeyListener(this);
        JLabel HeroName = new JLabel("Sir Hero " + gameWorld.getHeroName());
        HeroName.setFont(HeroFont);
        
        North.setLayout(new GridLayout(2,1));
        North.add(HeroName);
        North.add(input);
        
        Center.add(North, BorderLayout.NORTH);
    }
    
    //This method creates the textoutputbox in the format of a JScrollPane 
    public void createTextOutput()
    {        
                      
        output.setEditable(false);  
        output.setText(wholeStory);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        
        JScrollPane outputScroll = new JScrollPane(output);
        outputScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        outputScroll.setBorder(borderText);
        Center.add(outputScroll, BorderLayout.CENTER);
        
    }
    
    //This ActionListener respectively opens the tutorial and the ingame menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Tutorial)
        {
            Tutorial t = new Tutorial();
        }
        if (e.getSource() == Menu)
        {
            this.setVisible(false);
            InGameMenu m = new InGameMenu(this);
        }
    }
    
    //This KeyListener sends the text typed in the inputbox as a string when enter is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            
            String command  = input.getText().toLowerCase();
            String response = TextArchive.inputAction(gameWorld.getHeroPosition(), command, gameWorld);
            input.setText("");
            if (gameWorld.sir.getHeroAlive() == false){
                input.setEditable(false);
            }
            wholeStory = wholeStory + "\n" + " -" + command + "\n" + response;
            output.setText(wholeStory);
            gameWorld.wholeStory = this.wholeStory;
            updateInventory();
            
            
            
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    public void updateInventory()
    {
        Inventory.setText(gameWorld.sir.getInventoryString());
        
    }
}

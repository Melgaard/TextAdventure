package textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sami
 */
public class GUI extends JFrame implements ActionListener{
    
    JPanel Center = new JPanel();
    Font InventoryFont = new Font("Times New Roman", Font.PLAIN, 18);
    Font HeroFont = new Font("Old English Text MT", Font.ITALIC+Font.BOLD, 32);
    Border borderText = BorderFactory.createLineBorder(Color.BLACK, 2);
    Border borderInventory = BorderFactory.createLineBorder(Color.BLACK, 2, true);
   
    
    
    public GUI() 
    {
        
        this.setTitle("Text Adventure"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
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
    

    public void createButtonsAndInventoryBorderLayout() 
    {
        JPanel East = new JPanel();
        JPanel ButtonFlow = new JPanel();
        JButton Menu = new JButton("Menu");
        JButton Tutorial = new JButton("Tutorial");
        JTextArea Inventory = new JTextArea("Inventory");
        
        
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

    public void createTextInputAndHeroLabelGridLayout()
    {
        
        JPanel North = new JPanel();
        JTextField input = new JTextField(25);
        input.requestFocusInWindow();
        input.setBorder(borderText);
        JLabel HeroName = new JLabel("Sir " + "Hero Name");
        HeroName.setFont(HeroFont);
        
        North.setLayout(new GridLayout(2,1));
        North.add(HeroName);
        North.add(input);
        
        Center.add(North, BorderLayout.NORTH);
    }
    
    public void createTextOutput()
    {
        
        JTextArea output = new JTextArea("Text Output");
        output.setEditable(false);
        
        JScrollPane outputScroll = new JScrollPane(output);
        outputScroll.setBorder(borderText);
        Center.add(outputScroll, BorderLayout.CENTER);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

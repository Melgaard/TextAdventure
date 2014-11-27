package textadventure;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Elinor
 */
public class Save {

    private String fileName = "Game.txt";

    public World getGame() {
        World test = new World("test");
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            try {
                test = (World) in.readObject();
            } catch (Exception e) {

            } finally {
                in.close();
                fileIn.close();
            }

        } catch (IOException i) {

        }

        return test;
    }

    public void saveWorld(World world) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;

        try {
            File file = new File(fileName);

            file.createNewFile();

            fileOut = new FileOutputStream(fileName, false);
            out = new ObjectOutputStream(fileOut);

            out.writeObject(world);
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            try {
                out.close();
                fileOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void saveWorldCheck(World world) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;

        int overwriteAnswer = JOptionPane.showConfirmDialog(null, "Do you want to overwrite any current save");
        
        if (overwriteAnswer == 0) {

            try {
                File file = new File(fileName);

                file.createNewFile();

                fileOut = new FileOutputStream(fileName, false);
                out = new ObjectOutputStream(fileOut);

                out.writeObject(world);
            } catch (IOException i) {
                i.printStackTrace();
            } finally {
                try {
                    out.close();
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (overwriteAnswer == 1){
            
        }
        
        
        
    }
    
}

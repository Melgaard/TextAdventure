package TextAdventure;

import java.io.Serializable;

/**
 *
 * @author Elinor
 */
public class Item implements Serializable {

    private int weight;
    private String name;

    public Item(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public void test() {
        System.out.print(name);
    }

}

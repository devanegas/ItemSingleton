import java.util.Vector;

public class Item {
    private volatile static int parity = 0;
    private String name;

    private volatile static Vector<Item> Items;

    private Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Item getInstance() {
        return getNextInstance();
    }


    private synchronized static Item getNextInstance(){
        if(parity == 0){
            Items = new Vector<Item>();
            Items.add(new Item("First"));
        }
        else if(parity == 1){
            Items.add(new Item("Second"));
        }
        else if(parity == 2){
            Items.add(new Item("Third"));
        }

        return Items.get((parity++) %3);
    }

}

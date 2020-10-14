package model;

import persistence.Save;
import java.io.PrintWriter;
import java.util.*;

// Minifridge represents a hashMap of items along with it's name, this class represents what you can do with the items
public class MiniFridge implements Save {

    protected Map<String, Item> fridge;

    //EFFECTS: creates a new fridge
    public MiniFridge() {
        fridge = new HashMap<>();
    }

    public Map<String, Item> getFridge() {
        return this.fridge;
    }

    // MODIFIES: this
    // EFFECTS: adds an item to your fridge
    public void addFoodItem(Item i) {
        fridge.put(i.getItemName(), i);
    }

    //MODIFIES: this
    //EFFECTS: removes an item from the fridge
    public void removeFood(String itemName) {
        fridge.remove(itemName);
    }


    //EFFECTS: checks whether the fridge contains an item
    public boolean containsItem(String foodName) {
        return fridge.containsKey(foodName);
    }

    //EFFECTS: checks the size of the fridge
    public int size() {
        return fridge.size();
    }

    //EFFECTS: checks if the fridge is empty
    public boolean isEmpty() {
        return fridge.isEmpty();
    }

    // TellerApp Code
    // EFFECTS: saves the fridge
    //https://mkyong.com/java/how-to-loop-a-map-in-java/
    @Override
    public void save(PrintWriter printWriter) {
        fridge.forEach((String, Item) -> Item.save(printWriter));
    }


}

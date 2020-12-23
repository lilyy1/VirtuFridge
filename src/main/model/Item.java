package model;

import persistence.Reader;
import persistence.Save;
import java.io.PrintWriter;

// Item represents an object that has a name and a date that it was purchased both are strings
public class Item implements Save {
    protected String itemName;
    protected String expiryDate;

    //EFFECTS: creates a new item
    public Item(String itemName, String expiryDate) {
        this.itemName = itemName;
        this.expiryDate = expiryDate;
    }

    // EFFECTS: returns the description of the item
    public String getItemName() {
        return itemName;
    }


    // EFFECTS: returns the date the item was purchased
    public String getExpiryDate() {
        return expiryDate;
    }

    //TellerApp Code
    //EFFECTS: saves the item
    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(itemName);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(expiryDate);
        printWriter.print("\n");
    }

    //EFFECTS: override the equals in java
    //https://www.geeksforgeeks.org/overriding-equals-method-in-java/
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item i = (Item) o;

        return itemName.equals(i.getItemName());
    }
}

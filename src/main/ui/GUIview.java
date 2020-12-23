package ui;

import model.Item;

import javax.swing.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import static ui.GUI.fridge;

// represents the view option along with the functionality of the option
public class GUIview {
    // Effects: creates the view popup in the menu
    public void createView() {
        JFrame frame3 = new JFrame();
        frame3.setSize(500, 1000);
        frame3.setLayout(null);
        frame3.setVisible(true);
        //https://www.javatpoint.com/java-jlabel
        Map<String, Item> newFridge = fridge.getFridge();
//        for (Item i : newFridge) {
//            JLabel output = new JLabel(i.getItemName() + " " + i.getDatePurchased());
//            output.setBounds(200, addLength += 50, 200, 100);
//            frame3.add(output);
//        }
        AtomicInteger addLength = new AtomicInteger(5);
////        newFridge.forEach((String, Item) -> {
//        for (Map.Entry<String, String> entry : newFridge.entrySet()) {
//            JLabel output = new JLabel(Item.getItemName() + " " + Item.getExpiryDate());
//            output.setBounds(200, addLength.addAndGet(50), 200, 100);
//            frame3.add(output);
//        }
        //});
    }
}

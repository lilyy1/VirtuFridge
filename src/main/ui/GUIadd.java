package ui;

import model.Item;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static ui.GUI.fridge;

// represents the add option along with the functionality of the add option
public class GUIadd {

    public Calendar calendar = Calendar.getInstance();

    // Effects: creates the popup add frame in the menu
    public void addFunctionality() {
        JFrame frame1 = new JFrame();
        frame1.setSize(500, 1000);
        frame1.setLayout(null);
        frame1.setVisible(true);
        JTextField input = new JTextField();
        input.setBounds(160, 200, 170, 40);
        frame1.add(input);
        JButton submit = new JButton("Add Item");
        submit.setBounds(185, 250, 120, 30);
        frame1.add(submit);
        submit.addActionListener(e -> {
            String item = input.getText();
            //https://stackoverflow.com/questions/12575990/calendar-date-to-yyyy-mm-dd-format-in-java
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Item food = new Item(item, format1.format(calendar.getTime()));
            if (!fridge.containsItem(item)) {
                fridge.addFoodItem(food);
            }
        });
    }
}

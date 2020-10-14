package ui;

import javax.swing.*;
import static ui.GUI.fridge;

// represents the check option along with the functionality of the check option
public class GUIcheck {

    // Effects: creates the check frame
    public void createChecker() {
        JFrame frame = new JFrame();
        frame.setSize(500, 1000);
        frame.setLayout(null);
        frame.setVisible(true);
        JButton check = new JButton("Check if it is in the fridge");
        check.setBounds(132, 250, 230, 30);
        JTextField inputItem = new JTextField();
        inputItem.setBounds(160, 200, 170, 40);
        frame.add(check);
        frame.add(inputItem);
        check.addActionListener(e -> {
            String item = inputItem.getText();
            if (fridge.containsItem(item)) {
                doesContain();
            } else {
                doesNotContain();
            }
        });
    }

    // Effects: creates the message saying it contains the item
    public void doesContain() {
        JFrame popup = new JFrame();
        popup.setSize(500, 1000);
        popup.setLayout(null);
        popup.setVisible(true);
        JLabel label = new JLabel("This item is already in your fridge");
        label.setBounds(140, 200, 300, 200);
        popup.add(label);
    }

    // Effects: creates the message saying it does not contain the item
    public void doesNotContain() {
        JFrame popup = new JFrame();
        popup.setSize(500, 1000);
        popup.setLayout(null);
        popup.setVisible(true);
        JLabel label = new JLabel("This item is not in the fridge");
        label.setBounds(150, 200, 250, 200);
        popup.add(label);
    }
}

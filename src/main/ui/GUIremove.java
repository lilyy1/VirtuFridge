package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static ui.GUI.fridge;

// represents the remove option along with the functionality of the option
public class GUIremove {

    // Effects: creates the popup frame for the remove in the menu
    public void newRemoveItem() {
        JFrame frame2 = new JFrame();
        frame2.setSize(500, 1000);
        frame2.setLayout(null);
        frame2.setVisible(true);
        JTextField input = new JTextField();
        JLabel label = new JLabel("Enter the item to remove");
        label.setBounds(155, 350, 300, 50);
        frame2.add(label);
        input.setBounds(160, 400, 170, 40);
        frame2.add(input);
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String item = input.getText();
                    if (fridge.containsItem(item)) {
                        fridge.removeFood(item);
                        removedMessage();
                    }
                }
            }
        });
    }

    // Effects: creates the popup removed item message
    public void removedMessage() {
        JFrame removed = new JFrame();
        removed.setSize(500, 500);
        removed.setLayout(null);
        removed.setVisible(true);
        JLabel message = new JLabel("Item removed");
        message.setBounds(200, 150, 100, 100);
        JButton close = new JButton("ok");
        close.setBounds(225, 220, 60, 30);
        removed.add(message);
        removed.add(close);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removed.dispose();
            }
        });

    }
}

package ui;

import javax.swing.*;

// represents the check nutrition option along with the functionality of the check nutrition option
public class GUInutrition {

    public NutritionHttpRequest nutritionHttpRequest;


    // Requires: an item within the database
    // Effects: creates the nutrition frame
    public void createNutrition() {
        nutritionHttpRequest = new NutritionHttpRequest();
        JFrame frame3 = new JFrame();
        frame3.setSize(500, 1000);
        frame3.setLayout(null);
        frame3.setVisible(true);
        JButton checkNutrition = new JButton("Check the nutrition");
        checkNutrition.setBounds(142, 250, 200, 30);
        JTextField inputItem = new JTextField();
        inputItem.setBounds(160, 200, 170, 40);
        frame3.add(checkNutrition);
        frame3.add(inputItem);
        checkNutrition.addActionListener(e -> {
            String itemName = inputItem.getText();
            try {
                String nutritionInfo = nutritionHttpRequest.getNutrition("1" + itemName);
                nutritionInfoFrame(nutritionInfo);
            } catch (Exception a) {
                beMoreSpecificMessage();
            }
        });
    }

    // Effects: creates a popup message saying to pick a more specific item
    public void beMoreSpecificMessage() {
        JFrame specific = new JFrame();
        specific.setSize(500,500);
        specific.setLayout(null);
        specific.setVisible(true);
        final JLabel label = new JLabel("Please pick a more specific item");
        specific.add(label);
        label.setBounds(130,100,300,300);
    }

    // Effects: creates the popup frame of nutrition information
    public void nutritionInfoFrame(String s) {
        JFrame frame5 = new JFrame();
        frame5.setSize(500, 1000);
        frame5.setLayout(null);
        frame5.setVisible(true);
        final JLabel label = new JLabel(s);
        frame5.add(label);
        label.setBounds(100, 200, 300, 300);
    }

}

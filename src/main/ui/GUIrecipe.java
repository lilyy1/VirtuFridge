package ui;

import javax.swing.*;

// represents the generate a recipe option along with the functionality of the option
public class GUIrecipe {

    public RecipeHttpRequest recipeHttpRequest;

    // Requires: an item within the database
    // Effects: creates generate recipe frame and functionality
    public void generateARecipe() {
        recipeHttpRequest = new RecipeHttpRequest();
        JFrame frame6 = new JFrame();
        frame6.setSize(500, 1000);
        frame6.setLayout(null);
        frame6.setVisible(true);
        JButton createRecipe = new JButton("Generate A Recipe");
        createRecipe.setBounds(142, 250, 200, 30);
        JTextField inputItem = new JTextField();
        inputItem.setBounds(160, 200, 170, 40);
        frame6.add(createRecipe);
        frame6.add(inputItem);
        createRecipe.addActionListener(e -> {
            String food = inputItem.getText();
            try {
                String foodItem = recipeHttpRequest.getRecipes(food);
                recipeFrame(foodItem);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    // Effects: creates the recipe frame
    public void recipeFrame(String s) {
        JFrame frame5 = new JFrame();
        frame5.setSize(1200, 1000);
        frame5.setLayout(null);
        frame5.setVisible(true);
        final JLabel label = new JLabel(s);
        frame5.add(label);
        label.setBounds(100, 200, 1000, 300);
    }
}

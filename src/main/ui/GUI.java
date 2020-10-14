package ui;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import javax.swing.*;
import model.MiniFridge;
import persistence.Reader;
import persistence.Writer;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import static org.omg.CORBA.ORB.init;

// GUI class that represents the opening frame
public class GUI extends JFrame {
    public static final String FRIDGE = "./data/fridge.txt";
    static MiniFridge fridge;
    public ImageIcon icon;
    public JFrame frame = new JFrame();
    public JFrame opener = new JFrame();
    public GUIadd guIadd;
    public GUIcheck guiCheck;
    public GUInutrition guiNutrition;
    public GUIrecipe guiRecipe;
    public GUIremove guiRemove;
    public GUIview guiView;

    // Effects: creates a new GUI
    public GUI() {
        fridge = new MiniFridge();
        guIadd = new GUIadd();
        guiCheck = new GUIcheck();
        guiNutrition = new GUInutrition();
        guiRecipe = new GUIrecipe();
        guiRemove = new GUIremove();
        guiView = new GUIview();
        loadFridge();
        imagePanel();
        saveFridge();
    }

    //Effects: sets the size of the opening panel
    public void openerSize() {
        opener.setSize(450, 500);
        opener.setLayout(new FlowLayout());
        opener.setVisible(true);
    }

    // Effects: creates the opening panel
    public void imagePanel() {
        openerSize();
        try {
            URL url = new URL("https://images.assetsdelivery.com/compings_v2/arybickii/arybickii1912/arybickii191200050.jpg");
            BufferedImage img = ImageIO.read(url);
            icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            label.setBounds(0, 0, 400, 1000);
            label.setVisible(true);
            label.setLayout(new FlowLayout());
            JButton open = new JButton("Open Fridge");
            open.setBounds(200, 400, 150, 100);
            open.setVisible(true);
            label.add(open);
            opener.add(label);
            opener.pack();
            open.addActionListener(e ->
                    createDisplay());
            opener.setVisible(true);
            label.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Effects: creates the display menu with all the options
    public void createDisplay() {
        createAddButton();
        createViewButton();
        createRemoveButton();
        createCheckButton();
        createNutritionButton();
        createRecipeButton();
        createSaveButton();
        createQuitButton();
        frame.setSize(500, 1000);
        frame.setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Effects: creates the save option in the menu
    public void createSaveButton() {
        JButton a = new JButton("Save Fridge");
        a.setBounds(160, 700, 170, 40);
        frame.add(a);
        a.addActionListener(e -> {
            saveFridge();
            JFrame saved = new JFrame();
            saved.setSize(500, 1000);
            saved.setLayout(null);
            saved.setVisible(true);
            JLabel status = new JLabel("Saved!");
            status.setBounds(200, 200, 200, 200);
            saved.add(status);
        });
    }

    // Effects: creates the add option in the menu
    //https://www.javatpoint.com/java-swing
    public void createAddButton() {
        JButton a = new JButton("Add an item");
        a.setBounds(160, 100, 170, 40);
        frame.add(a);
        a.addActionListener(e -> {
            guIadd.addFunctionality();
            saveFridge();
        });
    }

    // Effects: creates the view button in the menu
    public void createViewButton() {
        JButton v = new JButton("View the items");
        v.setBounds(160, 200, 170, 40);
        frame.add(v);
        v.addActionListener(e -> guiView.createView());
    }

    // Effects: creates the remove button in the menu
    public void createRemoveButton() {
        JButton remove = new JButton("Remove an item");
        remove.setBounds(160, 300, 170, 40);
        frame.add(remove);
        remove.addActionListener(e -> {
            guiRemove.newRemoveItem();
            saveFridge();
        });
        saveFridge();
    }

    // Effects: creates the check button in the check frame
    public void createCheckButton() {
        JButton c = new JButton("Check if the fridge contains an item");
        c.setBounds(95, 400, 300, 40);
        frame.add(c);
        c.addActionListener(e ->
                guiCheck.createChecker()
        );
    }

    // Effects: creates the button the check the nutrition
    public void createNutritionButton() {
        JButton n = new JButton("Check the nutritional facts on an item");
        n.setBounds(95, 500, 320, 40);
        frame.add(n);
        n.addActionListener(e ->
                guiNutrition.createNutrition());
    }

    // Effects: creates the recipe button
    public void createRecipeButton() {
        JButton re = new JButton("Input an item for a recipe");
        re.setBounds(120, 600, 250, 40);
        frame.add(re);
        re.addActionListener(e ->
                guiRecipe.generateARecipe());
    }

    // Effects: creates the quit button in the frame
    //https://stackoverflow.com/questions/8632705/how-to-close-a-gui-when-i-push-a-jbutton
    public void createQuitButton() {
        JButton q = new JButton("Close fridge");
        q.setBounds(160, 800, 170, 40);
        frame.add(q);
        q.addActionListener(e -> System.exit(0));
    }

    // Effects: loads the fridge
    private void loadFridge() {
        try {
            MiniFridge oldFridge = Reader.readFridge(new File(FRIDGE));
            fridge = oldFridge;
        } catch (IOException e) {
            init();
        }
    }

    // Effects: saves the fridge
    public void saveFridge() {
        try {
            Writer writer = new Writer(new File(FRIDGE));
            writer.write(fridge);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to " + FRIDGE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}

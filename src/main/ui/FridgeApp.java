package ui;

import model.Item;
import model.MiniFridge;
import persistence.Reader;
import persistence.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static org.omg.CORBA.ORB.init;

// App that runs the console of the Minifridge app
public class FridgeApp {
    public static final String FRIDGE = "./data/fridge.txt";
    public NutritionHttpRequest nutritionHttpRequest;
    public RecipeHttpRequest recipeHttpRequest;
    static MiniFridge fridge;
    private final Scanner input;
    double amount;
    String expiryDate;
    Object valueExpiry;
    private Object value;


    // EFFECTS: runs the fridge application
    public FridgeApp() {
        input = new Scanner(System.in);
        nutritionHttpRequest = new NutritionHttpRequest();
        recipeHttpRequest = new RecipeHttpRequest();
        fridge = new MiniFridge();
        loadFridge();
        runFridge();
        saveFridge();
        double amount;
    }

    //EFFECTS: runs the fridge
    private void runFridge() {
        boolean keepRunning = true;
        while (keepRunning) {
            options();

            int option = input.nextInt();

            if (option == 1) {
                addItem();
            } else if (option == 2) {
                runNutrition();
            } else if (option == 3) {
                removeItem();
            } else if (option == 4) {
                checkItem();
            } else if (option == 5) {
                runRecipes();
            } else if (option == 6) {
                keepRunning = false;
            } else if (option == 7){
                itemExpired();
            }
        }
    }

    //TODO: for loop to check every expiry date on each item in fridge
    public void itemExpired(){
        String currentDate = LocalDate.now().toString();

        for (Map.Entry mapElement : fridge.getFridge().entrySet()){

            Item valueExpiry = (Item) mapElement.getValue();
            String itemExpiryDate = valueExpiry.getExpiryDate();
            if (itemExpiryDate == currentDate){
                runExpired(mapElement);
            }
        }
    }


    public void runExpired(Map.Entry mapElement){
        try{
            ExpiredHttpRequest(mapElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //EFFECTS: adds an item to your fridge
    public void addItem() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the name of your item");
        String foodName = in.nextLine();
        System.out.println("Please enter the expiry date in the form yyyy-MM-dd");
        expiryDate = in.nextLine();
        //Calendar calendar = Calendar.getInstance();
        //https://stackoverflow.com/questions/12575990/calendar-date-to-yyyy-mm-dd-format-in-java
        //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        //Item item = new Item(foodName, format1.format(calendar.getTime()));
        Item item = new Item(foodName,expiryDate);
        if (!fridge.containsItem(foodName)) {
            fridge.addFoodItem(item);
            saveFridge();
            System.out.println("Item saved to" + FRIDGE);
        } else {
            saveFridge();
        }
    }

    public void runRecipes() {
        System.out.println("Please enter the name of the item you would like a recipe for");
        Scanner foodName = new Scanner(System.in);
        String food = foodName.nextLine();
        try {
            recipeHttpRequest.getRecipes(food);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runNutrition() {
        System.out.println("Please enter the name of the item you would like nutritional information on.");
        Scanner input = new Scanner(System.in);
        String item = input.nextLine();
        Scanner number = new Scanner(System.in);
        amount = number.nextDouble();
        try {
            nutritionHttpRequest.getNutrition(amount + item);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //EFFECTS: removes an item from your fridge
    public void removeItem() {
        Scanner removeInput = new Scanner(System.in);
        System.out.println("Please type in the name of the item you would like to remove.");
        String name = removeInput.nextLine();
        if (fridge.containsItem(name)) {
            fridge.removeFood(name);
            System.out.println("Item successfully removed.");
        } else {
            System.out.println("Item was not removed as it is not in your fridge.");
        }
        saveFridge();
    }

    //EFFECTS: checks whether an item is in the fridge
    public static void checkItem() {
        Scanner checkInput = new Scanner(System.in);
        System.out.println("Which item would you like to check?");
        String checkItem = checkInput.nextLine();

        if (fridge.containsItem(checkItem)) {
            System.out.println("This item is already in your fridge.");
        } else {
            System.out.println("This item is not in your fridge.");
        }
    }

    //TellerApp code
    //EFFECTS: saves the state of te fridge to FRIDGE
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

     // TellerApp Code
     //MODIFIES: this
     //EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
     //otherwise initializes accounts with default values
    private void loadFridge() {
        try {
            MiniFridge oldFridge = Reader.readFridge(new File(FRIDGE));
            fridge = oldFridge;
        } catch (IOException e) {
            init();
        }
    }

    //EFFECTS: lists the options for a user to choose from
    private void options() {
        System.out.println("What would you like to do?");
        System.out.println("1.Store an item in the fridge");
        System.out.println("2.Get nutritional facts about the item");
        System.out.println("3.Remove an item from your fridge");
        System.out.println("4.Check if the fridge contains a food item already");
        System.out.println("5.Input an ingredient to find a recipe");
        System.out.println("6.Quit");
        System.out.println("7.Run Expiry");
    }
}

package persistence;

import model.Item;
import model.MiniFridge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TellerApp Code

public class Reader {

    public static final String DELIMITER = ",";
    public MiniFridge fridge;

    // EFFECTS: returns the fridge parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static MiniFridge readFridge(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns the fridge parsed from list of strings
    // where each string contains data for an item
    private static MiniFridge parseContent(List<String> fileContent) {
        MiniFridge fridge = new MiniFridge();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            fridge.addFoodItem(parseItems(lineComponents));

        }
        return fridge;
    }

    // EFFECTS: returns an item constructed from components
    private static Item parseItems(List<String> components) {
        Item item = new Item(components.get(0),components.get(1));
        return item;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

}


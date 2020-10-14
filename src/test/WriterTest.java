import model.Item;
import model.MiniFridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class WriterTest {
    private static final String FRIDGE = "./data/testFridge.txt";
    private Writer testWriter;
    private MiniFridge fridge;
    private Item apple;

    //TellerApp Tests
    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(FRIDGE));
        apple = new Item("Apple", "2020-07-12");
        fridge = new MiniFridge();
        fridge.addFoodItem(apple);
    }

    @Test
    void testWriteFridge() {
        testWriter.write(fridge);
        testWriter.close();

        try {
            MiniFridge oldFridge = Reader.readFridge(new File(FRIDGE));
            fridge = oldFridge;
            assertEquals(fridge,oldFridge);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}


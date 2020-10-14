import model.Item;
import model.MiniFridge;
import org.junit.jupiter.api.Test;
import persistence.Reader;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {

    //TellerApp Tests

    @Test
    void testReader() {
        Reader r = new Reader();
    }

    @Test
    void testIOException() {
        try {
            Reader.readFridge(new File("./path/does/not/exist/testFridge.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}

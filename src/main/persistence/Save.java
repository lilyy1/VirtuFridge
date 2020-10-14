package persistence;

import java.io.PrintWriter;

//TellerApp code

public interface Save {
    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printWriter
    void save(PrintWriter printWriter);
}

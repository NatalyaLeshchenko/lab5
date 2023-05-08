import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * This class implements communication between classes for the correct operation of the team
 */
public class Main {
    /**
     * This method implements communication between classes for the correct operation of the team
     */
    public static void main(String[] args) throws IOException {
        Map<Long, Flat> map = new LinkedHashMap<>();
        File file = new File();
        String file_name;
        if (args.length > 0) {
            file_name = args[0];
        } else {
            System.out.println("File name has been scanned from environment variable TEMP");
            file_name = System.getenv("TEMP") + "\\may.csv";
        }
        while (true) {
            try {
                file.fileReader(file_name, map);
                break;
            } catch (IOException e) {
                BufferedWriter out = new BufferedWriter(new FileWriter(file_name));
                out.close();
                break;
            }
        }
        String menu;
        do {
            menu = Parser.readString();
        } while (Switch.choice(menu, file_name, map) != 0);
    }

}
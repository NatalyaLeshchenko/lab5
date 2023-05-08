import java.io.*;
import java.util.Map;

/**
 * This class implements working with a file: reading, writing, executing commands from a file
 */
public class File {
    /**
     * This method reads from a file
     */
    public void fileReader(String file_name, Map<Long, Flat> map) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file_name));
        String line;
        while ((line = reader.readLine()) != null) {
            int iend = line.indexOf("~");
            String a;
            long b;
            if (iend != -1) {
                a = line.substring(0, iend);
                line = line.substring(iend + 1);
                try {
                    b = Long.parseLong(a);
                } catch (NumberFormatException e) {
                    return;
                }
            } else return;
            Flat flat = new Flat();
            if (flat.stringToFlat(line) == 0) return;
            map.put(b, flat);
        }

        reader.close();
    }

    /**
     * This method writes to a file
     */
    public void fileWriter(String file_name, Map<Long, Flat> map) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file_name));//"C:\\Users\\user\\Desktop\\fur.csv"
        for (Map.Entry<Long, Flat> entry : map.entrySet()) {
            out.write(entry.getKey() + "~");
            out.write(entry.getValue().flatToString() + '\n');
        }
        out.close();

    }

    /**
     * This method executes commands from a file
     */
    public static void executeScript(String menu, String file_name, Map<Long, Flat> map) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(menu));
            String line;
            while ((line = reader.readLine()) != null)
                if ((Switch.choice(line, file_name, map)) == 0) return;
            reader.close();


        } catch (IOException e) {
            System.out.println("File has not been founded");
        }
    }


}


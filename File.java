import java.io.*;
import java.util.*;

public class File {
    public int FileReader (String file_name, Map<Long, Flat> map) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file_name));
        String line;
        while ((line = reader.readLine()) != null) {
            Flat flat =new Flat();
            if (flat.StringToFlat(line)==0)
                return  0;
            map.put(flat.getID(), flat);
        }

        reader.close();
return 1;
    }
    public void FileWriter (String file_name, Map<Long, Flat> map) throws IOException {
        Flat flat = new Flat();
        BufferedWriter out
                = new BufferedWriter(new FileWriter(file_name));//"C:\\Users\\user\\Desktop\\fur.csv"
        for(Map.Entry <Long, Flat> entry: map.entrySet()) {
            out.write(entry.getValue().FlatToString()+'\n');

        }
        out.close();


    }
}


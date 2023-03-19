import java.io.*;
import java.util.*;

public class File {
    public void FileReader (String file_name, Map map) throws IOException {
        BufferedReader in
                = new BufferedReader(new FileReader(file_name));//"C:\\Users\\user\\Desktop\\fur.csv"


        System.out.println("");
        System.out.println();

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


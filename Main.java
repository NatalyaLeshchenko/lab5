import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Map<Long, Flat> map = new LinkedHashMap();
        File file = new File();
        String file_name="C:\\Users\\Natalya\\Desktop\\fur.csv";
        while(true) {
            try{
                file.FileReader(file_name, map);
                break;
            }
            catch (Exception e){
            break;
            }
        }
        int menu;
        do {
            System.out.println("\n1. add\n2. show\n3. write file\n0. exit");
            menu = Parser.readIntValue();
            switch (menu) {
                case 1:
                    Flat flat=new Flat();
                    flat.SetFlat();
                    map.put(flat.getID(), flat);
                    break;
                case 2:
                    for (Map.Entry<Long, Flat> entry : map.entrySet()) {
                        // get key
                        Flat flat1;
                        Long key = entry.getKey();
                        // get value
                        flat1 = entry.getValue();
                        flat1.showflat();
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    file.FileWriter(file_name, map);
                    break;
            }
        }
        while (menu != 0);



    }


}
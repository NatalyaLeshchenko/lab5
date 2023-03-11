import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
Map <Long, Flat> map = new LinkedHashMap();
Flat flat = new Flat();

int menu;
do {
    System.out.println("\n1. add data\n2. show data\n0. exit");
    menu = Parser.readIntValue();
    switch (menu) {
        case 1:
        flat.SetFlat();
        map.put(flat.getID(), flat); /возможно потеря данных в классе Flat
        break;
        case 2:
            for(Map.Entry<Long, Flat> entry: map.entrySet()) {
                // get key
                Long key = entry.getKey();
                // get value
                 flat = entry.getValue(); /возможно потеря данных в классе Flat
                 flat.showflat();
            }
            break;
    }
   }
while(menu!=0);
    /*   BufferedReader in
                = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\fur.csv"));
        String a;
                do
                {
                    a= in.readLine();
                    //обработать записать в хеш мап
                    System.out.println(a);
                }
                while(a!=null);
        System.out.println("");
        System.out.println();*/

    }

}

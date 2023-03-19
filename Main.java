import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/*
0. добавление осущевстляется в SetFlat() ЕЕ КОНЦЕ там вписать вроде put че то там загугли наш объект ключ пусть будет id
1. во flat написать метод show выводящий все поля flat
 2. написать какой то метод в классе Hashmap? который перебирает все поля хешмэпа и реализует пункт 1 по ввыводу
  то есть он перебирает и возвращает значение( какой то flat из таблицы мы его присваеваем объекту flat
  и выполняем метод show из 1.  дополнительно предусмотреть шапку таблицы это потом когда все будет работать
  и выполнишь отладку через main
  3. отладка написав 0.  1. и 2. без шапки таблицы надо протестить
  это делается просто создаешь объект flat в main и вызываешь 2 раза setFLAT */

public class Main {
    public static void main(String[] args) throws IOException {
        Map <Long, Flat> map = new LinkedHashMap();
        Flat flat = new Flat();

        int menu;
        do {
            System.out.println("\n1. add data\n2. show data\n3. write file\n0. exit");
            menu = Parser.readIntValue();
            switch (menu) {
                case 1:
                    flat.SetFlat();
                    map.put(flat.getID(), flat);
                    break;
                case 2:
                    for(Map.Entry<Long, Flat> entry: map.entrySet()) {
                        // get key
                        Long key = entry.getKey();
                        // get value
                        flat = entry.getValue();
                        flat.showflat();
                    }
                    break;
                case 3:
                    File file = new File();
                    file.FileWriter("C:\\Users\\user\\Desktop\\fur.csv", map );
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
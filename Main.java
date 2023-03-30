import java.io.IOException;
import java.util.*;

/** This class implements communication between classes for the correct operation of the team*/
public class Main {
    /** This method implements communication between classes for the correct operation of the team*/
    public static void main(String[] args) throws IOException {
        Map<Long, Flat> map = new LinkedHashMap<>();
        File file = new File();
        String file_name;
        if (args.length>0)
            file_name = args[0];
        else {
            System.out.println("Please, enter file name");
            file_name=Parser.readString();
        }
        while(true) {
            try{
                file.fileReader(file_name, map);
                break;
            }
            catch (Exception e){
                System.out.println("Wrong file or file has not been founded");
                System.out.println("New file has been created");
            break;
            }
        }
        String menu;
        do {
            menu = Parser.readString();
        }
        while (Switch.choice(menu,file_name,map)!=0);
    }


}
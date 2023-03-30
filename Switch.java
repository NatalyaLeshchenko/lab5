import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/** This class implements a hidden menu*/
public class Switch {
    /** This method implements a hidden menu*/
    public static int choice(String menu, String file_name, Map<Long,Flat> map) throws IOException {
        switch (menu) {
            case "help" -> System.out.println("Choose the action:\n1. info\n2. insert\n3. show\n4. save\n5. update\n6. remove\n7. exit\n8. clear\n9. remove_greater\n10. remove_greater_key\n11. remove_lower_key\n12. min_by_coordinates\n13. count_by_balcony\n14. filter_number_of_rooms\n15. execute_script");
            case "info" -> {
                System.out.println("The number of elements in collection: ");
                System.out.print(map.size());
                System.out.println("The type of collection: LinkedHashMap");
                Iterator<Long> it = map.keySet().iterator();
                Long key= 0L;
                while (it.hasNext()) {
                        key = it.next();
                }
                if(key!=0)
                    System.out.println(map.get(key).getCreateData());
                else {
                    System.out.println("Collection is empty");
                }
            }
            case "insert" -> {
                Flat flat = new Flat();
                flat.setFlat();
                map.put(flat.getID(), flat);
            }
            case "show" -> {
                for (Map.Entry<Long, Flat> entry : map.entrySet()) {
                    Flat flat1;
                    flat1 = entry.getValue();
                    flat1.showFlat();
                    System.out.println("\n");
                }
            }
            case "save" -> {File file=new File(); file.fileWriter(file_name, map);}
            case "update" -> Research.updateID(map);
            case "remove" -> Research.removeID(map);
            case "exit" -> {
                return 0;
            }
            case "clear" -> Research.clear(map);
            case "remove_greater" -> Research.removeGreater(map);
            case "remove_greater_key" -> Research.removeGreaterKey(map);
            case "remove_lower_key" -> Research.removeLowerKey(map);
            case "min_by_coordinates" -> Research.minCoordinates(map);
            case "count_by_balcony" -> Research.countByBalcony(map);
            case "filter_number_of_rooms" -> Research.filterNumberOfRooms(map);
            case "execute_script" -> {
                File.executeScript(file_name, map);
                return 0;}
            default -> System.out.println("Command has not been founded");

        }
        return 1;
    }
}

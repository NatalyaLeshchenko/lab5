
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * This class implements a hidden menu
 */
public class Switch {
    /**
     * This method implements a hidden menu
     */
    public static int choice(String menu, String file_name, Map<Long, Flat> map) throws IOException {
        menu = menu.trim();
        int iend = menu.indexOf(" ");
        String a;
        long b = 0;
        if (iend != -1) {
            a = menu.substring(0, iend);
            menu = menu.substring(iend);
            menu = menu.trim();
            try {
                b = Long.parseLong(menu);
            } catch (NumberFormatException e) {
                if (!a.equals("execute_script"))
                    return 1;
            }
        } else
            a = menu;
        switch (a) {
            case "help" -> {
                if (iend != -1)
                    break;
                System.out.println("Choose the action:\n1. info\n2. insert_{key}\n3. show\n4. save\n5. update_{id}\n6. remove_{key}\n7. exit\n8. clear\n9. remove_greater\n10. remove_greater_key\n11. remove_lower_key\n12. min_by_coordinates\n13. count_by_balcony\n14. filter_number_of_rooms\n15. execute_script");
            }
            case "info" -> {
                if (iend != -1)
                    break;
                System.out.println("The number of elements in collection: ");
                System.out.print(map.size());
                System.out.println("The type of collection: LinkedHashMap");
                Iterator<Long> it = map.keySet().iterator();
                Long key = 0L;
                while (it.hasNext()) {
                    key = it.next();
                }
                if (key != 0)
                    System.out.println(map.get(key).getCreateData());
                else {
                    System.out.println("Collection is empty");
                }
            }
            case "insert" -> {
                if (iend == -1)
                    break;
                Flat flat = new Flat();
                flat.setFlat();
                map.put(b, flat);
            }
            case "show" -> {
                if (iend != -1)
                    break;
                for (Map.Entry<Long, Flat> entry : map.entrySet()) {
                    Flat flat1;
                    System.out.print("key field:" + entry.getKey() + "\n");
                    flat1 = entry.getValue();
                    flat1.showFlat();
                    System.out.println();
                }
            }
            case "save" -> {
                if (iend != -1)
                    break;
                File file = new File();
                file.fileWriter(file_name, map);
            }
            case "update" -> {
                if (iend == -1)
                    break;
                Research.updateID(b, map);
            }
            case "remove" -> {
                if (iend == -1)
                    break;
                Research.removeKey(b, map);
            }
            case "exit" -> {
                if (iend != -1)
                    break;
                return 0;
            }
            case "clear" -> {
                if (iend != -1)
                    break;
                Research.clear(map);
            }
            case "remove_greater" -> {
                if (iend == -1)
                    break;
                int b1;
                try {
                    b1 = Integer.parseInt(menu);
                    Research.removeGreater(b1, map);
                } catch (NumberFormatException e) {
                    System.out.println("Bad symbol after command");
                }
            }
            case "remove_greater_key" -> {
                if (iend == -1)
                    break;
                Research.removeGreaterKey(b, map);
            }
            case "remove_lower_key" -> {
                if (iend == -1)
                    break;
                Research.removeLowerKey(b, map);
            }
            case "min_by_coordinates" -> {
                if (iend != -1)
                    break;
                Research.minCoordinates(map);
            }
            case "count_by_balcony" -> {//bool
                if (iend == -1)
                    break;
                boolean b2;
                b = Integer.parseInt(menu);
                b2 = b == 1;
                System.out.println((b = Research.countByBalcony(b2, map)) > 0 ? b : "There are no values");
            }
            case "filter_number_of_rooms" -> {//int
                if (iend == -1)
                    break;
                int b1;
                try {
                    b1 = Integer.parseInt(menu);
                } catch (NumberFormatException e) {
                    return 1;
                }
                Research.filterNumberOfRooms(b1, map);
            }
            case "execute_script" -> {
                if (iend == -1)
                    break;
                File.executeScript(menu, file_name, map);
                return 0;
            }
            default -> System.out.println("Command has not been founded");

        }
        return 1;
    }
}

import java.lang.reflect.Field;
import java.util.Scanner;
/** A class for storing the parser to avoid code repetition */
public class id {

    public static void main(String[] args) throws Exception {
        Flat flat = new Flat();
        Field coordinates = flat.getClass().getDeclaredField("coordinates");
        coordinates.setAccessible(true);
        System.out.println(coordinates.get(flat));
        Field transport = flat.getClass().getDeclaredField("transport");
        transport.setAccessible(true);
        System.out.println(transport.get(flat));
        Field house = flat.getClass().getDeclaredField("house");
        house.setAccessible(true);
        System.out.println(house.get(flat));
    }
}

class Parser {

    public static int readIntValue() {
        int i ;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {
                s = scanner.nextLine();
                s = s.trim();
                i = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.println("Please, re-enter");
            }
        }
        return i;
    }

    public static long readLongValue() {
        long i ;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {

                s = scanner.nextLine();
                s = s.trim();
                i = Long.parseLong(s);
                break;
            } catch (Exception e) {
                System.out.println("Please, re-enter");
            }
        }
        return i;
    }
    public static String readStringHouse() {
        Scanner scanner = new Scanner(System.in);
        String s;
                s = scanner.nextLine();
                s = s.trim();
        return s;
    }
    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {

                s = scanner.nextLine();
                s = s.trim();
                int m = 0;
                while (s.charAt(m) != '\0') {
                    if (s.charAt(m) != ' ' && s.charAt(m) != '\n')
                        break;
                    m++;
                }
                if (s.charAt(m) == '\0')
                    Integer.parseInt("fff");
                break;
            } catch (Exception e) {
                System.out.println("Please, re-enter");
            }
        }
        return s;
    }

    public static boolean readBooleanValue() {
        boolean i;
        Scanner scanner = new Scanner(System.in);
        String s;
        int g;
        while (true) {
            try {

                s = scanner.nextLine();
                s = s.trim();
                g = Integer.parseInt(s);
                if (g == 1)
                    i = true;
                else if (g == 0)
                    i = false;
                else {
                    i = Boolean.parseBoolean(s);
                }
                break;
            } catch (Exception e) {
                System.out.println("Please, re-enter");
            }
        }
        return i;
    }


}


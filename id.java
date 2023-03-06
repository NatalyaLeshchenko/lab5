import java.lang.reflect.Field;
import java.util.Scanner;

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

    public static <FormatException extends Throwable> int readIntValue() {
        int i=0 ;
           Scanner scanner = new Scanner(System.in);
           String s;
           while (true) {
           try {

               s = scanner.nextLine();
               s = s.trim();
               i = Integer.parseInt(s);
               break;
           }

               catch (Exception e) {
               System.out.println("Please, re-enter");
       } }
        return i;
    }

    public static <FormatException extends Throwable> long readLongvalue() {
        long i=0 ;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {

                s = scanner.nextLine();
                s = s.trim();
                i = Long.parseLong(s);
                break;
            }

            catch (Exception e) {
                System.out.println("Please, re-enter");
            } }
        return i;
    }

    public static <FormatException extends Throwable> String readString() {
        String i = "" ;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {

                s = scanner.nextLine();
                s = s.trim();
                break;
            }

            catch (Exception e) {
                System.out.println("Please, re-enter");
            } }
        return s;
    }

}

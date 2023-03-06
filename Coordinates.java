import java.util.Scanner;

public class Coordinates {
    public static <FormatException extends Throwable> double SetX() {
        double i ;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {

                s = scanner.nextLine();
                s = s.trim();
                i = Double.parseDouble(s);
                break;
            }

            catch (Exception e) {
                System.out.println("Please, re-enter");
            } }
        return i;
    }
    public void SetY()
    {
        System.out.print("\ny=");
        y= Parser.readIntValue();
    }
    private double x;
    private int y; //Значение поля должно быть больше -695
}

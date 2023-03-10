import java.sql.SQLOutput;
import java.util.Scanner;

public class Coordinates{
    public Coordinates(){

    }
    public Coordinates(Coordinates other){
        x = other.x;
        y = other.y;
    }
    public <FormatException extends Throwable> void SetX() {

        System.out.print("Please, enter the X house's coordinate: ");
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            try {
                s = scanner.nextLine();
                s = s.trim();
                x = Double.parseDouble(s);
                break;
            }

            catch (Exception e) {
                System.out.println("Please, re-enter");
            } }

    }
    public void SetY() {
        System.out.print("Please, enter the Y house's coordinate: ");
        y= Parser.readIntValue();
    }
    private double x;
    private int y; //Значение поля должно быть больше -695
    public void showcoordinates(){
        System.out.printf("%.2f %d ",x, y);
    }
}

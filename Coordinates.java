import java.util.Scanner;

public class Coordinates{
    public Coordinates(){
    }
    public Coordinates(Coordinates other){
        x = other.x;
        y = other.y;
    }
    public <FormatException extends Throwable> void setX() {

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
        do {
            System.out.print("Please, enter the Y house's coordinate: ");
            y = Parser.readIntValue();
        } while (y <= -695);
    }
    public void ToStringX(String n)
    {
        x=Double.parseDouble(n);
    }
    public void ToStringY(String n)
    {
        y= Integer.parseInt(n);
    }
    private double x;
    private int y; //Значение поля должно быть больше -695
    public void showcoordinates(){
        System.out.printf("%.2f %d ",x, y);
    }
    public String CoordinatesToString(){
        return x+"~"+y;
    }
}

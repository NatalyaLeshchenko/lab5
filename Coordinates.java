import java.util.Scanner;

public class Coordinates {
    public void Set_x()
    {
        System.out.print("Пожалуйста, введите координаты квартиры: \nx=");
        Scanner scanner = new Scanner(System.in);
        x= scanner.nextInt();
    }
    public void Set_y()
    {
        System.out.print("\ny=");
        Scanner scanner = new Scanner(System.in);
        y= scanner.nextInt();
    }
    private double x;
    private int y; //Значение поля должно быть больше -695
}

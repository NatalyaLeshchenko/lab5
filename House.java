import java.util.Scanner;

public class House {
    private String name; //Поле может быть null
    private long year; //Значение поля должно быть больше 0
    private int numberOfFloors; //Значение поля должно быть больше 0
    public void Set_name()
    {
        System.out.print("\nВведите название дома:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
    }
    public void Set_years()
    {
        System.out.print("\nВведите год создания дома:");
        Scanner scanner = new Scanner(System.in);
        year= scanner.nextInt();
    }
    public void Set_numberOfFloors()
    {
        System.out.print("\nВведите количество этажей:");
        Scanner scanner = new Scanner(System.in);
        numberOfFloors= scanner.nextInt();
    }
}

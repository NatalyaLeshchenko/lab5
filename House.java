import java.util.Scanner;

public class House {
    private String name; //Поле может быть null
    private long year; //Значение поля должно быть больше 0
    private int numberOfFloors; //Значение поля должно быть больше 0
    public void SetName()
    {
        System.out.print("\nВведите название дома:");
        name = Parser.readString();
    }
    public void SetYears()
    {
        System.out.print("\nВведите год создания дома:");
        year= Parser.readIntValue();
    }
    public void SetNumberOfFloors()
    {
        System.out.print("\nВведите количество этажей:");
        numberOfFloors= Parser.readIntValue();
    }
}

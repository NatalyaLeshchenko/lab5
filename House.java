import java.util.Scanner;

public class House {
    public  House(){

    }
    public House(House other){
        name = other.name;
        year = other.year;
        numberOfFloors = other.numberOfFloors;
    }
    private String name; //Поле может быть null
    private long year; //Значение поля должно быть больше 0
    private int numberOfFloors; //Значение поля должно быть больше 0
    public void ToStringName(String n)
    {
        name=n;
    }
    public void ToStringYear(String n)
    {
        year=Long.parseLong(n);
    }
    public void ToStringNumberOfFloors(String n)
    {
        numberOfFloors=Integer.parseInt(n);
    }
    public void SetName()
    {
        System.out.println("Please, enter the house's name. If there is no name, enter 'NULL' ");
        name = Parser.readString();
    }
    public void SetYears()
    {
        System.out.print("\nВведите год создания дома:");
        year= Parser.readLongvalue();
    }
    public void SetNumberOfFloors()
    {
        System.out.print("\nEnter the number of floors:");
        numberOfFloors= Parser.readIntValue();
    }
    public void showhouses(){
        System.out.printf("%s %d %d",name, year, numberOfFloors);
    }
    public  String HouseToString(){
        return name+"~"+year+"~"+numberOfFloors;
    }
}

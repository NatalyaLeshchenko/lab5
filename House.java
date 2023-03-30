/** A class for storing information about the house */
public class House {

    public  House(){

    }
    /** A method for setting information about the house */
    public House(House other){
        name = other.name;
        year = other.year;
        numberOfFloors = other.numberOfFloors;
    }
    private String name; //Поле может быть null
    private long year; //Значение поля должно быть больше 0
    private int numberOfFloors; //Значение поля должно быть больше 0
    /** This method assigns a string to a variable*/
    public void toStringName(String n)
    {
        name=n;
    }
    /** This method assigns a string to a variable*/
    public void toStringYear(String n)
    {
        year=Long.parseLong(n);
    }
    /** This method assigns a string to a variable*/
    public void toStringNumberOfFloors(String n)
    {
        numberOfFloors=Integer.parseInt(n);
    }
    /** This method sets the value of name*/
    public void setName()
    {
        System.out.println("Please, enter the house's name. If there is no name, enter 'NULL' ");
        name = Parser.readStringHouse();
        if(name.equals(""))
            name="null";
    }
    /** This method sets the value of year*/
    public void setYears()
    {
        System.out.print("\nPlease, enter the year of creation of the house:");
        year= Parser.readLongValue();
    }
    /** This method sets the value of number of floors*/
    public void setNumberOfFloors()
    {
        System.out.print("\nEnter the number of floors:");
        numberOfFloors= Parser.readIntValue();
    }
    /** This method outputs elements which are located in class House*/
    public void showHouses(){
        System.out.printf("%s %d %d",name, year, numberOfFloors);
    }
    /** This method converts house to type string*/
    public  String houseToString(){
        return name+"~"+year+"~"+numberOfFloors;
    }
    /** This method returns the number of floors*/
    public int getNumberOfFloors(){ return numberOfFloors;}
}

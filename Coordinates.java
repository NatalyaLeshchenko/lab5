import java.util.Scanner;
/** A class for storing information about the coordinates */
public class Coordinates{
    public Coordinates(){
    }
    /** This method sets the value of x*/
    public void setX() {

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
    /** This method sets the value of y*/
    public void setY() {
        do {
            System.out.print("Please, enter the Y house's coordinate: ");
            y = Parser.readIntValue();
        } while (y <= -695);
    }
    /** This method assigns a string to a variable*/
    public void toStringX(String n)
    {
        x=Double.parseDouble(n);
    }
    /** This method assigns a string to a variable*/
    public void toStringY(String n)
    {
        y= Integer.parseInt(n);
    }
    private double x;
    private int y; //Значение поля должно быть больше -695
    /** This method outputs elements which are located in class Coordinates*/
    public void showCoordinates(){
        System.out.printf("%.2f %d ",x, y);
    }
    /** This method converts the value of a variable to a string*/
    public String coordinatesToString(){
        return x+"~"+y;
    }
    /** This method returns the value of y*/
    public int getY(){return  y;}
}

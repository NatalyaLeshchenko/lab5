
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Flat {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates=new Coordinates(); //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private int numberOfRooms; //Поле не может быть null, Значение поля должно быть больше 0
    private int floor; //Значение поля должно быть больше 0
    private boolean balcony;
    private Transport transport; //Поле не может быть null
    private House house=new House(); //Поле не может быть null
    public Flat (Flat other){
        id = other.id;
        name = other.name;
        coordinates = other.coordinates;
        creationDate = other.creationDate;
        area = other.area;
        numberOfRooms = other.numberOfRooms;
        floor = other.floor;
        balcony = other.balcony;
        transport = other.transport;
        house = other.house;
    }
    Flat (){

    }
    public void SetFlat()
    {
        Scanner scanner = new Scanner(System.in);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        id = timestamp.getTime();
        System.out.print("Please, enter the apartment address: ");
        name = Parser.readString();
        coordinates.setX();
        coordinates.SetY();
        creationDate = LocalDateTime.now();
        System.out.print("Please, enter the area of the apartment: ");
        area = Parser.readLongvalue();
        System.out.print("Please, enter the number of rooms: ");
        numberOfRooms = Parser.readIntValue();
        System.out.print("Please, enter the apartment floor: ");
        floor = Parser.readIntValue();
        System.out.println("Please, check for a balcony (1- if there is a balcony in the flat, 0 - if there is no balcony)");
        balcony = Parser.readBooleanvalue();
        String o;
        boolean flag=true;
        System.out.print("Please, choose one of the variants for the transport description: NONE, LITTLE, NORMAL\n Your choice: ");
        do {
            o = scanner.nextLine();
            o = o.trim();
            if (o.equals("NONE")) {
                transport = transport.NONE;
                flag = false;
            } else if (o.equals("LITTLE")) {
                transport = transport.LITTLE;
                flag = false;
            } else if (o.equals("NORMAL")) {
                transport = transport.NORMAL;
                flag = false;
            } else System.out.print("\nRepeat enter: ");
        }
        while (flag);
        house.SetName();
        house.SetYears();
        house.SetNumberOfFloors();

    }
    public long getID(){
        return id;
    }
    public void showflat(){
        System.out.printf("%d %s ",id, name);
        coordinates.showcoordinates();
        System.out.println(creationDate);
        System.out.printf("%d %d %d %b %s ",area, numberOfRooms, floor, balcony, transport);
        house.showhouses();
    }
    public String FlatToString()
    {
        return String.valueOf(id)+"~"+name+"~"+coordinates.CoordinatesToString()+"~"+String.valueOf(area)+ "~"+numberOfRooms +"~" + String.valueOf(floor)+ "~" + String.valueOf(balcony)+"~"+transport+"~"+house.HouseToString()+"~";
    }
    static int  i =0 ; static int g;
    public  static String parserToString(String line){
        char s[] = line.toCharArray();
        g = i;
        int j;
        for (j=0; s[i] != '\0'; i++,j++) {
            if (s[i] == '~')
                break;
        }
        if (s[i] == '\0') {
            System.out.println("The mistake of enterance");
            return"~";
        }
        String n=new String(s,g,j);
        i++;
        return n;
    }
    boolean BadFile(String n)
    {
        if(n=="~")
            return true;
        else
            return false;
    }
    public int StringToFlat (String line){
        String n=parserToString(line);
        if(BadFile(n))
            return 0;
        id = Long.parseLong(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        name = n;
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        coordinates.ToStringX(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        coordinates.ToStringY(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        area = Long.parseLong(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        numberOfRooms = Integer.parseInt(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        floor = Integer.parseInt(n);
        n=parserToString(line);
        if(BadFile(n))
            return 0;
        balcony = Boolean.parseBoolean(n);
        n=parserToString(line);
        if(BadFile(n))
            return 0;
        if (n.equals("NONE")) {
            transport = transport.NONE;
        } else if (n.equals("LITTLE")) {
            transport = transport.LITTLE;
        } else if (n.equals("NORMAL")) {
            transport = transport.NORMAL;
        }
        n=parserToString(line);
        if(BadFile(n))
            return 0;
        house.ToStringName(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        house.ToStringYear(n);
         n=parserToString(line);
        if(BadFile(n))
            return 0;
        house.ToStringNumberOfFloors(n);
        i=0;
        g=0;
return 1;
    }
}


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * This class sets the values of variables
 */
public class Flat {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private int numberOfRooms; //Поле не может быть null, Значение поля должно быть больше 0
    private int floor; //Значение поля должно быть больше 0
    private boolean balcony;
    private Transport transport; //Поле не может быть null
    private House house = new House(); //Поле не может быть null

    public Flat(Flat other) {
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

    Flat() {

    }

    /**
     * This method sets the values of variables
     */
    public void setFlat() {
        Scanner scanner = new Scanner(System.in);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        id = timestamp.getTime();
        System.out.print("Please, enter the apartment address: ");
        name = Parser.readString();
        coordinates.setX();
        coordinates.setY();
        creationDate = LocalDateTime.now();
        System.out.print("Please, enter the area of the apartment: ");
        area = Parser.readLongValue();
        System.out.print("Please, enter the number of rooms: ");
        numberOfRooms = Parser.readIntValue();
        System.out.print("Please, enter the apartment floor: ");
        floor = Parser.readIntValue();
        System.out.println("Please, check for a balcony (1- if there is a balcony in the flat, 0 - if there is no balcony)");
        balcony = Parser.readBooleanValue();
        String o;
        boolean flag = true;
        System.out.print("Please, choose one of the variants for the transport description: NONE, LITTLE, NORMAL\n Your choice: ");
        do {
            o = scanner.nextLine();
            o = o.trim();
            switch (o) {
                case "NONE" -> {
                    transport = Transport.NONE;
                    flag = false;
                }
                case "LITTLE" -> {
                    transport = Transport.LITTLE;
                    flag = false;
                }
                case "NORMAL" -> {
                    transport = Transport.NORMAL;
                    flag = false;
                }
                default -> System.out.print("\nRepeat enter: ");
            }
        }
        while (flag);
        house.setName();
        house.setYears();
        house.setNumberOfFloors();

    }

    /**
     * This method returns the value of ID
     */
    public long getID() {
        return id;
    }

    /**
     * This method returns the presence of a balcony
     */
    public boolean getBalcony() {
        return balcony;
    }

    /**
     * This method outputs elements which are located in class Flat
     */
    public void showFlat() {
        System.out.printf("%d %s ", id, name);
        coordinates.showCoordinates();
        System.out.println(creationDate);
        System.out.printf("%d %d %d %b %s ", area, numberOfRooms, floor, balcony, transport);
        house.showHouses();
    }

    /**
     * This method converts the value of a variable to a string
     */
    public String flatToString() {
        return id + "~" + name + "~" + coordinates.coordinatesToString() + "~" + creationDate + "~" + area + "~" + numberOfRooms + "~" + floor + "~" + balcony + "~" + transport + "~" + house.houseToString() + "~";
    }

    /**
     * This method outputs number of rooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    static int i = 0;
    static int g;

    /**
     * This method converts the value of a variable to a string
     */
    public static String parserToString(String line) {
        char[] s = line.toCharArray();
        g = i;
        int j;
        for (j = 0; s[i] != '\0'; i++, j++) {
            if (s[i] == '~')
                break;
        }
        if (s[i] == '\0') {
            System.out.println("The mistake of entrance");
            return "~";
        }
        String n = new String(s, g, j);
        i++;
        return n;
    }

    boolean badFile(String n) {
        return n.equals("~");
    }

    /**
     * This method outputs data
     */
    public java.time.LocalDateTime getCreateData() {
        return creationDate;
    }

    /**
     * This method converts the string of a variable to type flat
     */
    public int stringToFlat(String line) {
        String n = parserToString(line);
        if (badFile(n))
            return 0;
        id = Long.parseLong(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        name = n;
        n = parserToString(line);
        if (badFile(n))
            return 0;
        coordinates.toStringX(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        coordinates.toStringY(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        creationDate = LocalDateTime.parse(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        area = Long.parseLong(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        numberOfRooms = Integer.parseInt(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        floor = Integer.parseInt(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        balcony = Boolean.parseBoolean(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        switch (n) {
            case "NONE" -> transport = Transport.NONE;
            case "LITTLE" -> transport = Transport.LITTLE;
            case "NORMAL" -> transport = Transport.NORMAL;
        }
        n = parserToString(line);
        if (badFile(n))
            return 0;
        house.toStringName(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        house.toStringYear(n);
        n = parserToString(line);
        if (badFile(n))
            return 0;
        house.toStringNumberOfFloors(n);
        i = 0;
        g = 0;
        return 1;
    }

    /**
     * This method sets ID
     */
    public void setID(long a) {
        id = a;

    }

    /**
     * This method outputs number of floors
     */
    public int getNumberOfFloors() {
        return house.getNumberOfFloors();
    }

    /**
     * This method returns the value of y
     */
    public int getY() {
        return coordinates.getY();
    }
}

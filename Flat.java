
import java.time.LocalDateTime;
import java.util.Scanner;

public class Flat {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private Integer numberOfRooms; //Поле не может быть null, Значение поля должно быть больше 0
    private int floor; //Значение поля должно быть больше 0
    private boolean balcony;
    private Transport transport; //Поле не может быть null
    private House house; //Поле не может быть null
    public void SetFlat()
    {
        Scanner scanner = new Scanner(System.in);
        i++;
        id =i;
        System.out.print("Пожалуйста, введите адрес квартиры: ");
        name = scanner.nextLine();
        coordinates.Set_x();
        coordinates.Set_y();
        creationDate = LocalDateTime.now();
        System.out.print("Пожалуйста, введите площадь квартиры: ");
        area = scanner.nextLong();
        System.out.print("Пожалуйста, введите количество комнат: ");
        numberOfRooms = scanner.nextInt();
        System.out.println("Пожалуйста, введите номер этажа: ");
        floor = scanner.nextInt();
        System.out.println("Пожалуйста, уточните наличие балкона (1- при наличии балкона, 0 - при его отсутствии");
        balcony = scanner.nextBoolean();
        String o;
        boolean flag=true;
        System.out.print("Выберите один из предложенных вариантов для описания транспорта: NONE, LITTLE, NORMAL\n Ваш выбор: ");
        do {
            o = scanner.nextLine();
            if (o.equals("NONE")) {
                transport = transport.NONE;
                flag = false;
            } else if (o.equals("LITTLE")) {
                transport = transport.LITTLE;
                flag = false;
            } else if (o.equals("NORMAL")) {
                transport = transport.NORMAL;
                flag = false;
            } else System.out.print("\nПовторите ввод: ");
        }
        while (flag);
        System.out.println("Введите имя дома. Если имени нет, введите 'NULL' ");
        house.Set_years();
        house.Set_name();
        house.Set_numberOfFloors();

    }

    static int i = 0;
}

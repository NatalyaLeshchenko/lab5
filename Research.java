import java.util.Iterator;
import java.util.Map;

/** This class implements queries to the storage structure*/
public class Research {
    /** This method updates the value of a collection item whose id is equal to the specified one*/
    public static void updateID(Map<Long, Flat> map) {
        System.out.println("Please, enter the ID number of element to update");
        long a;
        a = Parser.readLongValue();
        Flat flat;
        if ((flat = map.get(a)) == null)
            System.out.println("Element has not founded");
        else {
            flat.showFlat();
            flat.setFlat();
            flat.setID(a);
            map.put(a, flat);
        }
    }
    /** This method deletes an item from the collection by its key*/
public static void removeID(Map<Long, Flat> map){
            System.out.println("Please, enter the ID number of element to update");
            long a;
            a = Parser.readLongValue();
            if (map.remove(a) == null )
                System.out.println("Element has not founded"); else{
                System.out.println("Element has been successfully deleted");
        }}
    /** This method clears the collection*/
    public static void clear(Map<Long, Flat> map){
        map.clear();
        System.out.println("Collection has been cleaned");
        }
    /** This method removes all items from the collection that exceed the specified*/
        public static void removeGreater(Map<Long, Flat> map) {
            int a;
            System.out.println();
            a = Parser.readIntValue();
            map.keySet().removeIf(key -> map.get(key).getNumberOfFloors() > a);
        }
    /** This method removes from the collection all items whose keys are greater than the specified one*/
    public static void removeGreaterKey(Map<Long, Flat> map) {
        long a;
        System.out.println();
        a = Parser.readLongValue();
        map.keySet().removeIf(key -> map.get(key).getID() > a);
    }
    /** This method removes from the collection all items which keys are less than the specified one*/

    public static void removeLowerKey(Map<Long, Flat> map) {
        long a;
        System.out.println();
        a = Parser.readLongValue();
        map.keySet().removeIf(key -> map.get(key).getID() < a);
    }
    /** This method outputs object from the collection which coordinates field value is minimal*/
    public static void minCoordinates(Map<Long, Flat> map) {
        long y = -1;
        Iterator<Long> it = map.keySet().iterator();
        while (it.hasNext()) {
            if(y!=-1)
            {
                Long key = it.next();
            if (map.get(key).getY() <map.get(y).getY())
                y=key;
            }
            else
                y=it.next();
        }
        map.get(y).showFlat();
    }
    /** This method prints the number of elements which values of the balcony field are equal to the specified*/
    public static void countByBalcony(Map<Long, Flat> map) {
        boolean a;
        System.out.println("Please, check for a balcony (1- if there is a balcony in the flat, 0 - if there is no balcony)");
        a = Parser.readBooleanValue();
        for (Long key : map.keySet()) {

            if (map.get(key).getBalcony() == a) {
                System.out.println(" \n");
                map.get(key).showFlat();
            }
        }
        System.out.println("There are no values");


}
/** This method outputs elements which numberOfRooms field value are greater than the specified one*/
    public static void filterNumberOfRooms (Map<Long, Flat> map) {
        int a;
        System.out.println();
        a = Parser.readIntValue();
        for (Long key : map.keySet()) {

            if (map.get(key).getNumberOfRooms() > a) {
                System.out.println(" \n");
                map.get(key).showFlat();
            }
        }
        System.out.println("There are no values");


    }
}

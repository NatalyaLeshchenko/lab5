import java.util.Iterator;
import java.util.Map;


/**
 * This class implements queries to the storage structure
 */
public class Research {
    /**
     * This method updates the value of a collection item whose id is equal to the specified one
     */
    public static void updateID(long a, Map<Long, Flat> map) {
        int flag = 1;
        for (Map.Entry<Long, Flat> entry : map.entrySet()) {
            Flat flat;
            flat = entry.getValue();
            if (flat.getID() == a) {
                flat.showFlat();
                System.out.println();
                flat.setFlat();
                flat.setID(a);
                map.put(entry.getKey(), flat);
                flag = 0;
            }
        }
        if (flag == 1)
            System.out.println("Element has not been founded");
    }

    /**
     * This method deletes an item from the collection by its key
     */
    public static void removeKey(long a, Map<Long, Flat> map) {
        for (Map.Entry<Long, Flat> entry : map.entrySet()) {
            if (entry.getKey() == a) {
                map.remove(entry.getKey());
                System.out.println("Element has been successfully deleted");
            } else {
                System.out.println("Element has not been founded");
            }
        }
    }

    /**
     * This method clears the collection
     */
    public static void clear(Map<Long, Flat> map) {
        map.clear();
        System.out.println("Collection has been cleaned");
    }

    /**
     * This method removes all items from the collection that exceed the specified
     */
    public static void removeGreater(int a, Map<Long, Flat> map) {
        map.keySet().removeIf(key -> map.get(key).getNumberOfFloors() > a);
    }

    /**
     * This method removes from the collection all items whose keys are greater than the specified one
     */
    public static void removeGreaterKey(long a, Map<Long, Flat> map) {
        for (Map.Entry<Long, Flat> entry : map.entrySet()) {
            if (entry.getKey() > a)
                map.remove(entry.getKey());
        }
    }

    /**
     * This method removes from the collection all items which keys are less than the specified one
     */

    public static void removeLowerKey(long a, Map<Long, Flat> map) {
        for (Map.Entry<Long, Flat> entry : map.entrySet()) {
            if (entry.getKey() < a)
                map.remove(entry.getKey());
        }
    }

    /**
     * This method outputs object from the collection which coordinates field value is minimal
     */
    public static void minCoordinates(Map<Long, Flat> map) {
        long y = -1;
        Iterator<Long> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (y != -1) {
                Long key = it.next();
                if (map.get(key).getY() < map.get(y).getY()) y = key;
            } else y = it.next();
        }
        map.get(y).showFlat();
    }

    /**
     * This method prints the number of elements which values of the balcony field are equal to the specified
     */
    public static int countByBalcony(boolean a, Map<Long, Flat> map) {
        int count = 0;
        for (Long key : map.keySet()) {
            if (map.get(key).getBalcony() == a) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method outputs elements which numberOfRooms field value are greater than the specified one
     */
    public static void filterNumberOfRooms(int a, Map<Long, Flat> map) {
        for (Long key : map.keySet()) {

            if (map.get(key).getNumberOfRooms() > a) {
                System.out.println(" \n");
                map.get(key).showFlat();
            }
        }
        System.out.println("There are no values");


    }
}

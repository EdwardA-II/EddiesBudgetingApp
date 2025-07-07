import java.util.HashMap;
import java.util.Map;

/**
 * Creation Date: Sunday, 07-06-2025
 * Creation Time: 7:39 PM
 * A method for testing random things that you need to test when you dont feel like running the whole dang program.
 */

public class FreeSpace {

    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();

        mp.put("Eddie", 24);
        mp.put("Xavier", 26);
        mp.put("Alberto", 24);

        System.out.println(mp.values());
        System.out.println(mp.keySet());
        System.out.println(mp.entrySet());
    }

}




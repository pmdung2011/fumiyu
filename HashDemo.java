import java.util.HashMap;

public class HashDemo {

        public static void main(String [] args){
            // Create a HashMap object called capitalCities with String keys and String values
            HashMap capitalCities = new HashMap();

            capitalCities.put("England", "London");
            capitalCities.put("Germany", "Berlin");
            capitalCities.put("Norway", "Oslo");
            capitalCities.put("USA", "Washington DC");
            System.out.println(capitalCities);

            System.out.println(capitalCities.get("London"));
            capitalCities.remove("England");
            System.out.println(capitalCities.size());

            //Use the keySet() method if you only want the keys,
            // and use the values() method if you only want the values
            // Print keys
            for (Object i : capitalCities.keySet()) {
                System.out.println(i);
            }

        }


}

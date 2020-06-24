import java.util.*;

public class ArrayToSetDemo {
    public static void main(String[] args){
        String[] vowels = {"a","e","i","o","u"};
        //Method 1
        //Set<String> set = new HashSet<>(Arrays.asList(vowels));

        //Method 2
        Set<String> set = new HashSet<>();
        Collections.addAll(set, vowels);
        /*
         * Unlike List, Set is NOt backed by array,
         * so we can do structural modification without any issues.
         */
    }
}

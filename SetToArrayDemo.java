import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetToArrayDemo {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        String[] str = new String[set.size()];
        str = set.toArray(str);
        System.out.println(Arrays.toString(str));
    }
}

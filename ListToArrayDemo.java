import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArrayDemo {
    public static void main(String[] args){
        List<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("B");

        //convert list to array
        String[] lettersArr = new String[letters.size()];
        lettersArr = letters.toArray(lettersArr);
        System.out.println(Arrays.toString(lettersArr));
    }
}

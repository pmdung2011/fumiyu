import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToListDemo {

    public static void main (String[] args){
        String[] vowels = {"a","e","i","o","u"};
        List<String> vowelsList = Arrays.asList(vowels);
        System.out.println(vowelsList);

        //vowelsList.remove("e");
        //vowelsList.clear();
        /*
        * //using for loop to copy elements from array to list, safe for modification of list
		List<String> myList = new ArrayList<>();
		for(String s : vowels){
			myList.add(s);
		}*/
        List<String> myList = new ArrayList<>(Arrays.asList(vowels));
        System.out.println(myList);
        myList.clear();
        System.out.println(myList);





    }
}

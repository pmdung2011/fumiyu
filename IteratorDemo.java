import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args){
      /*The major difference between Iterator and ListIterator
       is that Iterator can only in forward direction whereas,
       the ListIterator can traverse  in both the forward as well as
       the backwards direction*/

        List<Integer> myList = new ArrayList<>();
        for (int i = 0;i < 10; i++){
            myList.add(i);
        }
        System.out.println("myList: "+ myList.toString());

        // at beginning ltr(cursor) will point to
        // index just before the first element -1
        ListIterator ltr = myList.listIterator();

        //checking the next element availability
        while(ltr.hasNext()){
            //moving cusor to the next element
            int i = (Integer)ltr.next();
            System.out.print("-> "+i +" ");//cusor moving

            //changing numbers to odd and
            //adding modified number again in
            //iterator
            if(i%2==0){
                i++;
                ltr.set("A"); //set before the next cusor.
                ltr.add(i);
            }
        }
        System.out.println();
        System.out.println("After:" +myList);


    }
}

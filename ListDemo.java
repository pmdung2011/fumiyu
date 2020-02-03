import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ListDemo {
    public static void main(String[] args){
        //For ArrayList
        /*
        * Here we are using a List
        *  as a type of variable to store an object of ArrayList class,
        * created using new() operator.
        * for passing ArrayList, LinkedList,Stack or Vector
        * Noi chung la su dung List a = new ArrayList, de pass vao dc stack, linkedlist cac thu,
        * vi neu su dung ArrayList ko thi ko pass vao dc
        * ArrayList la subtype of List interface*/
        List<Integer> al = new ArrayList<>(); //Safe-type declaration(include the specific type: String,...
        al.add(1);
        al.add(2);
        System.out.println("ArrayList: " + al.toString());

        //For LinkedList
        List<String> ll = new LinkedList<>();
        ll.add("A");
        ll.add("B");
        System.out.println("LinkedList: " + ll.toString());

        //For Stack
        List<Double> st = new Stack<>();
        st.add(1.2);
        st.add(2.2);
        System.out.println("Stack" + st.toString());
    }
}

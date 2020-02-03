import java.util.Stack;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDemo {
    public static void main(String [] args){
        //Declare a queue using LinkedList
        Queue q = new LinkedList();
        q.add(2);
        q.add("String");
        q.add(3.2);
        System.out.print("The current Queue: " +q);
        System.out.println("Peek the first item : " +q.peek());
        System.out.println("Let see the pop: " +q.remove());
        System.out.println("Let see: " +q.element());
    }
}

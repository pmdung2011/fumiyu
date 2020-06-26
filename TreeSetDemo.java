import com.sun.source.tree.Tree;
import org.w3c.dom.ls.LSOutput;

import java.util.SortedSet;
import java.util.TreeSet;


public class TreeSetDemo {
    public static void main(String[] args){
        //Example
        SortedSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("d");
        set.add("e");
        set.forEach(System.out::println);

        //Comparable
        SortedSet<Car> carSet = new TreeSet<>();
        carSet.add(new Car("BMW"));
        carSet.add(new Car("Mercedes"));
        carSet.forEach(System.out::println);

    }
}

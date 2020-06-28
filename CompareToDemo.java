import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CompareToDemo {
    public static void main(String[] args){
        List<Car> car = new ArrayList<>();
        car.add(new Car("Vinfast"));
        car.add(new Car("Volvo"));

        car.add(new Car("Toyota"));
        car.add(new Car("KIA"));
        Collections.sort(car);
        car.forEach(System.out::println);

    }
}

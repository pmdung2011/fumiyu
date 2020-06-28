public class Car  implements Comparable<Car>{
    private String brand;
    public Car(String b){
        this.brand = b;
    }

    @Override
    public int compareTo(Car car){
        return this.brand.compareTo(car.brand);
    }

    @Override
    public String toString(){
        return this.brand;
    }
}
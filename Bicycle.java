public class Bicycle {
    //The Bicycle class two fields
    public int gear;
    public int speed;

    //the Bicycle class has one constructor
    public Bicycle(int gear, int speed){
        this.gear = gear;
        this.speed = speed;
    }

    //the Bicycle class has three methods
    public void applyBrake(int decrement){
        speed -= decrement;
    }

    public void speedUp(int increment){
        speed += increment;
    }

    public String toString() {

         return ("No of gears are " + gear + "\n" + "Speed of bicycle is: " + speed);

    }

}

class MountainBike extends Bicycle{
    public int seatHeight;

    //constructor
    public MountainBike(int gear, int speed, int startHeight) {
        //invoking base-class(Bicycle) constructor
        super(gear, speed);
        this.seatHeight = startHeight;
    }

    public void setSeatHeight(int newHeight){
        seatHeight = newHeight;
    }

    //overriding toString() method of
    //Bicycle to print more info

    @Override
    public String toString() {
        return (super.toString() + "\nseat height is: " + seatHeight);
    }
}



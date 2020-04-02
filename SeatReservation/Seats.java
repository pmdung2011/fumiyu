public class Seats {
    private final String seatNumber;
    private boolean reserved = false;
    public Seats(String s) {
        this.seatNumber = s;
    }

    public String getSeatNumber(){
        return seatNumber;
    }

    public boolean reserve(){
        if(!this.reserved){
            this.reserved = true;
            System.out.println("Seat is reserved.");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cancel(){
        if(this.reserved){
            this.reserved = false;
            System.out.println("Reservation of seat " + seatNumber + " is cancelled");
            return true;
        }
        else{
            return false;
        }
    }
}

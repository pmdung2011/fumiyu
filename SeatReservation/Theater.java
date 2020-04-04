import java.util.ArrayList;
import java.util.List;

public class Theater {

    private final String theatreName;
    private List<Seats> seats = new ArrayList<>();

    public Theater(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for(char row ='A'; row <= lastRow;row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seats seat = new Seats(row + String.format("%2d",seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    private Seats seatSearch(String seatNum){
        Seats requestedSeat = null;
        for(Seats i : seats)
        {
            if(i.getSeatNumber().equals(seatNum)){
                requestedSeat = i;
            }
        }
        if (requestedSeat == null) {
            System.out.println("There is no seat with this number.");
        }
        return requestedSeat;
    }

    public boolean reserveSeat(String seatNum){
       Seats seat = seatSearch(seatNum);
       return seat.reserve();
    }

    public boolean cancelSeat(String seatNum){
        Seats seat = seatSearch(seatNum);
        return seat.cancel();
    }

    public void getSeats(){
        for(Seats seat : seats ){
            System.out.println(seat.getSeatNumber());
        }
    }
}

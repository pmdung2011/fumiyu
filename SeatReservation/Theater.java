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

    public boolean reserveSeat(String seatNum){
        Seats requestedSeat = null;
        for(Seats seat : seats){
            if(seat.getSeatNumber().equals(seatNum)){
                requestedSeat = seat;
                break;
            }
        }
        if(requestedSeat == null){
            System.out.println("There is no seat" + seatNum);
            return false;
        }
        return requestedSeat.reserve();
    }

    public void getSeats(){
        for(Seats seat : seats ){
            System.out.println(seat.getSeatNumber());
        }
    }

}

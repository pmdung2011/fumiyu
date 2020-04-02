import java.util.Scanner;

public class SeatReservation {

    public static void main(String[] args){

        Theater theatre = new Theater("Galaxy", 10, 15);
        theatre.getSeats();

        Scanner sc = new Scanner(System.in);
        String ans;
        boolean quit = false;
        while(quit == false){
            System.out.print("Enter seat number: ");
            ans = sc.next();
            if(theatre.reserveSeat(ans)){
                System.out.println("Please pay.");
            }
            else{
                System.out.println("Seat is taken.");
            }
            System.out.println("Continue ? (Y/N)");
            String rep = sc.next();
            if(rep == "N" || rep == "n"){
                quit = true;
            }
        }
    }
}

